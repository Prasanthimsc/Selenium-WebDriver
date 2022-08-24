package day40_pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{

	WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=1)
	void testLogo()
	{
		lp=new LoginPage(driver);
		Assert.assertEquals(lp.checkLogoPresence(),true);
	}
	
	@Test(priority=2)
	void test_login()
	{
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
		
	}
}
