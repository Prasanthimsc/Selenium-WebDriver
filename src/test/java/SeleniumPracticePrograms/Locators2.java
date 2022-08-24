package SeleniumPracticePrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators2 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php");
		d.manage().window().maximize();
		
		List<WebElement> sliders=d.findElements(By.className("homeslider-container"));
		
		System.out.println("No. of sliders: "+sliders.size());
		
		List<WebElement> links=d.findElements(By.tagName("a"));
		System.out.println("No. of links: "+links.size());
	}

}
