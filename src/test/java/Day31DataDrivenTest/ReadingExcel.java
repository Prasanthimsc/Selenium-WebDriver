package Day31DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalrows=sheet.getLastRowNum();
		int totalcols=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total rows : "+totalrows);
		System.out.println("Total columns : "+totalcols);
		
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0;c<totalcols;c++)
			{
				XSSFCell cell=currentrow.getCell(c);
				System.out.print(cell.toString()+"           ");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();

	}

}
