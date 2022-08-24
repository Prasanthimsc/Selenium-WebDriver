package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOperations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
        
		
       WebElement admin=driver.findElement(By.xpath("//b[normalize-space()='Admin']"));
       WebElement usermgnt=driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
       WebElement users=driver.findElement(By.xpath("(//a[normalize-space()='Users'])[1]"));
       
       Actions act=new Actions(driver);
    		   
    	act.moveToElement(admin).moveToElement(usermgnt).moveToElement(users).click().build().perform();
    		   
	}

}
