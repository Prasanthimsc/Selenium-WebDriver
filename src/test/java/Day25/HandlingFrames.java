package Day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html"); 
     driver.manage().window().maximize();
     //packageListFrame   packageFrame   classFrame  - capture frame names by inspecting
     
     driver.switchTo().frame("packageListFrame");
     driver.findElement(By.linkText("org.openqa.selenium")).click();
     driver.switchTo().defaultContent();
     
     driver.switchTo().frame("packageFrame");
     driver.findElement(By.linkText("WebDriver")).click();
     driver.switchTo().defaultContent();
     
     driver.switchTo().frame("classFrame");
     driver.findElement(By.xpath("//*[text()='Index']")).click();
     
     
     
    
     

	}

}
