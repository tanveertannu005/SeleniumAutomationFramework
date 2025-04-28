package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {

	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportsInstance();
	}

	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		Log.info("Starting Webdriver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to Url");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath=ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			test.fail("Test failed.. Screenshot attached. ",
		MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
			System.out.println();
		}
		
		
		
		if (driver != null) {
			Log.info("Closing the browser...");

			driver.quit();
		}
	}
}