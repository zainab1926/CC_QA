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
import org.testng.annotations.AfterTest;
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
		//adding new content to check Reporting
		
		//adding a new line for testing
		
	}
	@SuppressWarnings("static-access")
	@Parameters({"browser","url"})
	@Test
	public void checkHome(String Browser, String Url)throws Exception
	{
		rpt.createTest("CIRCUIT CITY", "Verify HomePage");
		br.getBrowser(Browser, Url);
		rpt.Pass("Browser that is passed as parameter from Jenkins is :"+Browser);
		rpt.Pass("URL that is passed as parameter from Jenkins is :"+Url);
		//test.log(Status.PASS,"Browser Opened As Expected");
		//br.captureScreenShot("HomePage");
		checkRegistration();
		//chkAddress_Book();
		//chkPersonalInfo();
		//chkSearch();
		skipTest();
		checkFail();
//		extent.flush();
	}
	
		
	public void checkRegistration()throws Exception
	{
		Registration reg  = new Registration();
		reg.executeAllTest();
	}
	
	public void chkPersonalInfo()throws Exception
	{
		PERSONAL_INFO pi = new PERSONAL_INFO();
		pi.executeAllTestcase();
	}
	
	public void chkAddress_Book()throws Exception
	{
		ADDRESS_BOOK add = new ADDRESS_BOOK();
		add.executeAllTest();
	}
	public void chkSearch()throws Exception
	{
		SEARCH srch = new SEARCH();
		srch.execute_Alltestcases();
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
		
	@AfterTest
	public void publishReport()throws Exception
	{
		extent.flush();
		browser.close();
	}

}
