package Day31DataDrivenTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String file=System.getProperty("user.dir")+"\\TestData\\caldata.xlsx";
		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			String princ=ExcelUtils.getCellData(file, "Sheet1", i,0);
			String roi=ExcelUtils.getCellData(file, "Sheet1", i,1);
			String per1=ExcelUtils.getCellData(file, "Sheet1", i,2);
			String per2=ExcelUtils.getCellData(file, "Sheet1", i,3);
			String fre=ExcelUtils.getCellData(file, "Sheet1", i,4);
			String exp_mvalue=ExcelUtils.getCellData(file, "Sheet1", i,5);
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			//validation
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				ExcelUtils.setCellData(file, "Sheet1",i,7,"Passed");
				ExcelUtils.fillGreenColor(file, "Sheet1",i,7);
								
			}
			else
			{
				System.out.println("Test Failed");
				ExcelUtils.setCellData(file, "Sheet1",i,7,"Failed");
				ExcelUtils.fillRedColor(file, "Sheet1",i,7);
				
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clears the data
			Thread.sleep(3000);
			
		}
		
		driver.quit();
		

	}

}
