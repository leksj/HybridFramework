package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentAddPage extends BasePage{

	public RecruitmentAddPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="firstName")
	WebElement firstNameEle;
	
	@FindBy(name="lastName")
	WebElement lastNameEle;
	
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
	WebElement emailEle;
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	WebElement contactNumberEle;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveEle;
	
	
	public void setFirstName(String fName) {

		firstNameEle.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		lastNameEle.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		 emailEle.sendKeys(email);

	}
	
	public void setPhoneNumber(String phNo) {

		contactNumberEle.sendKeys(phNo);
	}
	
	public void clickSave() {

		saveEle.click();
	}
}
