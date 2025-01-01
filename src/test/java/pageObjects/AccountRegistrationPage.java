package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	//WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(name = "firstname")
	WebElement firstName;
	@FindBy(name = "lastname")
	WebElement lastname;
	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueButton;
	
	public void setFirstName(WebElement firstName) {
		firstName.sendKeys("fjh");
	}
	public void setLastname(WebElement lastname) {
		lastname.sendKeys("gfjhgs");
	}
	public void setEmail(WebElement email) {
		
		email.sendKeys("hhfkjsh@gmail.com");
	}
	
	public void setPassword(WebElement password) {
		
		password.sendKeys("dvjhgsjh");
	}
	
	public void clickContinue() {
		//sol1 
		continueButton.click(); 
//		//sol2
//		continueButton.submit();
//		//sol3
//		Actions act= new Actions(driver);
//		act.moveToElement(continueButton).click().perform();
//		
//		//sol4
//		
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", continueButton);
//		
//		//sol5
//		continueButton.sendKeys(Keys.RETURN);
//		
//		//sol6
//		 WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
//		 mywait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
		

	}
	
	
	
	

}
