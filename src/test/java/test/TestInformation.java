package test;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import base.ExtentReportManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pagepackage.HotelListPage;
import pagepackage.PageObjectModel;

public class TestInformation extends HotelListPage{

	
	public ExtentReports report= ExtentReportManager.getReportInstance();
	public ExtentTest test;
	public static String browsername;
	
	
	Logger log = Logger.getLogger(TestInformation.class);
	
	@Parameters("gridbrowser")
	@BeforeTest(alwaysRun = true)
	public void beforeTest(String gridbrowser) throws Exception, MalformedURLException {
		log.info("***********INVOKING OF THE DESIRED DRIVER*************");
		driverSetup("mode", gridbrowser);
		browsername = gridbrowser;
	}
	
	
	@Test(priority = 0, groups ={"Regression Test","Smoke Test"}, description = "Opening of the browser")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description:Opening of the browser")
	@Story("Story Name:To check the opening of the browser")
	public void Test0() throws Exception {
		log.info("***************OPENING OF THE BROWSER****************");
	if(browsername.equalsIgnoreCase("Firefox")) {
			 test=report.createTest("Mozilla-Test");
			 } 
		 else if(browsername.equalsIgnoreCase("chrome")) { 
			  test=report.createTest("Chrome-Test");
			  }
		test.log(Status.INFO, "Test0 has started.");
		urlOpen("websiteURL");
		test.log(Status.PASS, "Browser has opened");
	}
	
	
	
	@Test(priority = 1, groups ="Regression Test", description = "Selection of location")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Selection of location")
	@Story("Story Name:To select the particular location")
	public void Test1() throws Exception {
		log.info("***********SELECTION OF LOCATION*************");
		test.log(Status.INFO, "Test1 has started.");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.location).isEnabled(), "Location is not Enabled");
		stayLocation();  
		test.log(Status.PASS, "Location is selected");
	}
	
	
	
	
	@Test(priority = 2, groups ="Regression Test", description = "Selection of dates for the stay")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Selection of dates for the stay")
	@Story("Story Name:To select the date for the stay")
	public void Test2() throws Exception {
		log.info("***********SELECTION OF STAY DATES************");
		test.log(Status.INFO, "Test2 has started.");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.checkindate).isEnabled(), "Checkin is not enabled");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.checkoutdate).isEnabled(), "Checkout is not enabled");
		stayTiming(); 
		test.log(Status.PASS, "Stay dates is selected");
		searchButton();
		test.log(Status.PASS, "Search button is clicked");
	}
	
	
	
	
	@Test(priority = 3, groups ="Regression Test", description = "Selection of min price")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description:Selection of min price")
	@Story("Story Name:To select the minimum price")
	public void Test3() throws Exception {
		log.info("***********SELECTION OF MIN PRICE************");
		test.log(Status.INFO, "Test3 has started.");
		minPrice(); 
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.minprice).isEnabled(), "Min price is not Selected");
		test.log(Status.PASS, "Min price is selected");
	}

	
	
	
	@Test(priority = 4, groups ="Regression Test", description = "Selection of max price")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description:Selection of max price")
	@Story("Story Name:To select the maximum price")
	public void Test4() throws Exception {
		log.info("***********SELECTION OF MAX PRICE************");
		test.log(Status.INFO, "Test4 has started.");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.maxprice).isEnabled(), "Max price is not Selected");
		maxPrice(); 
		test.log(Status.PASS, "Max price is selected");
	}

	
	
	
	@Test(priority = 5, groups ="Regression Test", description = "Selection of type of accomodation")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Selection of type of accomodation")
	@Story("Story Name:To select the type of Accomodation")
	public void Test5() throws Exception {
		log.info("***********SELECTION OF TYPE OF ACCOMODATION************");
		test.log(Status.INFO, "Test5 has started.");
		typeofAccomodation();
	    test.log(Status.PASS, "Type of accomodation is selected");
	}

	
	
	
	@Test(priority = 6, groups ="Regression Test", description = "To get the total number of hotels")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:To get the total number of hotels")
	@Story("Story Name:To get the total number of hotels")
	public void Test6() throws Exception {
		log.info("***********TO GET THE TOTAL NUMBER OF HOTELS************");
		test.log(Status.INFO, "Test6 has started.");
		totalHotels();
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.totalhotel).isDisplayed(), "Total number of hotels is not displayed");
		test.log(Status.PASS, "Type of accomodation is selected");
	}

	
	
	
	
	
	@Test(priority = 7, groups ="Regression Test", description = "Capturing Screenshots")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Capturing Screenshots")
	@Story("Story Name:To Capture the Screenshots")
	public void Screenshots() throws IOException, InterruptedException {
	log.info("***********TAKING SCREENSHOTS*************");
    test.log(Status.INFO, "Test7 has started.");
    JavascriptExecutor js=(JavascriptExecutor)driver;
	//WebElement e=driver.findElement(PageObjectModel.scrollup);
	js.executeScript("scroll(0,-10)");
	Thread.sleep(3000);
	String path = takeScreenshots();
	test.log(Status.PASS, "Screenshot taken");
	test.pass("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
}
	
	@Test(priority = 1, groups ="Smoke Test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Location is enabled or not")
	@Story("Story Name:To check location is enabled or not")
	public void smoke1() {
		log.info("============== To check whether the location is enabled or not ==================");
		test.log(Status.INFO, "Whether location textbox is enabled or not");
		Assert.assertTrue(driver.findElement(PageObjectModel.location).isEnabled(),"Location is not enabled");;
		System.out.println("Is location tab enabled? "+driver.findElement(PageObjectModel.location).isEnabled());
		System.out.println();
		System.out.println();
		test.log(Status.PASS, "The location textbox is enabled");	
	}

	
	
	@Test(priority = 2, groups ="Smoke Test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Search button is enabled or not")
	@Story("Story Name:To check whether search button is enabled or not")
	public void smoke2() {
		log.info("============== To check whether search button is enabled or not ==================");
		test.log(Status.INFO, "Whether search button is enabled or not");
		Assert.assertTrue(driver.findElement(PageObjectModel.search).isEnabled(),"Search is not enabled");;
		System.out.println("Is search button enabled? "+driver.findElement(PageObjectModel.search).isEnabled());
		System.out.println();
		System.out.println();
		test.log(Status.PASS, "The search button is enabled");	
	}
	
	
	@Test(priority = 3, groups ="Smoke Test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Checking whether checkin is enabled or not")
	@Story("Story Name:To check whether checkin is enabled or not")
	public void smoke3() {
		log.info("============== To check whether checkin is enabled or not ==================");
		test.log(Status.INFO, "Whether checkin is enabled or not");
		Assert.assertTrue(driver.findElement(PageObjectModel.checkinbox).isEnabled(),"Checkin is not enabled");;
		System.out.println("Is checkin enabled? "+driver.findElement(PageObjectModel.checkinbox).isEnabled());
		System.out.println();
		System.out.println();
		test.log(Status.PASS, "The checkin is enabled");	
	}
	
	
	
	@Test(priority = 4, groups ="Smoke Test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Checking whether checkout is enabled or not")
	@Story("Story Name:To check whether checkout is enabled or not")
	public void smoke4() {
		log.info("============== To check whether checkout is enabled or not ==================");
		test.log(Status.INFO, "Whether checkout is enabled or not");
		Assert.assertTrue(driver.findElement(PageObjectModel.checkoutbox).isEnabled(),"Checkout is not enabled");;
		System.out.println("Is checkout enabled? "+driver.findElement(PageObjectModel.checkoutbox).isEnabled());
		System.out.println();
		System.out.println();
		test.log(Status.PASS, "The checkout is enabled");	
	}
	
	


	@AfterMethod(alwaysRun = true)
	public void flushAndEndTestMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "The test case " + result.getName() + " is failed");
			test.log(Status.FAIL, "The test case " + result.getThrowable() + " is failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "The test case " + result.getName() + " is skipped");
		}

	}

	
	@AfterTest(alwaysRun = true)
	public void close() {
		log.info("***********CLOSING OF THE  BROWSER*************");
		report.flush();
	    closeBrowser();
	}

	
	
	

}


