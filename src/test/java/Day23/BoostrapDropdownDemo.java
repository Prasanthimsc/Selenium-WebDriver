package Day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BoostrapDropdownDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		//capture all the options and print them
		
		List<WebElement> alloptions=driver.findElements(By.xpath("//select[@id='input-country']/option"));
	/*	for(WebElement option:alloptions)
		{
			System.out.println(option.getText());
		} */
		
		//find total number of options
		//System.out.println("total options: "+alloptions.size());
		
		//select option from dropdown
		
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("India"))
			{
		      option.click();
		      break;
			}
			
		}
		

	}

}
