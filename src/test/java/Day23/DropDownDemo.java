package Day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		
		//identifying and capturing dropdown
		//WebElement dropdowncntry=driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select drpcntry=new Select(driver.findElement(By.xpath("//select[@id='input-country']")));
		
		//selecting option from dropdown
		
		//drpcntry.selectByVisibleText("India");   //selecting by visibletext
		
		//drpcntry.selectByValue("2");            //Albania should be selected
		
		//drpcntry.selectByIndex(6);     //Angola should be selected
		
		//finding number of options in a dropdown
		
		List<WebElement> alloptions=drpcntry.getOptions();
		
		System.out.println("Total options : "+alloptions.size());
		
		
		//printing countries in console
	/*	for(int i=0;i<alloptions.size();i++)
		{
			System.out.println(alloptions.get(i).getText());
		}  */
		
		for(WebElement option:alloptions)
		{
			System.out.println(option.getText());
		}
		
}

}
