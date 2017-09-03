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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\madhusudhan\\workspace\\CC\\test-output\\myReport.html");
	static ExtentReports report = new ExtentReports();
	static ExtentTest test;
	public static WebDriver browser = BrowserFactory.getBrowser("Browser","url");
	
	@BeforeTest
	public void startReport()
	{
		
	report.attachReporter(htmlReporter);
	report.setSystemInfo("OS", "Windows 10");
	report.setSystemInfo("UserName", "Mahesh");	
		
	
	htmlReporter.config().setDocumentTitle("ContinuosTesting - CircuitCity");
	htmlReporter.config().setReportName("Circuit-City");
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	
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
	
	
	
	
		

}
