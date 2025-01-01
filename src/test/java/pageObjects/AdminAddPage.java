package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AdminAddPage extends BasePage {
	
	Actions act;

	public AdminAddPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]" )
	WebElement userRoleArrow;
	
	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	WebElement statusArrow;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
	WebElement statusArrowfull;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeNameEle;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement userNameEle;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement passwordEle;
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement conPassEle;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveEle;
	
	public void clickUserRoleArrow() {

		userRoleArrow.click();
	}
	
	public void selectUserRoleAdmin() {

		act= new Actions(driver);
		act.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void clickStatusArrow() {
		statusArrowfull.click();
	}
	
	public void selectStatus() {
		
		act.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

	}
	
	public void setEmployeeName(String emplName) {
		employeeNameEle.sendKeys(emplName);
	}
	
	public void setUserName(String userName) {
		userNameEle.sendKeys(userName);
	}

	public void setPassword(String pass) {
		passwordEle.sendKeys(pass);
	}
	
	public void setConPassword(String conPass) {
		conPassEle.sendKeys(conPass);

	}
	
	public void clickSave() {
		saveEle.click();

	}
}
