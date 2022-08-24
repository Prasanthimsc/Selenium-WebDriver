package Day31DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\writedata.xlsx");
		
		//creating workbook
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Data");
		
		/*for(int r=0;r<3;r++)
		{
			XSSFRow currentrow=sheet.createRow(r);
			for(int c=0;c<2;c++)
			{
				currentrow.createCell(c).setCellValue("welcome");
			}
		}*/
		
		// writing different data
		
		Scanner sc=new Scanner(System.in);
				
		for(int r=0;r<3;r++)
		{
			XSSFRow currentrow=sheet.createRow(r);
			for(int c=0;c<2;c++)
			{
				System.out.println("Enter input value ");
				currentrow.createCell(c).setCellValue(sc.next());
			}
		}
		
      workbook.write(file);
      workbook.close();
      file.close();
      
      System.out.println("file created");
	}

}
