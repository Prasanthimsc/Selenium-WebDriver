package Day33;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//capturing cookies
		
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("size of cookies: "+cookies.size());   //3
		//printing cookies
		for(Cookie c:cookies)
		{
			System.out.println(c.getName()+"  "+c.getValue());
		}
		
       // adding cookie to browser
		
		Cookie cookieobj=new Cookie("Mycookie","23243243");   //created new cookie
		driver.manage().addCookie(cookieobj);                 //added cookie to browser
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after adding new one: "+cookies.size());
		
		//deleting a specific cookie from browser
		driver.manage().deleteCookie(cookieobj); // can delete cookie that is created by us
		
		//driver.manage().deleteCookieNamed("Mycookie");  // parameter is cookie name
		driver.manage().deleteCookieNamed(".Nop.Customer");  // 
		
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after deletion of 2 cookies: "+cookies.size());   //2
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		cookies=driver.manage().getCookies();
		System.out.println("size of cookies after deleting all cookies: "+cookies.size());    //0
		
	}

}
