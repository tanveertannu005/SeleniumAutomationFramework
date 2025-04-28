package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidlogin() {

		Log.info("Starting Login Test...");
		
		test=ExtentReportManager.createTest("Login Test");
		test.info("Naviagting to Url");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding Credentials...");
		test.info("Adding Credentials...");
		loginpage.Enterusername("admin@yourstore.com");
		loginpage.Enterpassword("admin");
		test.info("Clicking on Login Button");
		loginpage.clicklogin();
		System.out.println("Title of the page is:" + driver.getTitle());

		Log.info("Verifying page title...");
		test.info("Verifying Page");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login test completed...");
		test.pass("Login Succesfull");
	}
	@Test
	public void testLoginInvalidinvalidCredentials() {

		Log.info("Starting Login Test...");
		
		test=ExtentReportManager.createTest("Login Test With Invalid Credentials");
		test.info("Naviagting to Url");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding Credentials...");
		test.info("Adding Credentials...");
		loginpage.Enterusername("admin1234@yourstore.com");
		loginpage.Enterpassword("admin");
		test.info("Clicking on Login Button");
		loginpage.clicklogin();
		System.out.println("Title of the page is:" + driver.getTitle());

		Log.info("Verifying page title...");
		test.info("Verifying Page");
		Assert.assertEquals(driver.getTitle(), "Just a moment...123");
		Log.info("Login test completed...");
		test.pass("Login Failed");
	}
}
