package processor;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.commons.lang3.StringUtils;
import po.Bluray;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelProcessor implements PageProcessor {

	private Site site = Site.me()
			.setRetryTimes(3)
			.setSleepTime(500)
			.setTimeOut(5000);
	
	private final BaseMapper<Bluray> mapper;

	private final Pattern p = Pattern.compile("\\d+");

	public CamelProcessor(BaseMapper<Bluray> mapper){
		this.mapper = mapper;
	}

	@Override
    public void process(Page page) {
		Html html = page.getHtml();
		Bluray b = new Bluray();
		String url = page.getUrl().get();
		System.out.println(url.substring(url.lastIndexOf("/") +1,url.length()));
		b.setAsin(url.substring(url.lastIndexOf("/") +1,url.length()));

		Selectable tbody = html.$("#section_amazon .pad .product_pane tbody");

		String sPrice = tbody.$("tr:eq(0)").$("td:eq(1)").get();
		System.out.println("CurrentPrice:" + sPrice);
        b.setCurrentPrice(bigCreate(priceHandler(sPrice)));

		sPrice = tbody.$("tr.highest_price td:eq(1)").get();
		System.out.println("HighestPrice:" + sPrice);
		b.setHighestPrice(bigCreate(priceHandler(sPrice)));

		sPrice = tbody.$("tr.lowest_price td:eq(1)").get();
		System.out.println("LowestPrice:" + sPrice);
		b.setLowestPrice(bigCreate(priceHandler(sPrice)));
		b.setUpdateTime(new Date(System.currentTimeMillis()));
		mapper.update(b,createWrapper(b));

    }

    private Wrapper<Bluray> createWrapper(Bluray asin){
		UpdateWrapper<Bluray> wrapper = new UpdateWrapper<>();
		wrapper.eq("asin",asin.getAsin());
		return wrapper;
	}

    private BigDecimal bigCreate(String s){
		if(StringUtils.isNotBlank(s))
			return new BigDecimal(s);
		return null;
	}

    private String priceHandler(String s){
		Matcher m = p.matcher(s);
		if (StringUtils.isNotBlank(s) && m.find())
			return s.replaceAll("[$€£]", "").replaceAll(",", ".").replaceAll("<.+?>", "");
		return null;
	}

	@Override
	public Site getSite() {
		site.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
		return site;
	}
}
