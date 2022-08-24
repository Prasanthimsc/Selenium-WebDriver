package Day22;

import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		
	//	driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3")).click();
		
		
		
		
   // usage
     WebElement weblink = mywait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3"));
     }
   });
		 
       weblink.click();

	}

}
