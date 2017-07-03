package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class One {

	WebDriver wd;
	@Test
	public void first()
	{
		System.out.println("checking TEstng with ANT");
		System.setProperty("webdriver.gecko.driver", "C:\\Softwares-\\geckodriver.exe");
	    wd  = new FirefoxDriver();	
	    wd.get("https://www.saib.com.sa/en");
	}
	
}
