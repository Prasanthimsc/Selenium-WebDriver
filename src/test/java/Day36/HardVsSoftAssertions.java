package Day36;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions 
{
	/*@Test
	void test_hardassertions()
	{
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		
		Assert.assertEquals(2,1);
		
		System.out.println("hard assertion is completed...."); // this statement will not be executed bcoz of hard assertion failed.
	} */
	
	
	
	@Test
	void test_softassertions()
	{
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		
		
		SoftAssert sa=new SoftAssert();
				
		sa.assertEquals(2,1);
		
		System.out.println("soft assertion is completed...."); 
	
		sa.assertAll(); // mandatory required.... 
	}
}
