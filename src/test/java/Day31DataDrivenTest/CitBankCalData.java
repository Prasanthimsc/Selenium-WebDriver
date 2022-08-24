package Day31DataDrivenTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CitBankCalData {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement id=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		WebElement cdmonths=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		WebElement ir=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
		WebElement calbutton=driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")); ////button[@id='CIT-chart-submit']
		
		String file=System.getProperty("user.dir")+"\\TestData\\caldata2.xlsx";
		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			String intialdeposit=ExcelUtils.getCellData(file, "Sheet1", i,0);
			String interestrate=ExcelUtils.getCellData(file, "Sheet1", i,1);
			String length=ExcelUtils.getCellData(file, "Sheet1", i,2);
			String compound=ExcelUtils.getCellData(file, "Sheet1", i,3);
			String exptotal=ExcelUtils.getCellData(file, "Sheet1", i,4);
			
			id.clear();
			cdmonths.clear();
			ir.clear();
			Thread.sleep(3000);
			id.sendKeys(intialdeposit);
			cdmonths.sendKeys(length);
			ir.sendKeys(interestrate);
			
			WebElement compounddrop=driver.findElement(By.xpath("//mat-select[@id='mat-select-0']"));
			compounddrop.click();
			List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement option:options) 
			{
				if(option.getText().equals(compound))
					option.click();
			}
			calbutton.click();
			String acttotal=driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();
            if(exptotal.equals(acttotal)) 
            {			//if expected total = actual total then			
				
	       ExcelUtils.setCellData(file, "Sheet1",i, 6,"Passed");	//setting passed in 6th column (index start with zero)
	       ExcelUtils.fillGreenColor(file, "Sheet1",i, 6);	//filling the color in 6th column if passed then greeen or faile then red.
			}
			else
			{
				ExcelUtils.setCellData(file, "Sheet1",i, 6,"Failed");
				ExcelUtils.fillRedColor(file, "Sheet1",i, 6);
			}
		}
			System.out.println("calculation has been completed");
			driver.close();
		}

	}


