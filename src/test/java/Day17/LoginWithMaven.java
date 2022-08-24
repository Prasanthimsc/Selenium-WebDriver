package Day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithMaven {

	public static void main(String[] args) 
	
	{
		
			//open browser 
			         WebDriverManager.chromedriver().setup();
					System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
					WebDriver driver=new ChromeDriver();
			
						
					//WebDriverManager.firefoxdriver().setup();
					//System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
					//WebDriver driver=new FirefoxDriver();
			
			
					//WebDriverManager.edgedriver().setup();
					//System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
					//WebDriver driver=new EdgeDriver();
					
					//open url
					driver.get("https://opensource-demo.orangehrmlive.com/");
				    driver.manage().window().maximize();
				    
				  //provide username
				    driver.findElement(By.name("txtUsername")).sendKeys("admin");
				    
				    //provide password
				    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				    
				    //click login
				    driver.findElement(By.id("btnLogin")).click();
				    
				    //validate login
				    String exp_title="OrangeHRM";
				    String act_title=driver.getTitle();
				    
				    if(exp_title.equals(act_title))
				    {
				    	System.out.println("Login Successfull");
				    }
				    else
				    {
				    	System.out.println("Login Fail");	
				    }
				    
					
			      //close browser
				   // driver.quit();

	}

}
