package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.DashboardPage;
import pageObjects.HomePage;


public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	public DashboardPage db;

	@BeforeClass(groups= {"sanity","master","regression"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException, IOException {

		//LOADING config.properties file
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());

		switch (br.toLowerCase()) {
		case "chrome":driver= new ChromeDriver();
				break;
		case "edge":driver= new EdgeDriver();
				break;
		case "firefox":driver= new FirefoxDriver();
				break;

		default:System.out.println("wrong browser");
				return;
		}


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));//reading url from properties file
		driver.manage().window().maximize();
		Thread.sleep(3000);
		HomePage hm= new HomePage(driver);
		hm.setUsername(p.getProperty("username"));//reading username from properties file
		hm.setPassword(p.getProperty("password"));//reading password from properties file
		hm.clickLogin();

		db= new DashboardPage(driver);
		Assert.assertEquals(db.dashboardTitlePresence(), true);

	}
	@AfterClass(groups= {"sanity","master","regression"})
	public void tearDown() {

		driver.quit();
	}

	public String randomString() {

		String randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabetic;
	}

	public String randomNumber() {
		String randomNumeric = RandomStringUtils.randomNumeric(10);
		return randomNumeric;

	}

	public String randomAlphaNumeric() {
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(8);
		return randomAlphanumeric;
	}
	
	public String captureScreen(String tName) throws IOException {
		
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots"+tName+"_"+timestamp;
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;

	}


}
