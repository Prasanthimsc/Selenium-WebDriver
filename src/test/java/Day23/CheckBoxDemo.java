package Day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("monday")).click();
		
		//finding number of checkboxes
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
		System.out.println("Number of check boxes: "+checkboxes.size());
		
		//selecting all the checkboxes
	/*	for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		} */
		
		
		
		for(WebElement chkbox:checkboxes)
		{
			chkbox.click();
		}  
		
		Thread.sleep(5000);
		for(WebElement chkbox:checkboxes)
		{
			chkbox.click();
		}  
		
		
		//selecting the last two checkboxes
		
	/*	for(int i=5;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		} */
		
		//selecting first two checkboxes
	/*	for(int i=0;i<2;i++)
		{
			checkboxes.get(i).click();
		} */
		
		
		
		
		//driver.close();
	}

}
