package Day38;

import org.testng.annotations.Test;

public class InvocationMethod 
{

	@Test(invocationCount=5)
	void test()
	{
		System.out.println("testing");
	}
}
