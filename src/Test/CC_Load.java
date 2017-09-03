package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CC_Load {

		
	@SuppressWarnings("static-access")
	@Parameters({"browser","url"})
	@Test
	public static void chk(String br,String url)throws Exception
	{
		
		System.out.println("Browser that is passed as parameter from Jenkins is :"+br);
		//changes for testing
		//Testing Integration - 2
		if(br.matches("FF"))
		{
			BrowserFactory f1 = new BrowserFactory();			
			f1.getBrowser(br,url);
		}
		else if(br.matches("IE"))
		{
			BrowserFactory f1 = new BrowserFactory();
			f1.getBrowser(br,url);
		}
		else if(br.matches("chrome"))
		{
			//for chrome browser
			BrowserFactory f1 = new BrowserFactory();
			f1.getBrowser(br,url);
		}
			

		
		
	}

}
