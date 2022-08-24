package Day33;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkPractice {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement element:links)
		{
			String url=element.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}
			
			try
			{
			URL link=new URL(url); // convert string url to url object
			HttpURLConnection httpcon=(HttpURLConnection)link.openConnection();
			httpcon.connect();
			if(httpcon.getResponseCode()>=400)
			{
				System.out.println(httpcon.getResponseCode()+"    "+url+" Broken link");
			}
			else
			{
				System.out.println(httpcon.getResponseCode()+"    "+url+" Not a broken link");
				
			}
			}
			catch(Exception e)
			{
				
			}
		}
		
		
		

	}

}
