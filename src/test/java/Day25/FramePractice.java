package Day25;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		driver.findElement(By.name("RESULT_TextField-1")).sendKeys("Tom");
		driver.findElement(By.name("RESULT_TextField-2")).sendKeys("John");
		driver.findElement(By.name("RESULT_TextField-3")).sendKeys("5432545");
		driver.findElement(By.name("RESULT_TextField-4")).sendKeys("India");
		driver.findElement(By.name("RESULT_TextField-5")).sendKeys("Delhi");
		driver.findElement(By.name("RESULT_TextField-6")).sendKeys("xyz@email.com");
		
		int rows=driver.findElements(By.xpath("//div[@id='q26']//table[@class='inline_grid choices']//tbody/tr")).size();
		
		System.out.println("rows = "+rows);
		
		//WebElement malerd=driver.findElement(By.xpath("//div[@id='q26']//table[@class='inline_grid choices']//tbody/tr/td/input[@id='RESULT_RadioButton-7_0']"));
		//malerd.click();
		
		
		WebElement femalerd=driver.findElement(By.xpath("//div[@id='q26']//table[@class='inline_grid choices']//tbody/tr/td/input[@id='RESULT_RadioButton-7_1']"));
		femalerd.click();
		}
}	

