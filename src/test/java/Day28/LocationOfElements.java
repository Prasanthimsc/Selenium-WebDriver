package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocationOfElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
       System.out.println("Logo location :"+logo.getLocation());
       System.out.println("Logo location :"+logo.getLocation().getX());
       System.out.println("Logo location :"+logo.getLocation().getY());
	}

}
