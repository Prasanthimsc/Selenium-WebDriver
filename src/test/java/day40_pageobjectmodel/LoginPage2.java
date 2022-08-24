package day40_pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 
{
	//webdriver instance
		WebDriver driver;
		
		//constructor
		public LoginPage2(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		//Locators+identification
		
		
		/*@FindBy(tagName="a")   // multiple webelements
		List<WebElement> links;*/
			
		@FindBy(how=How.XPATH, using="//*[@id='divLogo']/img")
		WebElement img_logo;
		
		/*@FindBy(xpath="//*[@id='divLogo']/img")
		WebElement img_logo;*/
		
		@FindBy(id="txtUsername") 
		WebElement txt_username;
		
		@FindBy(name="txtPassword") 
		WebElement txt_password;
		
		@FindBy(name="Submit") 
		WebElement btn_login;
		
			
		//Action methods
		
		public boolean checkLogoPresence()
		{
			boolean status=img_logo.isDisplayed();
			return status;
		}
		
		public void setUserName(String name)
		{
			txt_username.sendKeys(name);
		}
		
		public void setPassword(String pwd)
		{
			txt_password.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btn_login.click();
		}
}
