package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "Email")
	WebElement usernameTextbox;

	@FindBy(id = "Password")
	WebElement passwordTextbox;

	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")

	WebElement Login;

	// ABOVE WE ARE PAGE FACTORY BELOW IS POM BOTH ARE USEFULL BUT PAGE FACTORY IS
	// BEST
	/*
	 * private By usernameTextbox=By.id("Email"); private By
	 * passwordTextbox=By.id("Password"); private By Login=By.xpath(
	 * "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	 * 
	 * public LoginPage(WebDriver driver) { this.driver=driver; } public void
	 * Enterusername(String username) { driver.findElement(usernameTextbox).clear();
	 * 
	 * driver.findElement(usernameTextbox).sendKeys(username);
	 * 
	 * 
	 * } public void Enterpassword(String password) {
	 * driver.findElement(passwordTextbox).clear();
	 * driver.findElement(passwordTextbox).sendKeys(password); }
	 * 
	 * public void clicklogin() { Log.info("Clicking Login Button...");
	 * driver.findElement(Login).click(); }
	 */
	public LoginPage(WebDriver driver) { 
		this.driver=driver; 
		PageFactory.initElements( driver, this);
	}
	public void Enterusername(String username) {
		usernameTextbox.clear();
		usernameTextbox.sendKeys(username);
		
	}
	 public void Enterpassword(String password) {
		 
		 passwordTextbox.clear();
		 passwordTextbox.sendKeys(password);
	 }
	 public void clicklogin() {
		 
		 Login.click();
	 }
}

