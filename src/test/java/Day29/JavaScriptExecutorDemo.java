package Day29;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.get("https://testautomationpractice.blogspot.com/");
	   driver.manage().window().maximize();
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   
	   driver.switchTo().frame(0);
	   driver.findElement(By.name("RESULT_TextField-1")).sendKeys("Tom");        //first name
		driver.findElement(By.name("RESULT_TextField-2")).sendKeys("John");      //last name
		driver.findElement(By.name("RESULT_TextField-3")).sendKeys("5432545");   //phone
		driver.findElement(By.name("RESULT_TextField-4")).sendKeys("India");     //country
		driver.findElement(By.name("RESULT_TextField-5")).sendKeys("Delhi");     //city
		driver.findElement(By.name("RESULT_TextField-6")).sendKeys("xyz@email.com");  //Email
		
		// male and female radio buttons
		WebElement malerd=driver.findElement(By.xpath("//input[@id='RESULT_RadioButton-7_0']"));
		js.executeScript("arguments[0].click();",malerd);
		
		WebElement sunday=driver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_0']"));
		js.executeScript("arguments[0].click();", sunday);
       
		WebElement thursday=driver.findElement(By.xpath("//input[@id='RESULT_CheckBox-8_4']"));
		js.executeScript("arguments[0].click();", thursday);
		
		Select time=new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-9']")));
		time.selectByVisibleText("Morning");

		WebElement submit=driver.findElement(By.xpath("//input[@id='FSsubmit']"));
		js.executeScript("arguments[0].click()",submit);
	}

}
