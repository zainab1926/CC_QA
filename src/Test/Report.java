package Test;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
		
	private static String filePath = "C:\\Users\\madhusudhan\\workspace\\CC\\test-output\\myReport.html";
	public static WebDriver browser = BrowserFactory.getBrowser("Browser","URL");
	static String imagePath="C:\\Users\\madhusudhan\\workspace\\CC\\Screenshots\\";
	
	BrowserFactory br = new BrowserFactory();
	public static ExtentReports GetExtent(){
		if (extent != null)
                    return extent; //avoid creating new instance of html file
                extent = new ExtentReports();		
		extent.attachReporter(getHtmlReporter());
//		extent.setSystemInfo("OS", "Windows 10");
//		extent.setSystemInfo("UserName", "Mahesh");
		return extent;
	}
 
	private static ExtentHtmlReporter getHtmlReporter() {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("CIRCUIT-CITY");
        htmlReporter.config().setReportName("CIRCUIT-CITY : Regression Suite");
        return htmlReporter;
        
	}
		
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;	
	}
	public static ExtentTest Pass(String Message)
	{
		test.pass(Message);
		return test;
	}
	public static  ExtentTest Fail(String FailMessage)
	{
		test.fail(FailMessage);
		return test;
		
		
	}
	public static ExtentTest Skip(String SkipMessage)
	{
		test.skip(SkipMessage);
		return test;
	}

	public static ExtentTest Info(String InfoMessage)throws Exception
	{
		test.info(InfoMessage);
		return test;
	}
	public static ExtentTest imgPath(String path)throws Exception
	{
		test.addScreenCaptureFromPath(path);
		return test;
	}
	
	
		
	public static String CaptureScreen(WebDriver driver,String imgName)
	{
	    TakesScreenshot oScn = (TakesScreenshot) driver;
	    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	 File oDest = new File(imagePath+imgName+".png");
	 try {
	      FileUtils.copyFile(oScnShot, oDest);
	 } catch (IOException e) {System.out.println(e.getMessage());}
	 return imagePath+imgName+".png";
	        }
}
