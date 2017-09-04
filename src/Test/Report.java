package Test;

import java.io.File;
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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	
	
	private static String filePath = "C:\\Users\\madhusudhan\\workspace\\CC\\test-output\\myReport.html";
	public static WebDriver browser = BrowserFactory.getBrowser("Browser","url");
		
	public void takeScreenShot(String str)throws Exception
	{
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd HH_mm_ss");
		Date date = new Date();
		String time=df.format(date);
		System.out.println(time);
		File f = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\madhusudhan\\workspace\\CC\\Screenshots\\"+str+time+".png";
		FileUtils.copyFile(f, new File(dest));
//		test.addScreenCaptureFromPath(dest);
	
	}
	
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
        htmlReporter.config().setReportName("CIRCUIT-CITY : Regression cycle");
        
        return htmlReporter;
        
	}
	
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
		
	}
	
	
	
		

}
