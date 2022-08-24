package Day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		String month="Jan";
		String year="2021";
		String date="28";
		
		driver.findElement(By.xpath("(//input[@id='dob'])")).click();
		Select drpmonth=new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		drpmonth.selectByVisibleText(month);
		
		Select drpyear=new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		drpyear.selectByVisibleText(year);
		
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
			}
		}
		
		

	}

}
