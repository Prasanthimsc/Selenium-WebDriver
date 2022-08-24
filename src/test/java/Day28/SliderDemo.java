package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement minslider=driver.findElement(By.xpath("//span[1]"));
		
		System.out.println("Location of minimum slider :"+minslider.getLocation());
		act.dragAndDropBy(minslider, 100,0).perform();
		System.out.println("Location of minimum slider after movement :"+minslider.getLocation());
		
         WebElement maxslider=driver.findElement(By.xpath("//span[2]"));
		
		System.out.println("Location of maximum slider :"+maxslider.getLocation());
        act.dragAndDropBy(maxslider, -40,0).perform();
        System.out.println("Location of maximum slider after movement:"+maxslider.getLocation());
		
	}

}
