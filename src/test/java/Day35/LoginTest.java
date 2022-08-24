package Day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest
{
	WebDriver driver;
	
    @Test(priority=0)
	void openapp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/admin/");
	}
    
    @Test(priority=2)
	void login()
	{
		WebElement emailbox=driver.findElement(By.xpath("//input[@id='Email']"));
		emailbox.clear();
		emailbox.sendKeys("admin@yourstore.com");
		WebElement pwd=driver.findElement(By.xpath("//input[@id='Password']"));
		pwd.clear();
		pwd.sendKeys("admin");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		String act_lbl=driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
	if(act_lbl.equals("Dashboard"))
		{
			System.out.println("Login Successfull - Test Pass");
			Assert.assertTrue(true);
	
		}
		else
		{
			System.out.println("Test Fail");
			Assert.assertTrue(false);
		}  
		
	    
		//Assert.assertEquals(act_lbl,"Dashboard");
	}
    
    @Test(priority=30)
	void closeapp()
	{
		driver.close();
	}
}
