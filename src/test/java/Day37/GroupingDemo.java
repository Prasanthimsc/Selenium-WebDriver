package Day37;

import org.testng.annotations.Test;

public class GroupingDemo 
{

	@Test(priority=1, groups= {"sanity","regression"})
	void loginByEmail()
	{
		System.out.println(" this is login by email");
	}
	
	@Test(priority=2,groups= {"sanity"})
	void loginByfacebook()
	{
		System.out.println(" this is login by facebook");
			
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginBytwitter()
	{
		System.out.println(" this is login by twitter");
	}
	
	@Test(priority=4,groups= {"sanity","regression"})
	void signupbyemail()
	{
		System.out.println("signup by email");
	}
	
	@Test(priority=5,groups= {"regression"})
	void signupbyfacebook()
	{
		System.out.println("signup by facebook");
	}
	
	@Test(priority=6,groups= {"regression"})
	void signupbytwitter()
	{
		System.out.println("signup by twitter");
	}
	
	@Test(priority=7,groups= {"sanity"})
	void paymentindollar()
	{
		System.out.println("this is payement by dollar method");
	}
	
	@Test(priority=8,groups= {"sanity","regression"})
	void paymentinrupees()
	{
		System.out.println("this is payement by rupees method");
	}
	
	@Test(priority=9,groups= {"regression"})
	void paymentReturnbyBank()
	{
		System.out.println("payment return by bank");
	}
}
