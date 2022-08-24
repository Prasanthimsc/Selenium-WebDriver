package Day32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Day31DataDrivenTest.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FDCalculatorDatabaseDDT {

	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		//database code
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");  
		
		//System.out.println(con.isValid(3)); //true
		  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
		  
		//step4 execute query  
		ResultSet rs=stmt.executeQuery("select * from caldata"); 
		//int count=0;
		
		while(rs.next())
		{
			int princ=rs.getInt("principle");
			int roi=rs.getInt("roi");
			int per1=rs.getInt("per1");
			String per2=rs.getString("per2");
			String fre=rs.getString("frequency");
			double exp_mv=rs.getInt("maturityvalue");
			
						
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(String.valueOf(princ));
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(String.valueOf(roi));
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(String.valueOf(per1));
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			//validation
			if(exp_mv==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passed");
				
								
			}
			else
			{
				System.out.println("Test Failed");
				
				
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clears the data
			Thread.sleep(3000);
			
		}
		
		driver.quit();

	}

}
