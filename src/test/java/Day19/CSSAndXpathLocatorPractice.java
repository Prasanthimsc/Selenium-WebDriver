package Day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSAndXpathLocatorPractice {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php");
		d.manage().window().maximize();
		
		//css with tag & id
		//d.findElement( By.cssSelector("input#search_query_top")).sendKeys("T-Shirts");
		//d.findElement( By.cssSelector("#search_query_top")).sendKeys("T-Shirts");
		
		//css with tag & class
		//d.findElement(By.cssSelector("input.search_query")).sendKeys("T-Shirts");
		//d.findElement(By.cssSelector(".search_query")).sendKeys("T-Shirts");
		
		//css with tag & attribute
		//d.findElement(By.cssSelector("input[name='search_query']")).sendKeys("T-Shirts");
		//d.findElement(By.cssSelector("[name='search_query']")).sendKeys("T-Shirts");
		
		//css with tag, class and attribute  input.search_query[name="search_query"]
		
		d.findElement(By.cssSelector("input.search_query[name='search_query']")).sendKeys("T-Shirts");	
		//d.findElement(By.cssSelector(".search_query[name='search_query']")).sendKeys("T-Shirts");
	}

}
