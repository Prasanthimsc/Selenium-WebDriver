package Day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadAssignment {

	public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.manage().window().maximize();
    
    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");		
    driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
    driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
    driver.findElement(By.xpath("//input[@id='photofile']")).sendKeys("C:\\Selenium\\cat-ge900f397f_640.jpg");
    		


	}

}
