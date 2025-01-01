package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AdminAddPage;
import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;

public class TC002_VerifyAddUserInAdmin {
	
	WebDriver driver;
	DashboardPage db;
	@BeforeClass
	public void setup() throws InterruptedException {

		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		HomePage hm= new HomePage(driver);
		hm.setUsername("Admin");
		hm.setPassword("admin123");
		hm.clickLogin();
		
		db= new DashboardPage(driver);
		Assert.assertEquals(db.dashboardTitlePresence(), true);

	}
	@Test
	public void verifyAddUserInAdmin() throws InterruptedException {
		db.clickAdminIcon();
		AdminPage admin= new AdminPage(driver);
		admin.clickAdd();
		Thread.sleep(3000);
		AdminAddPage adminAdd= new AdminAddPage(driver);
		adminAdd.clickUserRoleArrow();
		Thread.sleep(2000);
		adminAdd.selectUserRoleAdmin();
		Thread.sleep(2000);
		adminAdd.clickStatusArrow();
		Thread.sleep(2000);
		adminAdd.selectStatus();
		Thread.sleep(2000);
		adminAdd.setEmployeeName("gsdgjk");
//		Thread.sleep(2000); 
//		adminAdd.setUserName("gjhghj");
//		Thread.sleep(2000);
//		adminAdd.setPassword("abc123");
//		Thread.sleep(2000);
//		adminAdd.setConPassword("abc123");
//		Thread.sleep(2000);
//		adminAdd.clickSave();
		

	}

}
