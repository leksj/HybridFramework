package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.RecruitmentAddPage;
import pageObjects.RecruitmentPage;

public class TC003_RecruitmentAdd extends BaseClass {

	

	@Test(groups= {"sanity","regression","master"})
	public void verifyRecruitmentAdd() throws InterruptedException {

		logger.info("***********TC003_RecruitmentAdd********");

		db.clickRecruitmentIcon();
		logger.info("clicked on Recruitment Icon");
		RecruitmentPage rp= new RecruitmentPage(driver);
		rp.clickAddButton();
		RecruitmentAddPage RAdd= new RecruitmentAddPage(driver);
		RAdd.setFirstName(randomString().toUpperCase());
		RAdd.setLastName(randomString().toUpperCase());
		RAdd.setEmail(randomString()+"@gmail.com");
		RAdd.setPhoneNumber(randomNumber());
		Thread.sleep(5000);
		RAdd.clickSave();
		logger.info("clicked on Save Icon");

		Thread.sleep(3000);
	}


}
