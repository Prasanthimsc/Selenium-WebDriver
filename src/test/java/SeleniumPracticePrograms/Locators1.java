package SeleniumPracticePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators1 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php");
		d.manage().window().maximize();
		d.findElement(By.name("search_query")).sendKeys("T-shirt");
		d.findElement(By.name("submit_search")).click();
		d.findElement(By.linkText("Printed Chiffon Dress")).click();
		
	}

}
