package Day33;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotCapturing {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// screenshot of full page
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File trg=new File(System.getProperty("user.dir")+"\\screenshot\\homepage.png");
		FileUtils.copyFile(src,trg);
		
		// screenshot of specific area of page
		WebElement fp=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[@class='item-grid']"));
		src=fp.getScreenshotAs(OutputType.FILE);
		trg=new File(System.getProperty("user.dir")+"\\screenshot\\section.png");
		FileUtils.copyFile(src,trg);
		
		// screenshot of particular webelement
		WebElement wb=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		src=wb.getScreenshotAs(OutputType.FILE);
		trg=new File(System.getProperty("user.dir")+"\\screenshot\\webelement.png");
		FileUtils.copyFile(src,trg);
	}

}
