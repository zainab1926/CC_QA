package Test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample_Class {
	@Test
    @Parameters("url")
    public void testMethod(String url) throws Exception
	{
        System.err.println("URL that was passed in via Jenkins job " + url);
        
       
    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    	FirefoxOptions options = new FirefoxOptions();
    				
    	options.addPreference("log", "{level: trace}");
    			
    	capabilities.setCapability("marionette", true);
    	capabilities.setCapability("moz:firefoxOptions", options);
    			
    	
    	System.setProperty("webdriver.gecko.driver", "C:\\CI_CD_CT\\Browser_Executables\\geckodriver.exe");
    				
    	WebDriver wd = new FirefoxDriver(capabilities);
    	
        wd.get(url);//this is working code for SAIB
        
    }
}








