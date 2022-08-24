package Day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BingAutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("java");
		
		Thread.sleep(3000);
		List<WebElement> alloptions=driver.findElements(By.xpath("//li[@role='option']"));
		System.out.println("Size : "+alloptions.size());
		
		for(WebElement option:alloptions)
		{
			System.out.println(option.getText());
		}
		
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("java download"))
			{
				option.click();
			}
		}

	}

}
