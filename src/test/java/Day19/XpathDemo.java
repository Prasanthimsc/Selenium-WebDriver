package Day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		
		d.get("http://automationpractice.com/index.php");
		d.manage().window().maximize();
		
		//absolute xpath
		
		d.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]")).sendKeys("T-shirts");
		d.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();

	}

}
