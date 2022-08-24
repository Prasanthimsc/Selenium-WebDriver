package Day24;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopupHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myalert=driver.switchTo().alert();
		
		System.out.println("Alert Message : "+myalert.getText()); //
		
		myalert.sendKeys("Welcome");
		myalert.accept();  // closes alert window by 'OK' button
		
		//myalert.dismiss();
		WebElement text=driver.findElement(By.id("result"));
		System.out.println(text.getText());
		
		

	}

}
