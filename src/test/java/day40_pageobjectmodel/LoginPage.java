 package day40_pageobjectmodel;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class LoginPage 
	{
		//webdriver instance
		WebDriver driver;
		
		//constructor
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		//Locators
		By img_loc=By.xpath("//*[@id='divLogo']/img");
		By txt_username_loc=By.xpath("//input[@id='txtUsername']");
		By txt_password_loc=By.xpath("//input[@id='txtPassword']");
		By btn_login_loc=By.xpath("//input[@id='btnLogin']");
		
			
		//Action methods
		 
		public boolean checkLogoPresence()
		{
			boolean status=driver.findElement(img_loc).isDisplayed();
			return status;
		}
		
		public void setUserName(String name)
		{
			driver.findElement(txt_username_loc).sendKeys(name);
		}
		
		public void setPassword(String pwd)
		{
			driver.findElement(txt_password_loc).sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			driver.findElement(btn_login_loc).click();
		}
	}


