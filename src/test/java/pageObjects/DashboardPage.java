package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement profileArrowDown;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	WebElement dashboardTitle;

	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentIcon;

	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminIcon;

	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutButton;

	public boolean dashboardTitlePresence() {
		boolean displayed;
		try {
			displayed = dashboardTitle.isDisplayed();
		} catch (Exception e) {
			displayed=false;
		}
		
		return displayed;
	}

	public void clickAdminIcon() {

		//sol1
		adminIcon.click();


		//		//sol2
		//		adminIcon.submit();
		//		continueButton.submit();
		//		//sol3
		//		Actions act= new Actions(driver);
		//		act.moveToElement(adminIcon).click().perform();
		//		//sol4
		//		JavascriptExecutor js= (JavascriptExecutor)driver;
		//		js.executeScript("arguments[0].click();", adminIcon);
		//		//sol5
		//	 	adminIcon.sendKeys(Keys.RETURN);
		//		//sol6
		//		 WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
		//		 mywait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();



	}

	public void clickRecruitmentIcon() {

		recruitmentIcon.click();
	}

	public void clickDownArrow() {

		profileArrowDown.click();
	}

	public void clickLogout() {
		logoutButton.click();

	}
}
