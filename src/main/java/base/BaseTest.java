package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Log;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		Log.info("Starting Webdriver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to Url");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			Log.info("Closing the browser...");
		
		driver.quit();
	}
}
}