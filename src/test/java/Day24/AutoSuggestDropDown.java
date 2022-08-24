package Day24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> alloptions= driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']"));
	   
		System.out.println("Size : "+alloptions.size());
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("selenium webdriver"))
			{
				option.click();
				break;
			}
		}
		
		

	}

}
