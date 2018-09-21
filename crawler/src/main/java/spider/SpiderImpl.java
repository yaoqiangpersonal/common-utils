package spider;


import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class SpiderImpl extends Spider {
	public SpiderImpl(PageProcessor pageProcessor) {
		super(pageProcessor);
	}
}
