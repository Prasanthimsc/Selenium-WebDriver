package Day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationalMethodsDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().to("https://www.macys.com/");
			
		driver.navigate().back(); // amazon.com
		System.out.println("current url is amazon: "+driver.getCurrentUrl());
		
		driver.navigate().forward(); // macys.com
		System.out.println("current url is macys: "+driver.getCurrentUrl());
		
		driver.navigate().refresh();
		

	}

}
