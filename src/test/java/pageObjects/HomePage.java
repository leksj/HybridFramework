package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}
//	WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	public void setUsername(String userName) throws InterruptedException {
//		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.clear();
		Thread.sleep(2000);
		username.sendKeys(userName);
	}
	
	public void setPassword(String pass) throws InterruptedException {
		password.clear();
		Thread.sleep(2000);
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}

}
