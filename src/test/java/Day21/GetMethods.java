package Day21;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class GetMethods {

	public static void main(String[] args) {
		
		
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
        System.out.println("Title of the page is: "+driver.getTitle());
        
        System.out.println("Current URL is: "+driver.getCurrentUrl());
      //  System.out.println("Page Souce is.......................");
      //  System.out.println(driver.getPageSource());
        System.out.println("Window ID is: "+driver.getWindowHandle());  
        
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windowIds=driver.getWindowHandles();
        for(String wid:windowIds)
        {
        	System.out.println(wid);
        }
	}

}
