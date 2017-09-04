package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Initiate {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	public static WebDriver browser = BrowserFactory.getBrowser("Browser","url");
	BrowserFactory br = new BrowserFactory();
	@BeforeClass
	public void Ini(){
		extent = Report.GetExtent();
//		System.setProperty("webdriver.gecko.driver", "C:\\CI_CD_CT\\Browser_Executables\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
	}
	@SuppressWarnings("static-access")
	@Parameters({"browser","url"})
	@Test
	public void checkHome(String Browser, String Url)throws Exception
	{
		test = extent.createTest("CIRCUIT CITY", "Verify HomePage");
		br.getBrowser(Browser, Url);
		System.out.println("Browser that is passed as parameter from Jenkins is :"+Browser); 
		test.pass("Browser Opened As Expected");
		checkRegistration();
	}
	
		
	public void checkRegistration()throws Exception
	{
		Registration reg  = new Registration();
		reg.executeAllTest();
	}
	@Test
	public void checkFail(){
		test = extent.createTest("Testing - Fail Criteria");
		//test.log(Status.INFO, "fail check started");
		test.fail("Test fail");
	}
	@AfterClass
	public void tear()
	{
		//extent.endTest(test);//earlier version
		extent.flush();
		driver.quit();
	}
}
