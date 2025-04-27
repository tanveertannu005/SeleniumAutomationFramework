package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidlogin() {

		Log.info("Starting Login Test...");
		LoginPage loginpage = new LoginPage(driver);
		Log.info("Adding Credentials...");
		loginpage.Enterusername("admin@yourstore.com");
		loginpage.Enterpassword("admin");
		loginpage.clicklogin();
		System.out.println("Title of the page is:" + driver.getTitle());

		Log.info("Verifying page title...");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login test completed...");
	}

}
