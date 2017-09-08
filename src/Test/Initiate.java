package Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Initiate {

	ExtentReports extent;
	ExtentTest test;
	public static WebDriver browser = BrowserFactory.getBrowser("Browser","url");
	BrowserFactory br = new BrowserFactory();
	Report rpt = new Report();
	
	WebDriver wb;
	
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
		rpt.createTest("CIRCUIT CITY", "Verify HomePage");
		br.getBrowser(Browser, Url);
		System.out.println("Browser that is passed as parameter from Jenkins is :"+Browser); 
		//test.log(Status.PASS,"Browser Opened As Expected");
		//br.captureScreenShot("HomePage");
		checkRegistration();
		skipTest();
		checkFail();
		extent.flush();
	}
	
		
	public void checkRegistration()throws Exception
	{
		Registration reg  = new Registration();
		reg.executeAllTest();
	}
	
	public void checkFail()throws Exception
	{
		rpt.createTest("Testing - Fail Criteria for Circuit City","Checked");
//		test.log(Status.FAIL, "fail check started");
		rpt.Fail("Testing Fail - CIRCUIT CITY");
	
	}
	
	public void skipTest()
	{	
		rpt.createTest("SkipTest","Skipped");
//		throw new SkipException("Skipping Test");
		rpt.Skip("Test Skipped");
	}
		
//	@AfterClass
//	public void tear(ITestResult result)
//	{
//		extent.flush();
//		browser.quit();
////	}
}