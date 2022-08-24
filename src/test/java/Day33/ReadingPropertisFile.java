package Day33;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingPropertisFile {

	public static void main(String[] args) throws IOException
	{
		
		//Approach 1 -- reading propertis file
	/*	FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		Properties pro=new Properties();
		pro.load(file);
		
		String url=pro.getProperty("url");
		String email=pro.getProperty("useremail");
		String password=pro.getProperty("userpassword");  */
		
		//Approach 2
		ResourceBundle rb=ResourceBundle.getBundle("config"); // only name of the file
		String url=rb.getString("url");
		String email=rb.getString("useremail");
		String password=rb.getString("userpassword");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
		
		WebElement emailtxt=driver.findElement(By.name("Email"));
		emailtxt.clear();
		emailtxt.sendKeys(email);
		
		WebElement passwordtxt=driver.findElement(By.name("Password"));
		passwordtxt.clear();
		passwordtxt.sendKeys(password);
		
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	}

}
