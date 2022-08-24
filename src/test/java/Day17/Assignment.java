package Day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {

	public static void main(String[] args) 
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver();
		
	//	WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).clear();
		
		
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("admin@yourstore.com");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("admin");
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		

	}

}

