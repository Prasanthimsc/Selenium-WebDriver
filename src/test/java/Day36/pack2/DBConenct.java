package Day36.pack2;

import org.testng.annotations.*;

public class DBConenct 
{

	/*@BeforeTest
	void connectDB()
	{
		System.out.println("DB Connection opened...");
	}
	
	@AfterTest
	void closeDBConnect()
	{
		System.out.println("DB Connection closed...");
	} */
	
	@BeforeSuite
	void connectDB()
	{
		System.out.println("DB Connection opened...");
	}
	
	@AfterSuite
	void closeDBConnect()
	{
		System.out.println("DB Connection closed...");
	}
}
