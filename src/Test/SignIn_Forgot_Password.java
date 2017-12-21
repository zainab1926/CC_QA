package Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignIn_Forgot_Password extends Browser
{
	Report rpt = new Report();
	Browser br  = new Browser();

	/*@SuppressWarnings("static-access")
	@Parameters({"browser"})*/
	//@Test
	public void executeAllTest()throws Exception
	{
		//verifyLogin();
		verifySignin();
		verifyEmail();
		verifyPassword();
		//RememberMe(); functionality not working
		forgotPassword();
		verify_forgotPassword();
		//newPassword();  //functionality not working
		oldPassword();
	}
	
	public void verifyLogin()throws Exception
	{
		Thread.sleep(10000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(5000);
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("LogIn Id", "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"); 
		 ids.put("Password", "Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1");
		 ids.put("Remember Me", "Header_GlobalLogin_WC_AccountDisplay_FormInput_rememberMe_In_Logon_1_img");
		 ids.put("SignIn button", "Header_GlobalLogin_WC_AccountDisplay_links_2");
		 ids.put("Forgot Password", "Header_GlobalLogin_WC_AccountDisplay_links_1");
		 ids.put("Create Account", "Header_GlobalLogin_WC_AccountDisplay_links_3");
		 
		  Thread.sleep(8000);                 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
		         rpt.createTest("CC-SignIn-Verify Login", "Field :"+id.getKey()+" is Displayed");
		         rpt.Pass("Field :"+id.getKey()+" is Displayed");
		         rpt.Category("CC_Registration_Verify Login");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 rpt.createTest("CC-SignIn-Verify Login", "Field :"+id.getKey()+" is Displayed");
		         rpt.Pass("Field :"+id.getKey()+" is Displayed");
		         rpt.Category("CC_Registration_Verify Login");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
		       
			 }
		 }
		
	}

	public void verifySignin()throws Exception
	{
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign In Button Displayed - For Verify Sign In");
	    rpt.Pass("Sign In Button Displayed - For Verify Sign In");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign In Button NOT Displayed - For Verify Sign In");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Sign In");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(6000);
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "User Email Displayed - For Verify Sign In");
	    rpt.Pass("User Email Displayed - For Verify Sign In");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "User Email NOT Displayed - For Verify Sign In");
		    rpt.Fail("User Email NOT Displayed - For Verify Sign In");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "User Password Displayed - For Verify Sign In");
	    rpt.Pass("User Password Displayed - For Verify Sign In");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "User Password NOT Displayed - For Verify Sign In");
		    rpt.Fail("User Password NOT Displayed - For Verify Sign In");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button"); //SIGN IN
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign In Button Displayed - For Verify Sign In");
	    rpt.Pass("Sign In Button Displayed - For Verify Sign In");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button"); //SIGN IN

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign In Button NOT Displayed - For Verify Sign In");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Sign In");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(12000);
		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[1]/div[1]/a/span"); //sign out
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[1]/div[1]/a/span").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign Out Button Displayed - For Verify Sign In");
	    rpt.Pass("Sign Out Button Displayed - For Verify Sign In");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[1]/div[1]/a/span"); //sign out

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Sign In", "Sign Out Button NOT Displayed - For Verify Sign In");
		    rpt.Fail("Sign Out Button NOT Displayed - For Verify Sign In");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Sign In");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}             
	}

	
	public void verifyEmail()throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(8000);
		//click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(8000);
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{	
	     Thread.sleep(5000);
		rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "Sign In Button Displayed - For Verify Email");
	    rpt.Pass("Sign In Button Displayed - For Verify Email");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "Sign In Button NOT Displayed - For Verify Email");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Email");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ram@royalcyber.com");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "User Email Displayed - For Verify Email");
	    rpt.Pass("User Email Button Displayed - For Verify Email");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ram@royalcyber.com");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "User Email NOT Displayed - For Verify Email");
		    rpt.Fail("User Email Button NOT Displayed - For Verify Email");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "User Password Displayed - For Verify Email");
	    rpt.Pass("User Password Button Displayed - For Verify Email");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Email", "User Password NOT Displayed - For Verify Email");
		    rpt.Fail("User Password Button NOT Displayed - For Verify Email");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Email");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button");
		
		Boolean strMessage = findTheElement("xpath=//*[@id='Header_GlobalLogin_logonErrorMessage_GL']").isDisplayed();//error msg
		String actualCpass = findTheElement("xpath=//*[@id='Header_GlobalLogin_logonErrorMessage_GL']").getText();
		String expectedCpass="Either the logon ID or the password entered is incorrect. Enter the information again.";
		if(actualCpass == expectedCpass)
		{
			rpt.createTest("CC-SignIn & Forgot Password -Verify Email", "Message "+expectedCpass+" Displayed- For Invalid Email Id");
		    rpt.Info("Expected Message "+expectedCpass+"Is Matching with "+actualCpass +"Message");
		    rpt.Pass("Message "+expectedCpass+" Displayed- For Invalid Email Id");	
		    rpt.Category("CC_SignIn & Forgot Password -Verify Email");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC-SignIn & Forgot Password - Verify Email", "Message "+actualCpass+" Displayed- For Invalid Email Id");
		    rpt.Info("Expected Message "+expectedCpass+ "Not Matching with "+actualCpass +"Message");
		    rpt.Fail("Message "+expectedCpass+" NOT Displayed- For Invalid Email Id");
		    rpt.Category("CC_SignIn & Forgot Password -Verify Email");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
}
	
	public void verifyPassword()throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(10000);
		//click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Password", "Sign In Button Displayed - For Verify Password ");
	    rpt.Pass("Sign In Button Displayed - For Verify Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Password ");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Password ", "Sign In Button NOT Displayed - For Verify Password ");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Password ");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Password ");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(6000);
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Password", "User Email Displayed - For Verify Password");
	    rpt.Pass("User Email Displayed - For Verify Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Password", "User Email NOT Displayed - For Verify Password");
		    rpt.Fail("User Email NOT Displayed - For Verify Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "zainab12");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Password", "User Password Displayed - For Verify Password");
	    rpt.Pass("User Password Displayed - For Verify Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "zainab12");

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Password", "User Password NOT Displayed - For Verify Password");
		    rpt.Fail("User Password NOT Displayed - For Verify Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button");
		
		Boolean strMessage = findTheElement("xpath=//*[@id='Header_GlobalLogin_logonErrorMessage_GL']").isDisplayed();//error msg
		String actualCpass = findTheElement("xpath=//*[@id='Header_GlobalLogin_logonErrorMessage_GL']").getText();
		String expectedCpass="Either the logon ID or the password entered is incorrect. Enter the information again.";
		if(actualCpass == expectedCpass)
		{
			rpt.createTest("CC-SignIn-Verify Password", "Message "+expectedCpass+" Displayed- For Invalid Password");
		    rpt.Info("Expected Message "+expectedCpass+"Is Matching with "+actualCpass +"Message");
		    rpt.Pass("Message "+expectedCpass+" Displayed- For Invalid Password");	
		    rpt.Category("CC_SignIn-Verify Password");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC-SignIn-Verify Password", "Message "+actualCpass+" Displayed- For Invalid Password");
		    rpt.Info("Expected Message "+expectedCpass+ "Not Matching with "+actualCpass +"Message");
		    rpt.Fail("Message "+expectedCpass+" NOT Displayed- For Invalid Password");
		    rpt.Category("CC_SignIn-Verify Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
	}
	
	public void RememberMe()throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_rememberMe_In_Logon_1_img']");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button");
		Thread.sleep(5000);
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/div/div/div[1]/div[1]/a/span");//signout is not working
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(5000);
	}
	
	public void forgotPassword() throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Link", "Sign In Button Displayed - For Verify Forgot Password Link");
	    rpt.Pass("Sign In Button Displayed - For Verify Forgot Password Link");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password Link");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
         click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Link", "Sign In Button NOT Displayed - For Verify Forgot Password Link");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Forgot Password Link");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password Link");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_1']");
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_1']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Link", "Remember Me Check Box Displayed - For Verify Forgot Password Link");
	    rpt.Pass("Remember Me Check Box Displayed - For Verify Forgot Password Link");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password Link");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Link", "Remember Me Check Box NOT Displayed - For Verify Forgot Password Link");
		    rpt.Fail("Remember Me Check Box NOT Displayed - For Verify Forgot Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
	}
	
	public void verify_forgotPassword()throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(8000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(8000);
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password", "Sign In Button Displayed - For Verify Forgot Password");
	    rpt.Pass("Sign In Button Displayed - For Verify Forgot Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password", "Sign In Button NOT Displayed - For Verify Forgot Password");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Forgot Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_1']");
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_1']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password", "Forgot Password Option Displayed - For Verify Forgot Password ");
	    rpt.Pass("Forgot Password Option Displayed - For Verify Forgot Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password Option");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password ", "Forgot Password Option NOT Displayed - For Verify Forgot Password ");
		    rpt.Fail("Forgot Password Option NOT Displayed - For Verify Forgot Password ");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password ");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		Thread.sleep(5000);
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input"); //email
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input","ramya@royalcyber.com");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password ", "Email Text Box Displayed - For Verify Forgot Password ");
	    rpt.Pass("Email Text Box Displayed - For Verify Forgot Password ");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password ");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Option", "Email Text Box NOT Displayed - For Verify Forgot Password ");
		    rpt.Fail("Email Text Box NOT Displayed - For Verify Forgot Password ");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password ");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
		click("xpath=html/body/div[3]/div/div/div/div/div/div/div/div[2]/div/div/form/div/a/div[2]"); //submit
		if(findTheElement("xpath=html/body/div[3]/div/div/div/div/div/div/div/div[2]/div/div/form/div/a/div[2]").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password ", "Submit Button Displayed - For Verify Forgot Password ");
	    rpt.Pass("Submit Button Displayed - For Verify Forgot Password ");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password ");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Forgot Password Option", "Submit Button NOT Displayed - For Verify Forgot Password ");
		    rpt.Fail("Submit Button NOT Displayed - For Verify Forgot Password ");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Forgot Password ");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}
	
	public void newPassword()throws Exception
	{
		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "");//password
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
	}
	
	public void oldPassword()throws Exception
	{
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/div/a/img");
		Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(5000);
		if(findTheElement("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "Sign In Button Displayed - For Verify Old Password");
	    rpt.Pass("Sign In Button Displayed - For Verify Old Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "Sign In Button NOT Displayed - For Verify Old Password");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Old Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input", "ramya@royalcyber.com");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "User Email Displayed - For Verify Old Password");
	    rpt.Pass("User Email  Displayed - For Verify Old Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "User Email NOT Displayed - For Verify Old Password");
		    rpt.Fail("User Email  NOT Displayed - For Verify Old Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		
		
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input");
		sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");//password
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "User Password Displayed - For Verify Old Password");
	    rpt.Pass("User Password Displayed - For Verify Old Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		//sendKeys("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[2]/input", "Royalcyber1");

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "User Password NOT Displayed - For Verify Old Password");
		    rpt.Fail("User Password NOT Displayed - For Verify Old Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input");
		if(findTheElement("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[1]/input").isDisplayed())
		{		
		rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "Sign In Button Displayed - For Verify Old Password");
	    rpt.Pass("Sign In Button Displayed - For Verify Old Password");	
	    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
         String path = rpt.CaptureScreen(browser, "ValidMessage");
         rpt.imgPathPass(path);
 		//click("xpath=html/body/div[2]/div[2]/div[2]/div[2]/div[4]/ul/li[3]/div/div/div/form[1]/div[2]/div[2]/div/div[3]/div[1]/div/button"); //SIGN IN

		}
		else
		{
			rpt.createTest("CC - SignIn & Forgot Password - Verify Old Password", "Sign In Button NOT Displayed - For Verify Old Password");
		    rpt.Fail("Sign In Button NOT Displayed - For Verify Old Password");	
		    rpt.Category("CC_SignIn & Forgot Password - Verify Old Password");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
	}

}

