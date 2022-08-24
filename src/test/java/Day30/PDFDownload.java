package Day30;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDFDownload {

		static String location=System.getProperty("user.dir")+"\\downloadedfiles";
		
		
		static WebDriver setChromeBrowser()
		{
				HashMap preferences=new HashMap();
				preferences.put("download.default_directory", location);
				preferences.put("plugins.always_open_pdf_externally", true); // for pdf
				
				ChromeOptions options=new ChromeOptions();
				options.setExperimentalOption("prefs", preferences);
				
				WebDriverManager.chromedriver().setup();
			    WebDriver driver=new ChromeDriver(options); 
			    
		    return driver;
			    
		}    
			
		/*static WebDriver setEdgeBrowser() //edge - open bug
		{
			
			HashMap preferences=new HashMap();
			preferences.put("download.default_directory", location);
			preferences.put("plugins.always_open_pdf_externally", true); // for pdf
			
			EdgeOptions options=new EdgeOptions();
			options.setExperimentalOption("prefs", preferences);
			
			WebDriverManager.edgedriver().setup();
		    WebDriver driver=new EdgeDriver(options);
		    
		    return driver;
		}*/
				
			     	     
		static WebDriver setFirefoxBrowser()
		{
			 //firefox 
			FirefoxProfile profile=new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2); //0- desktop 1-downloads 2-desired location
			profile.setPreference("browser.download.dir",location);
			
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf"); //mimetype
			profile.setPreference("pdfjs.disabled", true);  // for pdf
			
			
		  	FirefoxOptions options=new FirefoxOptions();
		  	options.setProfile(profile);
		  		
		  	WebDriverManager.firefoxdriver().setup();
		  	WebDriver driver=new FirefoxDriver(options); 
		  	
		  	return driver;
		}
	
	
	
	
	
	public static void main(String[] args) 
	{
		//WebDriver driver=setChromeBrowser();

				//WebDriver driver=setEdgeBrowser();  // open issue is present. will not work

				WebDriver driver=setFirefoxBrowser();
				
				driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
				driver.manage().window().maximize();
				
				driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	}

}
