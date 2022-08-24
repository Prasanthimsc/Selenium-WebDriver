package Day28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsAndWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Opening in different tabs
		driver.get("https://opencart.com/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://opensource-demo.orangehrmlive.com/"); 
		
		//Opening in different windows
	/*	driver.get("https://opencart.com/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();   */
		

	}

}
