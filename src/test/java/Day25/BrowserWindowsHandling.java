package Day25;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowsHandling {

	public static void main(String[] args) {

      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/");
      driver.manage().window().maximize();
      System.out.println("ID of browser window:"+driver.getWindowHandle());
      
      driver.findElement(By.linkText("OrangeHRM, Inc")).click();
      Set<String> windowids=driver.getWindowHandles();
      
    /*  List<String> windowidlist=new ArrayList(windowids);
      
     String parentwid=windowidlist.get(0);
     String childwid=windowidlist.get(1);
     
     driver.switchTo().window(childwid);
     
   //  driver.findElement(By.xpath("//a[normalize-space()='Contact Sales']")).click();
     System.out.println("child window title is : "+driver.getTitle());
     
     driver.switchTo().window(parentwid);
     System.out.println("parent window title is : "+driver.getTitle()); */
      
      for(String id:windowids) 
      {
    	 String title=driver.switchTo().window(id).getTitle();
    	 if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS"))
    	 {
    		 driver.findElement(By.xpath("//a[normalize-space()='Contact Sales']")).click();
    	 }
    	 
       }
     
     //OrangeHRM
         
      for(String id:windowids) 
      {
    	 String title=driver.switchTo().window(id).getTitle();
    	 if(title.equals("OrangeHRM"))
    	 {
    		 driver.close();
    	 }
    	 
       }
     
      
      
      

	}

}
