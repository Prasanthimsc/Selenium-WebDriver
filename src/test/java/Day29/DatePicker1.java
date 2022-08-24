	package Day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		 // method one
		
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/16/2022"); 
		
		//method two
		
		String month="March";
		String year="2023";
		String date="15";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true)
		{
			String M=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String Y=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(M.equals(month) && Y.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

}
