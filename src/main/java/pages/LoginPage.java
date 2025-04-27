package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Log;

public class LoginPage {
	private WebDriver driver;
	
	private By usernameTextbox=By.id("Email");
	private By passwordTextbox=By.id("Password");
    private By Login=By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");

    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    }
    public void Enterusername(String username) {
    	driver.findElement(usernameTextbox).clear();
    	
    	driver.findElement(usernameTextbox).sendKeys(username);
    	
    	
    }
    public void Enterpassword(String password) {
    	driver.findElement(passwordTextbox).clear();
    	driver.findElement(passwordTextbox).sendKeys(password);
    }
    
    public void clicklogin() {
    	Log.info("Clicking Login Button...");
  driver.findElement(Login).click();  	
    }
}



