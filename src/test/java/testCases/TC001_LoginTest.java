package testCases;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import utilities.DataProviders;

public class TC001_LoginTest {
	
	WebDriver driver;
	
	@BeforeClass (groups= {"datadriven","master"})
	public void setup() {
		
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

	}
	
	@AfterClass(groups= {"datadriven","master"})
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	@Test(dataProvider = "loginData",dataProviderClass =DataProviders.class ,groups= {"datadriven","master"})
	public void verifyLogin(String username,String pass,String status) throws InterruptedException {
		
		//System.out.println("inside verifyLogin method");
		try {
			HomePage hm= new HomePage(driver);
			hm.setUsername(username);
			hm.setPassword(pass);
			hm.clickLogin();
			DashboardPage db= new DashboardPage(driver);

			if (status.equalsIgnoreCase("valid")) {
				
				if(db.dashboardTitlePresence())
				{
					db.clickDownArrow();
					Thread.sleep(2000);
					db.clickLogout();
				
					Assert.assertTrue(true);
				
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if (status.equalsIgnoreCase("invalid")) {
				
				if(db.dashboardTitlePresence())
				{
					db.clickDownArrow();
					Thread.sleep(2000);
					db.clickLogout();
				
					Assert.assertTrue(false);
				
				}
				else {
					Assert.assertTrue(true);
				}

				
			}
			
//			Assert.assertEquals(db.dashboardTitlePresence(), true,"Login Failed");

				} 
		
		catch (Exception e) {
			Assert.fail("Login Failed", e);
		}
 
	}
	
}
