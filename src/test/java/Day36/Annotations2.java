package Day36;

import org.testng.annotations.*;

public class Annotations2
{
	@BeforeClass
	void login()
	{
		System.out.println("Login.....");
	}
	
	@Test(priority=1)
	void search()
	{
		System.out.println("Search test");
	}
	
	@Test(priority=2)
	void advsearch()
	{
		System.out.println("Adv Search test");
	}
	
	@AfterClass
	void logout()
	{
		System.out.println("Logout.....");
	}
}
