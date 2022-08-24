package Day27;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DummyTicketAssignment {

	public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
     driver.manage().window().maximize();
     
     WebElement rd=driver.findElement(By.xpath("//input[@id='product_551']"));
    
     
     rd.click();
     driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Johny");
     driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Varmal");
     driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys("This is a practice on dummy ticket.com");
     driver.findElement(By.xpath("//input[@id='dob']")).click();
     driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
     driver.findElement(By.xpath("//a[text()='22']")).click();
    		 
     driver.findElement(By.xpath("//input[@id='sex_2']")).click();
     driver.findElement(By.xpath("//input[@id='traveltype_1']")).click();
     driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Newyork");
     driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Boston");
     driver.findElement(By.xpath("//input[@id='departon']")).click();
     driver.findElement(By.xpath("//a[text()='25']")).click();
     driver.findElement(By.xpath("//span[@id='select2-reasondummy-container']")).click();
     driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Visa application"+Keys.ENTER);
     driver.findElement(By.xpath("//input[@id='deliverymethod_1']")).click();
     driver.findElement(By.xpath("//input[@id='billname']")).sendKeys("sanmad");
     driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9876543213");
     driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("abc@gmail.com");
     driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
     driver.findElement(By.xpath("//span[@aria-label='Country']")).sendKeys("United States (US)"+Keys.ENTER);
     driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("bdsfhbdhf");
     driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Sunnyvale");
     driver.findElement(By.xpath("//span[@aria-label='State / District / Province']")).sendKeys("California"+Keys.ENTER);
     driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("123456");
     
     
     		
     
     
     
     
     
	}

}
