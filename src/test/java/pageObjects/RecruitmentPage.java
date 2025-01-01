package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecruitmentPage extends BasePage{

	public RecruitmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addButton;
	
	public void clickAddButton() {

		addButton.click();
	}

}
