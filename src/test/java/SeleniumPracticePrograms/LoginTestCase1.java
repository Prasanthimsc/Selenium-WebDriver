package SeleniumPracticePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase1 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver wd=new ChromeDriver();
		
		wd.get("https://opensource-demo.orangehrmlive.com");
		wd.manage().window().maximize();
		
		wd.findElement(By.name("txtUsername")).sendKeys("admin");
		wd.findElement(By.name("txtPassword")).sendKeys("admin123");
		wd.findElement(By.id("btnLogin")).click();
		
		String exptitle="OrangeHRM";
		String orgtitle=wd.getTitle();
		if(exptitle.equals(orgtitle))
		{
			System.out.println("Test Pass");
		}
		
		else
		{
			System.out.println("Test Fail");
		}
		
		
       
	}

}
