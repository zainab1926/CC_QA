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
			br.click("xpath=//*[@id='block-block-2']/div/div[2]/a");
			   
					
			String parentWindowHandler = browser.getWindowHandle(); 
			String subWindowHandler = null;	
			Set<String> handles = browser.getWindowHandles(); 
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			subWindowHandler = iterator.next();
			}
			browser.switchTo().window(subWindowHandler); 
						
			Thread.sleep(9000);
			br.sendKeys("xpath=//*[@id='cusAccNum']", "123456789");
			br.sendKeys("xpath=//*[@id='cusNin']", "123456789");
			br.sendKeys("xpath=//*[@id='crdNum']", "123456789");		 
			br.sendKeys("xpath=//*[@id='crdPinPac']", "12334567");
			br.sendKeys("xpath=//*[@id='crdPinPac']", "123456789");	
		  
		
		
		  //captcha
		  
//		  Point loc  = driver.findElement(By.xpath("//*[@id='loginForm']/ul/li[5]/div/div[2]/img")).getLocation();
//		  System.out.println("X Position : "+loc.x);
//		  System.out.println("Y Position : "+loc.y);
//		  driver.switchTo().window(parentWindowHandler);  
//		  
////		  BufferedImage image = ImageIO.read(loc);
//		  String imageText = new OCR().recognizeCharacters((RenderedImage) loc);  
//		  System.out.println("Text From Image : \n"+ imageText);  
//		  System.out.println("Length of total text : \n"+ imageText.length());
		  
		  
//		  driver.get("https://online.saib.com.sa/registration/auth/login.do?locale=en_US");
//		  String imageUrl=browser.findElement(By.xpath("//*[@id='loginForm']/ul/li[5]/div/div[2]/img")).getAttribute("src");
//		  System.out.println("Image source path : \n"+ imageUrl);
//		  Thread.sleep(9000);
//		  URL url = new URL(imageUrl);
//		  Image image = ImageIO.read(url);
//		  String s = new OCR().recognizeCharacters((RenderedImage) image);
//		  System.out.println("Text From Image : \n"+ s);
//		  System.out.println("Length of total text : \n"+ s.length());
//		  driver.quit();
	  }	 
	  
	  
	  	 		
}
