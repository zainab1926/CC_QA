package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Registration extends Browser
{
	Report rpt = new Report();
	//public static WebDriver browser = BrowserFactory.getBrowser("FF","http://cct-live.qa.coc.ibmcloud.com/webapp/wcs/stores/servlet/en/circuitcityb2c");
	Browser br  = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({"browser"})
	@Test
	public void executeAllTest()throws Exception
	{
		
//		chk_Login();
		checkFields();
		validFields();
		validName();
		invalidName();
		invalidEmail();
		validPassword();
		InvalidPassword();
		Invalid_Cnfm_Pwd();
		Reg_Success();
		verifyEmailid();//Review Complete sending to QA - second level of regression for testing
	}
	 
//	public  void chk_Login() throws Exception
//	{
//		Thread.sleep(3000);
//		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); //signin
//		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']/span");//register
//	}
	
	public void checkFields() throws InterruptedException,Exception
	{
		//browser.get("http://cct-live.qa.coc.ibmcloud.com/webapp/wcs/stores/servlet/en/circuitcityb2c");
        //(By.xpath("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']")).click()
		Browser.browser=browser;
		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']");//create acc
		                  
		Map<String,String> ids= new HashMap<String,String>();
		 ids.put("First Name", "WC__NameEntryForm_FormInput_firstName_1"); 
		 ids.put("Last Name", "WC__NameEntryForm_FormInput_lastName_1");
		 ids.put("Email id", "WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1");
		 ids.put("Password", "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1");
		 ids.put("Confirm Password", "WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1");
		 ids.put("Create Account", "WC_UserRegistrationAddForm_links_1");
		 
		                   
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				
		         rpt.createTest("CC-Registration-Field Validation", "Error Message :"+id.getKey()+" Displayed - For Field Validation");
		         rpt.Pass("Error Message :"+id.getKey()+" Displayed - For Field Validation");
		         rpt.Category("CC_Registration_Validation Fields");
		     	
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
		         rpt.chkBugs("Mahesh");
		         rpt.chkdebug("CC_Registration_Validation Fields");
			 }
			 else
			 {
		         rpt.createTest("CC-Registration-name Validation", "Error Message"+id.getKey()+" Displayed - For Valid Name :");
		         rpt.Fail("Error Message "+id.getKey()+" NOT Displayed - For Field Validation");
		         rpt.Category("CC_Registration_Validation Fields");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
		         rpt.chkBugs("Mahesh");
		         rpt.chkdebug("CC_Registration_Validation Fields");
		  
			 }
		 }

	}
	public void validFields() throws Exception
	{
		User_Registration();
		Thread.sleep(5000);
		
		/*String strError  = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 if(ErrorMsgReg)
		 {
			 //System.out.println("Error Message DIsplayed - For Field Validations - " + strError );
		    rpt.createTest("Circuit_City-Registration, CIRCUIT CITY - Registration :Error Message displayed - For Field Validations -", strError);

		 }
		 else
		 {
			 //System.out.println("NoError Message Displayed");
			 rpt.createTest("Circuit_City-Registration, CIRCUIT CITY - Registration :Error Message NOT displayed - For Field Validations",strError);
		 }*/

		
	}
	
	public void validName() throws Exception
	{
		User_Registration();
		 /*Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 String aMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 String eMsgReg = 
		 if(ErrorMsgReg)
		 {
			 //System.out.println("Error Message DIsplayed - For Valid Name" + eMsgReg );
			 rpt.createTest("Circuit_City-Registration- Valid Name", "Error Message Displayed: " +eMsgReg+ "For Valid Name :");
		 }
		 else
		 {
			// System.out.println("NoError Message DIsplayed");
			 rpt.createTest("Circuit_City-Registration- Valid Name", "Error Message NOT Displayed: " +eMsgReg+ "For Valid Name :");

		 }*/
	}

	public void invalidName() throws Exception
	{
		
		User_Registration();
		String[] invalidName={"1234567890","!@#$%"," "};
		String[] ids={"WC__NameEntryForm_FormInput_firstName_1","WC__NameEntryForm_FormInput_lastName_1"};
		for(String id : ids)
		{
		
		for(String value :invalidName)
		{
			sendKeys("xpath=//*[@id='"+id+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//create acc
			String Actual = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String Expected="Invalid name";
			if(Actual == Expected)
			{
				//System.out.println("Message Displayed: For Invalid Name"+ strMsg);
				rpt.createTest("CC-Registration-Invalid Name", "Message"+Expected+" Displayed- For Invalid Name");
			    rpt.Info("Expected Message "+Expected+" Is Matching with "+Actual +" Message");
			    rpt.Pass("Message "+Expected+" Displayed- For Invalid Name");
			    rpt.Category("CC_Registration-Invalid Name");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Name", "Message "+Actual+" Displayed- For Invalid Name");
			    rpt.Info("Expected Message  "+Expected+ "Not Matching with "+Actual +"Message");
			    rpt.Fail("Message"+Expected+" NOT Displayed- For Invalid Name");
			    rpt.Category("CC_Registration-Invalid Name");
		         Thread.sleep(3000);
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         Thread.sleep(3000);
		         rpt.imgPathFail(path);
			}

		}
		}

	}
	
	public void invalidEmail() throws Exception
	{
		User_Registration();
		String[] invalidEmail={"1234567890","!@#$%"," "};
		for(String value :invalidEmail)
		{
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1"+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");  
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actual = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			String expected="Invalid Email Id";
			if(actual == expected)
			{
				//System.out.println("Message Displayed: For Email - "+ strMsg);
				rpt.createTest("CC-Registration-Invalid Email Id", "Message "+expected+" Displayed- For Invalid Email Id");
			    rpt.Info("Expected Message "+expected+" Is Matching with "+actual +"Message");
			    rpt.Pass("Message "+expected+" Displayed- For Invalid Email Id");
			    rpt.Category("CC_Registration-Invalid Email Id");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Email Id", "Message"+actual+" Displayed- For Invalid Email Id");
			    rpt.Info("Expected Message "+expected+ "Not Matching with "+actual +"Message");
			    rpt.Fail("Message "+expected+" NOT Displayed- For Invalid Email Id");
			    rpt.Category("CC_Registration-Invalid Email Id");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);

			}
			
			sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", "zainab.fff@royalcyber.com");
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");
		}
		
		//browser.switchTo().alert().accept();
	}
	public void validPassword() throws Exception
	{

		User_Registration();
		
	}
	
	public  void InvalidPassword() throws Exception
	{
		User_Registration();
		String[] invalidPassword={"1234567890","!@#$%"," "};
		for(String value :invalidPassword)
		{

			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1"+"']", value);
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//submit
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actualPass = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			String expectedPass="Invalid Password";
			if(actualPass == expectedPass)
			{
				//System.out.println("Message Displayed: For InvalidPassword"+ strRegMessage);
				rpt.createTest("CC-Registration-Invalid Password", "Message"+expectedPass+" Displayed- For Invalid Password");
			    rpt.Info("Expected Message "+expectedPass+" Is Matching with "+actualPass +"Message");
			    rpt.Pass("Message "+expectedPass+" Displayed- For Invalid Password");	
			    rpt.Category("CC_Registration-Invalid Password");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Password", "Message"+actualPass+" Displayed- For Invalid Password");
			    rpt.Info("Expected Message "+expectedPass+ "Not Matching with "+actualPass +"Message");
			    rpt.Fail("Message "+expectedPass+" NOT Displayed- For Invalid Password");
			    rpt.Category("CC_Registration-Invalid Password");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}

		}
		//browser.switchTo().alert().accept();
	}
		
	public void Invalid_Cnfm_Pwd() throws Exception
	{
		User_Registration();
		String[] invalidCPassword={"1234567890","!@#$%"," "};
		for(String value :invalidCPassword)
		{
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1"+"']", value);			
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//submit
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String actualCpass = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			String expectedCpass="Invalid confirm password";
			if(actualCpass == expectedCpass)
			{
				//System.out.println("Message Displayed:Invalid Confrm_Password"+ strCnfm_Pwd);
				rpt.createTest("CC-Registration-Invalid Confirm Password", "Message "+expectedCpass+" Displayed- For Invalid Confirm Password");
			    rpt.Info("Expected Message "+expectedCpass+"Is Matching with "+actualCpass +"Message");
			    rpt.Pass("Message "+expectedCpass+" Displayed- For Invalid Confirm Password");	
			    rpt.Category("CC_Registration-Invalid Confirm Password");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				rpt.createTest("CC-Registration-Invalid Confirm Password", "Message "+actualCpass+" Displayed- For Invalid  Confirm Password");
			    rpt.Info("Expected Message "+expectedCpass+ "Not Matching with "+actualCpass +"Message");
			    rpt.Fail("Message "+expectedCpass+" NOT Displayed- For Invalid Confirm Password");
			    rpt.Category("CC_Registration-Invalid Confirm Password");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}

		}
		//browser.switchTo().alert().accept();
	}
	
	public void Reg_Success() throws Exception
	{
		System.out.println("in reg_success");
		User_Registration();
        
	}
	
	public void User_Registration() throws Exception
	{
		Thread.sleep(5000);
//		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
//		Thread.sleep(5000);
//		click("//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']");
		
		//first name
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']");
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']", "zainab");
		
		
		//LastName
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']");
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']", "firdaus");
		
		//email id
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", "zainab.fff@royalcyber.com");
		
		//password
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']");
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1']", "zainab123");
		
		//confirm password
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']");
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1']", "zainab123");
		
		//mobile number
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']", "9123456780");
		
		//create account button
		click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");
		
		
		//logout
		//click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown_SignOut']");
		
	}
	
 public  void  verifyEmailid() throws Exception
 {

		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']/span");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "zainab.fff@royalcyber.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "zainab123");
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a"); //my acc

 }
}
