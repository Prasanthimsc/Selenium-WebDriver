package Day26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();
        
		
		//finding rows in a table
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows : "+rows);
		
		//int nrows=driver.findElements( By.tagName("tr")).size();   //use this method only wehn one table is available
		//System.out.println("Number of rows : "+nrows);
		
		
		//fidning number of columns in a table
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of columns: "+columns);
		//int ncolumns=driver.findElements( By.tagName("th")).size(); // use only when single table is available
		
		//retrieving a specific row and column value
		 String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		 System.out.println("5th row and 1st column value: "+value);
		
		
		//retrieving all the values from table
		 System.out.println("BookName"+"          "+"Author"+"           "+"Subject"+"         "+"Price");
		 for(int r=2;r<=rows;r++)
		 {
			 for(int c=1;c<=columns;c++)
			 {
				 value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
						 
				 System.out.print(value+"   "); 
			 }
			 System.out.println();
		 }
		
		//retrieving all the books bases on author
		 for(int r=2;r<=rows;r++)
		 {
			 
				String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
				 if(author.equals("Mukesh"))
				 {
					 String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
					 System.out.println(author+"     "+bookname);
				 }
		 }
		//finding total cost of all the books
		 
		 int total=0;
		 for(int r=2;r<=rows;r++)
		 {
			 
				String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
				total=total+Integer.parseInt(price);
				
		 }
		 System.out.println("Total price of books : "+total);
		 
	}

}
