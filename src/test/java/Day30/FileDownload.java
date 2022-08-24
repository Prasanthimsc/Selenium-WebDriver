package Day30;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	public static void main(String[] args) {
		
		
      String loc=System.getProperty("user.dir")+"\\Downloadedfiles\\";
		
		//chrome browser
		HashMap preferences=new HashMap();
		preferences.put("download.default_directory",loc);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
				
		
		//edge browser
		/*    HashMap preferences=new HashMap();
			preferences.put("download.default_directory",loc);
				
			EdgeOptions options=new EdgeOptions();
			options.setExperimentalOption("prefs", preferences);
						
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver(options); */
				
			
		
		//firefox browser
		/*FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList",2); // 0-desktop   1-downloads  2- desired location
		profile.setPreference("browser.download.dir", loc); // this is required for 2 option
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv"); // mime type
		profile.setPreference("pdfjs.disabled", true); // mime type
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
					
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);*/
				
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.browserstack.com/test-on-the-right-mobile-devices");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='accept-cookie-notification']")).click(); //accept all notication
		
		driver.findElement(By.xpath("//div[@data-target='startingup']//a[@target='_blank'][normalize-space()='CSV']")).click();

	}

}
