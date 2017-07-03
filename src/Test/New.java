package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class New {

		
	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	public static void chk(String br)throws Exception
	{
		
		System.out.println("Browser that is passed as parameter from Jenkins is :"+br);
		//changes for testing
		if(br.matches("FF"))
		{
			BrowserFactory f1 = new BrowserFactory();			
			f1.getBrowser(br);
		}
		else if(br.matches("IE"))
		{
			BrowserFactory f1 = new BrowserFactory();
			f1.getBrowser(br);
		}
		else if(br.matches("chrome"))
		{
			//for chrome browser
			BrowserFactory f1 = new BrowserFactory();
			f1.getBrowser(br);
		}
			

		
		
	}

}
