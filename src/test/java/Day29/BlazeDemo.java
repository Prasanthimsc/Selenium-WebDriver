package Day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//choosing departure city
				Select dcity=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		dcity.selectByVisibleText("San Diego");
				
		//choosing to city
		Select tocity=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		tocity.selectByVisibleText("Berlin");
		
		//click findflights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		String FT=driver.findElement(By.xpath("//h3[normalize-space()='Flights from San Diego to Berlin:']")).getText();
		
		//capturing the heading of the flights page
		System.out.println("Title : "+FT);
		
		//finding numner of flights displayed
		int flights=driver.findElements(By.xpath("//tbody/tr")).size();
		System.out.println("Number of flights :"+flights );
		
		//selecting and clickign a flight
		driver.findElement(By.xpath("//tr[3]/td[1]/input[1]")).click();

		// Entering the personnel details
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Johny");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("234,xyz street");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("suncuperfre");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("california");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("98765");
		Select card=new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		card.selectByVisibleText("Diner's Club");
		
		// Credit card details
		
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456787");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("6");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2024");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Johny Smith");
		
		//booking flight
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		//verifying if purchase details are displayed
		System.out.println("Page heading: "+driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText());
		 
	}

}
