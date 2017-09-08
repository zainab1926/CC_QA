package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Registration extends Browser
{
	WebDriver wd;
	Report rpt  = new Report();
	
	public void executeAllTest()throws Exception
	{
		//making changes for Testing purpose
//		chk_Login();
		checkFields();
		validFields();
		//validName();
		//invalidName();
//		invalidEmail();
//		validPassword();
//		InvalidPassword();
//		Invalid_Cnfm_Pwd();
//		Reg_Success();
	}
	 
//	public  void chk_Login() throws Exception
//	{
//		Thread.sleep(3000);
//		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); //signin
//		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']/span");//register
//	}
	
	public void checkFields() throws InterruptedException,Exception
	{
		Thread.sleep(2000);
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
				 rpt.createTest("Circuit_City-Registration", "Message : "+id.getKey()+ " is displayed ");
				 rpt.Pass("Message"+id.getKey()+ " is Displayed ");
				 String path = rpt.CaptureScreen(browser, id.getKey());
				 System.out.println(path);
				 rpt.Pass(path);
			 }
			 else
			 {
				 //System.out.println(id.getKey() + " is not displayed ");
				 rpt.createTest("CIRCUIT-CITY - Registration", "Message "+id.getKey()+ " is NOT displayed ");
				 rpt.Fail("Message"+id.getKey()+ " is NOT Displayed ");
				 
			 }
			 
		 }

	}
	public void validFields() throws Exception
	{
		User_Registration();
		Thread.sleep(5000);
		String strError  = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 if(ErrorMsgReg)
		 {
			 rpt.createTest("Checking ValidFields ", "CIRCUIT CITY - Registration : "+strError+" Message displayed - For Field Validations -");
			 rpt.Info("Message"+strError+ "properly displayed");
			 rpt.Pass("CIRCUIT CITY - Registration : "+strError+" Message displayed - For Field Validations");
		 }
		 else
		 {
			 rpt.createTest("Checking ValidFields ", "CIRCUIT CITY - Registration : "+strError+" Message displayed - For Field Validations -");
			 rpt.Info("Message");
			 rpt.Fail("CIRCUIT CITY - Registration : "+strError+" Message  NOT displayed - For Field Validations");
			
		 }

		
	}
	
	public void validName() throws Exception
	{
		User_Registration();
		 Boolean ErrorMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//For Error MEssage
		 String eMsgReg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
		 if(ErrorMsgReg)
		 {
			 rpt.createTest("CC-Registration-name Validation", "Error Message"+eMsgReg+" Displayed - For Valid Name :");
			 rpt.Pass("Error Message"+eMsgReg+" Displayed - For Valid Name");
		 }
		 else
		 {
			 
			 test = extent.createTest("CIRCUIT CITY - Registration :Error Message NOT displayed- For valid name");
			 rpt.createTest("CC-Registration-name Validation", "Error Message"+eMsgReg+" Displayed - For Valid Name :");
			 rpt.Fail("Error Message"+eMsgReg+" NOT ;Displayed - For Valid Name");
		 }
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
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']/div[2]");//create acc
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			
			String Actual = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			String Expected = "Invalid Name";
			if(Actual == Expected)
			{	
				rpt.createTest("CC-Registration-Ivalid Name", "Message"+Expected+" Displayed- For Invalid Name:");
				rpt.Info("Expected Message"+Expected+"Is Matching with "+Actual +"Message");
				rpt.Pass("Message"+Expected+" Displayed- For Invalid Name:");
			}
			else
			{
				rpt.createTest("CC-Registration-Ivalid Name", "Message"+Actual+" Displayed- For Invalid Name:");
				rpt.Info("Expected Message"+Expected+ "Not Matching with "+Actual +"Message");
				rpt.Fail("Message"+Expected+" NOT Displayed- For Invalid Name:");
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
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']/div[2]");  
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String strMsg = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			if(strMessage)
			{
				//System.out.println("Message Displayed: For Email - "+ strMsg);
				test = extent.createTest("CIRCUIT CITY - Registration :Message Displayed- For Invalid Email : ",strMsg);
			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				test = extent.createTest("CIRCUIT CITY - Registration :Error Message NOT Displayed- For Invalid Email ");

			}

		}
		
		browser.switchTo().alert().accept();
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
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']/div[2]");//submit
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String strRegMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			if(strMessage)
			{
				//System.out.println("Message Displayed: For InvalidPassword"+ strRegMessage);
				test = extent.createTest("CIRCUIT CITY - Registration :Message Displayed- For InvalidPassword",strRegMessage);

			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				test = extent.createTest("CIRCUIT CITY - Registration :Error Message NOT Displayed-For InvalidPassword");

			}

		}
		browser.switchTo().alert().accept();
	}
		
	public void Invalid_Cnfm_Pwd() throws Exception
	{
		User_Registration();
		String[] invalidCPassword={"1234567890","!@#$%"," "};
		for(String value :invalidCPassword)
		{
			sendKeys("xpath=//*[@id='"+"WC_UserRegistrationAddForm_FormInput_logonPasswordVerify_In_Register_1"+"']", value);			
			click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']/div[2]");//submit
			Boolean strMessage = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").isDisplayed();//error msg
			String strCnfm_Pwd = findTheElement("xpath=//*[@id='UserRegistrationErrorMessage']").getText();
			if(strMessage)
			{
				//System.out.println("Message Displayed:Invalid Confrm_Password"+ strCnfm_Pwd);
				test = extent.createTest("CIRCUIT CITY - Registration :Message Displayed- Invalid Confirm Password",strCnfm_Pwd);

			}
			else
			{
				//System.out.println("Error Message NOT Displayed");
				test = extent.createTest("CIRCUIT CITY - Registration :Error Message NOT Displayed for- Invalid Confirm Password");

			}

		}
		browser.switchTo().alert().accept();
	}
	
	public void Reg_Success() throws Exception
	{
		User_Registration();
        
	}
	
	public void User_Registration() throws Exception
	{
		Thread.sleep(5000);
//		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
//		Thread.sleep(5000);
//		click("//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_3']/span");
		
		//first name
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']");
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']", "zainab");
		
		
		//LastName
		click("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']");
		sendKeys("xpath=//*[@id='WC__NameEntryForm_FormInput_lastName_1']", "firdaus");
		
		//email id
		click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']");
		sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", "zainab.ss@royalcyber.com");
		
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
		click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']/div[2]");
		
		
		//logout
//		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown_SignOut']/span");
		
	}
	
 public  void  chkValidation() throws Exception
 {

		Thread.sleep(3000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']"); ///signin
		click("xpath=//*[@id='WC_UserRegistrationAddForm_links_1']");//create acc
		
		String[] ids={"username","password"};
		Map<String,List<String>> values=new HashMap<>();
     List <String> list = new ArrayList<>();
     list.add("");
     list.add("!@#$%^&*()");
     list.add("1234567890");
     values.put("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1",list);// to chck
     values.put("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']",list); //to chck
     values.put("emailid",list);
	
		for(String id:ids)
		{
			for(String value : values.get(id))
			{

				click("xpath=//*[@id='"+id+  "']");

				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1']", value);

				String msgError = findTheElement("xpath=//*[@id='WC__NameEntryForm_FormInput_firstName_1']").getText();
				System.out.println(msgError);
				Boolean strMessage =findTheElement("xpath=//*[@id='Header_GlobalLogin_logonErrorMessage_GL']").isDisplayed();
				if(strMessage)
				{
					//System.out.println("Message Displayed:"+ msgError);
					test = extent.createTest("CIRCUIT CITY - Registration :Message Displayed-",msgError);

				}
				else
				{
					//System.out.println("Error Message NOT Displayed");
					test = extent.createTest("CIRCUIT CITY - Registration :Message NOT Displayed");

				}

			}
		}
		
		
	 
 }
}
