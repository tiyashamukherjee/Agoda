package pagepackage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import base.ReadExcel;
import base.WriteExcel;
import io.qameta.allure.Step;

public class HotelListPage extends LandingPage{

	
	@Step("Setting  the browser.........")
	public void driverSetup(String mode,String gridbrowser) throws MalformedURLException {
		setUpDriver(mode,gridbrowser);
	}
	
	
	 @Step("Opening of the url.........")
	public void urlOpen(String websiteurlkey) throws InterruptedException {
		openUrl(websiteurlkey);
	}
	
	 
	 
	 @Step("Selecting the Location.........")
	public void stayLocation() throws IOException, InterruptedException {
		location();
	}
	 
	 
	 @Step("Selecting the stay dates........")
	public void stayTiming() {
		stayDates();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	 
	 public void searchButton() throws InterruptedException {
		 search();
	 }

	 
	 @Step("Selecting the min price........")
     public void minPrice() throws IOException {
	driver.findElement(PageObjectModel.budget).click();
	String minprice=ReadExcel.readExcel(1, 1);
	driver.findElement(PageObjectModel.minprice).sendKeys(Keys.CONTROL,"a", Keys.CLEAR);
	driver.findElement(PageObjectModel.minprice).sendKeys(minprice);
}

	 public void invalidMin() throws InterruptedException, IOException {
		 driver.findElement(PageObjectModel.budget).click();
		String min=ReadExcel.readExcel(1, 4);
		driver.findElement(PageObjectModel.minprice).sendKeys(Keys.CONTROL,"a", Keys.CLEAR);
		Thread.sleep(3000);
		driver.findElement(PageObjectModel.minprice).sendKeys(min);
		Thread.sleep(5000);
	
	 }
	 
	 @Step("Selecting the max price........")	 
     public void maxPrice() throws IOException, InterruptedException {
	String maxprice=ReadExcel.readExcel(1, 2);
	driver.findElement(PageObjectModel.maxprice).sendKeys(Keys.CONTROL,"a", Keys.CLEAR);
	driver.findElement(PageObjectModel.maxprice).sendKeys(maxprice);
	Thread.sleep(1000);
	//driver.findElement(PageObjectModel.maxprice).sendKeys(Keys.ENTER);
	     driver.findElement(PageObjectModel.enter).click();
		}

	 
	 @Step("Selecting the type of accomodation........")
    public void typeofAccomodation() throws InterruptedException {
	driver.findElement(PageObjectModel.more).click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement hotel=driver.findElement(PageObjectModel.propertytype);
	js.executeScript("arguments[0].scrollIntoView()",hotel);
	hotel.click();
	Thread.sleep(2000);
	driver.findElement(PageObjectModel.done).click();
	Thread.sleep(2000);
   
}

	 
	 @Step("Getting the total number of hotels........")
      public void totalHotels() throws IOException {
	String number=driver.findElement(PageObjectModel.totalhotel).getText();
	System.out.println(number);
	WriteExcel.writeExcelResults(number);
}

	 
	 @Step("Taking Screenshots........")
    public static String takeScreenshots() throws InterruptedException {
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	TakesScreenshot takescreenshot=(TakesScreenshot)driver;
	File sourceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
	File destFile=new File("C:\\Users\\ARUP\\eclipse-workspace\\Agoda\\Screenshots\\"+timeStamp+".png");
	String imagepath="C:\\Users\\ARUP\\eclipse-workspace\\Agoda\\Screenshots\\"+timeStamp+".png";
  try {
	FileUtils.copyFile(sourceFile, destFile);
} catch (IOException e) {
	e.printStackTrace();
}
  return imagepath;
}


	 
	 @Step("Closing the browser........")
     public void closeBrowser() {
	driver.close();
}

}
