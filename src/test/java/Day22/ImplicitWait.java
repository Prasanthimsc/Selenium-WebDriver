package Day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		d.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		
		d.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3")).click();

	}

}
