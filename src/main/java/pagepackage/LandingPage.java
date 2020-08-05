package pagepackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import base.Base;
import base.ReadExcel;
import io.qameta.allure.Step;

public class LandingPage extends Base {

	 @Step("Setting  the browser.........")
	public void setUpDriver(String mode,String gridbrowser) throws MalformedURLException {
		invokeDriver( mode, gridbrowser);
	}
	
	 
	 @Step("Opening of the url.........")
	public void openUrl(String websiteurlkey) throws InterruptedException {
		String expected="Agoda | Booking Over 2 Million Hotels and Homes & Flights";
		openBrowser(websiteurlkey);
		Thread.sleep(4000);
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected,"Not on the correct webpage"); 
		
	}
	
	 
	 @Step("Selecting the Location.........")
	public void location() throws IOException, InterruptedException {
		//driver.findElement(PageObjectModel.hotels).click();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		String location=ReadExcel.readExcel(1, 0);
		driver.findElement(PageObjectModel.location).sendKeys(Keys.CONTROL,"a", Keys.CLEAR);
		driver.findElement(PageObjectModel.location).sendKeys(location);
		Thread.sleep(1000);
		driver.findElement(PageObjectModel.location1).click();
	}
	
	 public void invalidLocation() throws IOException, InterruptedException {
		 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		   Thread.sleep(2000);
			String invalidlocation=ReadExcel.readExcel(1, 3);
			driver.findElement(PageObjectModel.location).sendKeys(Keys.CONTROL,"a", Keys.CLEAR);
			driver.findElement(PageObjectModel.location).sendKeys(invalidlocation);		
	 }
	 
 
	 @Step("Selecting the stay dates........")
	public void stayDates() {
		driver.findElement(PageObjectModel.checkindate).click();
		driver.findElement(PageObjectModel.checkoutdate).click();
	 }
	 
	 
	 public String stayRooms() throws InterruptedException {
			
			driver.findElement(PageObjectModel.family).click();
			for(int i=0;i<=8;i++) {
			driver.findElement(PageObjectModel.plus).click();
			Thread.sleep(2000);
			}
			String number=driver.findElement(PageObjectModel.roomnum).getText();
			return number;
		}
	 public void search() throws InterruptedException {
		driver.findElement(PageObjectModel.search).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
}
