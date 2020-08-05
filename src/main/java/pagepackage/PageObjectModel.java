package pagepackage;

import org.openqa.selenium.By;

public class PageObjectModel {

	public static final By hotels=By.xpath("//span[text()='Hotels & Homes']");
	public static final By location=By.cssSelector(".SearchBoxTextEditor");
	public static final By checkinbox=By.cssSelector("div.IconBox:nth-child(2) > div:nth-child(1)");
	public static final By checkoutbox=By.cssSelector("div.IconBox:nth-child(3) > div:nth-child(1)");
	public static final By location1=By.cssSelector("li.Suggestion:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)");
	public static final By checkindate=By.cssSelector("div.DayPicker-Month:nth-child(1) > div:nth-child(3) > div:nth-child(4) > div:nth-child(1) > span:nth-child(1)");
	public static final By checkoutdate=By.cssSelector("div.DayPicker-Month:nth-child(1) > div:nth-child(3) > div:nth-child(4) > div:nth-child(3) > span:nth-child(1)");
	public static final By search=By.xpath("//button[@data-element-name='search-button']");
	public static final By budget=By.cssSelector("div.PillDropdown:nth-child(3) > button:nth-child(1) > i:nth-child(2)");
	public static final By minprice=By.cssSelector("#price_box_0");
	public static final By maxprice=By.cssSelector("#price_box_1");
	public static final By enter=By.cssSelector(".PriceFilter-searchbox");
	public static final By more=By.xpath("//span[text()='More']");
	public static final By propertytype=By.xpath("//span[text()='Hotel']");
	public static final By done=By.xpath("//span[text()='Done']");
	public static final By totalhotel=By.cssSelector(".SearchBoxTextDescription--searchText > div:nth-child(2)");
	public static final By scrollup=By.cssSelector("i.ficon-search-box:nth-child(1)");
	public static final By invalidloc=By.cssSelector("li.Suggestion:nth-child(1) > ul:nth-child(1) > li:nth-child(1)");
	public static final By family=By.cssSelector("div.TravellerSegment:nth-child(3) > div:nth-child(1)");
	public static final By plus=By.cssSelector("div.sc-prorn:nth-child(1) > span:nth-child(4) > svg:nth-child(1)");
	public static final By roomnum=By.cssSelector("div.sc-prorn:nth-child(1) > span:nth-child(2)");
	
}
