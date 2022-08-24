package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']")).click();
		driver.findElement(By.xpath("(//a[normalize-space()='Users'])[1]")).click();
		
		int rows=driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr")).size();
		int count=0;
		for(int r=1;r<=rows;r++)
		{
			String status=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[5]")).getText();
			if(status.equals("Enabled"))
			{
				count++;
			}
		}
		System.out.println("Total users :"+rows);
		System.out.println("Enabled users : "+count);
        System.out.println("Disabled users : "+(rows-count));
        

	}

}
