package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testvalidlogin() {
		
		LoginPage loginpage= new LoginPage(driver);
		
		loginpage.Enterusername("admin@yourstore.com");
		loginpage.Enterpassword("admin");
		loginpage.clicklogin();
		System.out.println("Title of the page is:"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
}
