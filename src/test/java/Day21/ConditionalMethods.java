package Day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://demo.nopcommerce.com/register");
		d.manage().window().maximize();
		
		WebElement searchbox=d.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Displayed status: "+searchbox.isDisplayed());
		System.out.println("Enabled status: "+searchbox.isEnabled());
		
		   //input[@id='gender-female']

		WebElement malerd= d.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement femalerd= d.findElement(By.xpath("//input[@id='gender-female']"));
		
		//before selection
		System.out.println("Before selection...............");
		System.out.println("male radio button status: "+malerd.isSelected());
		System.out.println("male radio button status: "+femalerd.isSelected());
		
		//After selection
		System.out.println("After selection male...............");
		malerd.click();
		System.out.println("male radio button status: "+malerd.isSelected());
		System.out.println("female radio button status: "+femalerd.isSelected());
		
		System.out.println("After selection female...............");
		femalerd.click();
		System.out.println("male radio button status: "+malerd.isSelected());
		System.out.println("female radio button status: "+femalerd.isSelected());
	}

}
