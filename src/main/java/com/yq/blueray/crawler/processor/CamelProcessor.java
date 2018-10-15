package com.yq.blueray.crawler.processor;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.blueray.crawler.po.Bluray;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CamelProcessor implements PageProcessor {

	private Site site = Site.me()
			.setRetryTimes(3)
			.setSleepTime(500)
			.setTimeOut(5000);

	//更新mapper
	private final BaseMapper<Bluray> mapper;

	private final Map<String,Bluray> blurays;

	private final List<Bluray> isProportionatelist = new LinkedList<>();
	private final List<Bluray> isAcceptablePrice = new LinkedList<>();

	private final Pattern p = Pattern.compile("\\d+");

	public CamelProcessor(BaseMapper<Bluray> mapper,Map<String,Bluray> blurays){
		this.blurays = blurays;
		this.mapper = mapper;
	}

	public List<Bluray> getProportionatelist(){
		return isProportionatelist;
	}

	public List<Bluray> getAcceptablePrice(){
		return isAcceptablePrice;
	}

	@Override
    public void process(Page page) {
		Html html = page.getHtml();
		Bluray b = new Bluray();

		String url = page.getUrl().get();
		String asin = url.substring(url.lastIndexOf("/") +1,url.length());
		b.setAsin(asin);

		Selectable tbody = html.$("#section_amazon .pad .product_pane tbody");

		String sPrice = tbody.$("tr:eq(0)").$("td:eq(1)").get();
		BigDecimal currentPrice = bigCreate(priceHandler(sPrice));
		//System.out.println("CurrentPrice:" + sPrice);
        b.setCurrentPrice(bigCreate(priceHandler(sPrice)));

		sPrice = tbody.$("tr.highest_price td:eq(1)").get();
		//System.out.println("HighestPrice:" + sPrice);
		b.setHighestPrice(bigCreate(priceHandler(sPrice)));

		sPrice = tbody.$("tr.lowest_price td:eq(1)").get();
		//System.out.println("LowestPrice:" + sPrice);
		BigDecimal lowestPrice = bigCreate(priceHandler(sPrice));

		if(isAcceptablePrice(currentPrice,url)) {
			isAcceptablePrice.add(blurays.get(url));
		}else if(isProportionate(lowestPrice,currentPrice)){
			isProportionatelist.add(blurays.get(url));
		}

		b.setLowestPrice(bigCreate(priceHandler(sPrice)));
		b.setUpdateTime(new Date(System.currentTimeMillis()));
		mapper.update(b,createWrapper(b));
    }

	/**
	 * 符合比例
	 *
	 * @param lowestPrice 最低价格
	 * @param currentPrice 最高价格
	 * @return
	 */
    private boolean isProportionate(BigDecimal lowestPrice,BigDecimal currentPrice){
    	if(lowestPrice != null && currentPrice != null)
			return currentPrice.divide(lowestPrice,5, RoundingMode.HALF_EVEN).compareTo(new BigDecimal(1.05))<1;
    	return false;
	}

	/**
	 * 符合可接受价格
	 *
	 * @param currentPrice
	 * @param url
	 * @return
	 */
	private boolean isAcceptablePrice(BigDecimal currentPrice,String url){
		BigDecimal b = blurays.get(url).getAcceptablePrice();
		if(currentPrice != null && b != null)
			return currentPrice.compareTo(b) >= 1;
		return false;
	}


	/**
	 * 创建更新条件
	 *
	 * @param asin
	 *
	 * @return
	 */
    private Wrapper<Bluray> createWrapper(Bluray asin){
		UpdateWrapper<Bluray> wrapper = new UpdateWrapper<>();
		wrapper.eq("asin",asin.getAsin());
		return wrapper;
	}

	/**
	 * 通过String 创建 bigDecimal
	 *
	 * @param s
	 *
	 * @return
	 */
    private BigDecimal bigCreate(String s){
		if(StringUtils.isNotBlank(s))
			return new BigDecimal(s);
		return null;
	}

	/**
	 * 价格处理
	 *
	 * @param s
	 * @return
	 */
    private String priceHandler(String s){
		Matcher m = p.matcher(s);
		if (StringUtils.isNotBlank(s) && m.find())
			return s.replaceAll("[$€£]", "").replaceAll(",", ".").replaceAll("<.+?>", "");
		return null;
	}

	/**
	 * site设置
	 *
	 * @return
	 */
	@Override
	public Site getSite() {
		site.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
		return site;
	}
}
