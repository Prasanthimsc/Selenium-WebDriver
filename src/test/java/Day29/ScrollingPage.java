package Day29;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
       JavascriptExecutor js=(JavascriptExecutor)driver;
       
       // scrolling down by pixel
       
      // js.executeScript("window.scrollBy(0,3000)","");
     //  System.out.println("Pixels moved: "+js.executeScript("return window.pageYOffset"));
       
       //scroll down till element is visible
      // WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
     //  js.executeScript("arguments[0].scrollIntoView();",flag);
     //  System.out.println("Pixels moved: "+js.executeScript("return window.pageYOffset"));
       
     //3.End of the page 
     		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     		System.out.println(js.executeScript("return window.pageYOffset;")); //6001.66650390625
     		
     		Thread.sleep(5000);
     		
     		//go back to initial position
     		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
       
	}

}
