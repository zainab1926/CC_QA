package Test;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;


public class LogIn_Register extends BrowserFactory
{
		
	  @SuppressWarnings("static-access")
	public  void chkLogin(String url) throws Exception
	  {   		  	
		  //adding new lines to check invocation 
		  //adding new changes for checking purpose
			//String URL = CommonUtils.readFromConfig("BaseURL");
			Browser br = new Browser();
			br.go(url);	    
			String appTitle = br.getTitle();
			System.out.println("Application title is : "+appTitle);
			Report rpt = new Report();
			rpt.startReport();
			rpt.takeScreenShot("CC-Home_");
			rpt.report.flush();
	  }	 
	  
	  
	  	 		
}
