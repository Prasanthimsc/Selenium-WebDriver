package Day38;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest 
{
	
  WebDriver driver;
  
  @Parameters({"browser","url"})
  @BeforeClass
  void setup(String val, String appurl) 
  {
	  if(val.equals("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  }
	  
	  else if(val.equals("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  else if(val.equals("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }
	  driver.get(appurl);
  }
  
  @Test(priority=1)
  void testLogo()
  {
	 try
	 {
	 WebElement logo= driver.findElement(By.xpath("//div[@id='divLogo']//img"));
	 Assert.assertEquals(logo.isDisplayed(), true);
	 }
	 catch(Exception e)
	 {
		 Assert.fail();
	 }
	 
  }
  
  @Test(priority=2)
  void testTitle()
  {
	  Assert.assertEquals(driver.getTitle(),"OrangeHRM","Titles do not match");
  }
  
  @AfterClass
  void tearDown()
  {
	  driver.quit();
  }
}
