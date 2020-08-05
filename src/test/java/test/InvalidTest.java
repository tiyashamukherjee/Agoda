package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
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

public class InvalidTest extends HotelListPage {

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
	
	@Test(priority = 0, description = "Opening of the browser")
	@Severity(SeverityLevel.NORMAL)
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
	
	@Test(priority = 1, description = "Invalid Location")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Putting invalid Location")
	@Story("Story Name:To check the response after an  invalid location")
	public void invalidLoc() throws InterruptedException, IOException {
		invalidLocation();
		String path=takeScreenshots();
		test.pass("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		driver.findElement(PageObjectModel.invalidloc).click();
		String path1=takeScreenshots();
		test.fail("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
		test.log(Status.FAIL,"Mumbai is getting selected by default for invalid input");
	}
	
	
	@Test(priority = 2, description = "Selection of dates for the stay")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Selection of dates for the stay")
	@Story("Story Name:To select the date for the stay")
	public void stay() throws Exception {
		log.info("***********SELECTION OF STAY DATES************");
		test.log(Status.INFO, "Test2 has started.");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.checkindate).isEnabled(), "Checkin is not enabled");
		Assert.assertTrue(driver.findElement(pagepackage.PageObjectModel.checkoutdate).isEnabled(), "Checkout is not enabled");
		stayTiming(); 
		test.log(Status.PASS, "Stay dates is selected");
	}
	
	
	@Test(priority = 3, description = "Number of rooms selected")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Selection of number of rooms")
	@Story("Story Name:To select the number of rooms")
	public void roomNumber() throws InterruptedException {
		String number=stayRooms();
		Assert.assertTrue(number.contains("10"),"Cannot select more than 9 rooms");
	}
	
	
	@Test(priority = 4, description = "Search button clicked")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Clicking search button")
	@Story("Story Name:To click search button")
	public void searchClick() throws InterruptedException {
		searchButton();
	}
	
	
	@Test(priority = 5, description = "Invalid Minimum price")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description:Giving ivalid inpu of min price")
	@Story("Story Name:To give invalid min price")
	public void invalidMinPrice() throws InterruptedException, IOException {
		invalidMin();
		String path=takeScreenshots();
		test.pass("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		maxPrice();
		String path1=takeScreenshots();
		test.fail("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
		test.log(Status.FAIL,"Error message not diplayed for special characters");
	}
	
	@AfterMethod(alwaysRun = true)
	public void flushAndEndTestMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "The test case " + result.getName() + " is failed");
			test.log(Status.FAIL, "The test case " + result.getThrowable() + " is failed");
			String path=takeScreenshots();
			test.fail("Screenshot Provided", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

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
