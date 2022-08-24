package Day25;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
		
		driver.findElement(By.xpath("//*[text()='Selenium']")).click();
		Thread.sleep(3000);
		
		List<WebElement> searchlinks=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		
      System.out.println("Size : "+searchlinks.size());
		
		for(WebElement link:searchlinks)
		{
			System.out.println(link.getText());
		}
		
		for(WebElement link:searchlinks)
		{
			link.click();
		}
		
		Set<String> windowids=driver.getWindowHandles();
		System.out.println("Page Title ---------------");		
		for(String id:windowids)
		{
			System.out.println(driver.switchTo().window(id).getTitle());
			 
		}
		for(String wid:windowids)
		{
			 String title=driver.switchTo().window(wid).getTitle();
			 if(title.equals("Selenium disulfide - Wikipedia")||title.equals("Selenium (software) - Wikipedia"))
			 {
				 driver.close();
			 }
			
			 			 
		}

	}

}
