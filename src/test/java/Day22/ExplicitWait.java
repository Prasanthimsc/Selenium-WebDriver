package Day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		WebDriverWait mywait=new WebDriverWait(d,Duration.ofSeconds(10));
		
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		d.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		
		try
		{
		WebElement weblink=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3")));
		weblink.click();
		}
		catch(Exception e)
		{
			System.out.println("Element not found");
		}
		

	}

}
