package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropExample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	
		Actions act=new Actions(driver);
		

		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(drag, drop).perform();
		
		WebElement image=driver.findElement(By.xpath("//img[@alt='the peaks of high tatras']"));
		WebElement image1=driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		WebElement trash=driver.findElement(By.xpath("//div[@id='trash']"));
		
		act.dragAndDrop(image, trash).perform();
		act.dragAndDrop(image1, trash).perform();
		
	   driver.findElement(By.xpath("//a[text()='Recycle image']")).click();
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//a[text()='Recycle image']")).click(); 
		
		
	}

}
