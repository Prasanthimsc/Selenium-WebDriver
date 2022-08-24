package Day36;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions 
{
	@Test
	void test()
	{
		//Assert.assertTrue(true); //passed
		//Assert.assertTrue(false);  //failed
		
		//Assert.assertFalse(false); //passed
		//Assert.assertFalse(true); //failed
		
		//int a=10;
		//int b=20;
		//int c=30;
		
		//Assert.assertEquals(actual,expect, description);
		
		//Assert.assertEquals(a>b, true); //failed
		//Assert.assertNotEquals(a>b,true);
		
		//Assert.assertEquals(a<b && a<c, true); //passed
		//Assert.assertEquals(a>b && a>c, false); //passed
		
		//String s1="abc";
		//String s2="xyz";
		
		//Assert.assertEquals(s1,s2,"values are not equal..");
				
		if(true)
		{
			Assert.assertTrue(true);
		}
		else
		{	
			Assert.fail();
		}
	}
}
