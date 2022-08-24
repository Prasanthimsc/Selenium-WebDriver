package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		int rows=driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr")).size();
		System.out.println(rows);
	
		/*int ptc=0,ftp=0,ftpb=0,blank=0,ftc=0;
		
		for(int r=1;r<=rows;r++)
		{
			String status=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[6]")).getText();
			if(status.equals("Full-Time Probation"))
			{
				ftpb++;
			}
			if(status.equals("Part-Time Contract"))
			{
				ptc++;
			}	
			
			if(status.equals("Full-Time Permanent"))
			{
				ftp++;
			}	
			if(status.equals(""))
			{
				blank++;
			}
			if(status.equals("Full-Time Contract"))
			{
				ftc++;
			}
		}
		System.out.println("Total employess : "+rows);
		System.out.println("Full-Time Probation : "+ftpb);
		System.out.println("Full-Time Permanent : "+ftp);
		System.out.println("Part-Time Contract :"+ptc);
		System.out.println("Full-Time Contract : "+ftc);
		System.out.println("No status : "+blank);
		
		System.out.println("First Name"+"         "+"Last Name"+"           "+"Status");
		
		for(int r=1;r<=rows;r++)
		{
			String firstname=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[3]")).getText();
			String lastname=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[4]")).getText();
			String estatus=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+r+"]/td[6]")).getText();
			System.out.println(firstname+"        "+lastname+"        "+estatus);
		} */
	}

	
}
