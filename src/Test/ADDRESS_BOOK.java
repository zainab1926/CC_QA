package Test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class ADDRESS_BOOK extends Browser
{
   //adding content for checking purpose-JIRA Issue DA-5
	//public WebDriver browser = BrowserFactory.getBrowser("Browser","url");
//	Browser br  = new Browser();
	Report rpt = new Report();
	WebDriver wd;

	
	
	/*public void first()throws Exception
	{
		//changing again to check the status of issue -DA-5
		chkLogin("zzz@gmail.com","zainab123");
		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a"); //my acc
	}
	
	public void chkLogin(String Username,String Password)throws Exception
	{
		//Thread.sleep(5000);
		click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		Thread.sleep(4000);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", Username);
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", Password);
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
					
	}*/
	
	public void executeAllTest()throws Exception
	{
		//first();
		//chk_details();
		//lines added
		/*  click("xpath=//*[@id='Header_GlobalLogin_signInQuickLink']");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1']", "zainab.fff@royalcyber.com");
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']");
		sendKeys("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1']", "zainab123");
		
		click("xpath=//*[@id='Header_GlobalLogin_WC_AccountDisplay_links_2']");
		click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a"); //my acc
	*/
		 
		chk_AccSection();
		chk_Sections();
		verify_myAcc();
		verify_myAccPage();
		chk_existing_Add();
		verifyAddNewPage();
		field_Validation();
		//commented as Add address is not ging further after clicking on Save Button - 18/12/2017 - Mahesh
		//Add_Address();
		//updated_Add();
		remove_Add();
		
	}
	
 public void chk_details() throws Exception
 {
	//CC_ACC_001
	 			
	//click("xpath=//*[@id='Header_GlobalLogin_loggedInDropdown']/div/div/div/div[2]/div[1]/div[2]/a");
	
    
	String Actual  = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").getText();
	Boolean welcmMsg = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']/div/div[2]/div/div[1]/div[1]/div").isDisplayed();
	String Expected="GOOD Morning";
     if(Actual == Expected)
                   {
	                
    	            rpt.createTest("CC-Address Book-Check details", "Message"+Actual+" Displayed For Welcome Message:");
    	            rpt.Info("Expected Message"+Expected+"Is Matching with "+Actual +"Message For Welcome Message:");
    	            rpt.Pass("Message"+Expected+" Displayed- For Welcome Message:");
    	            rpt.Category("CC_Address Book_Check_Details");
      		        String path = rpt.CaptureScreen(browser, "ValidMessage");
      		        rpt.imgPathPass(path);
    	            
                    }
                      else
                    {
	                 
          	          rpt.createTest("CC-Address Book-Check details", "Message"+Actual+" Displayed- For Welcome Message:");
          	          rpt.Info("Expected Message"+Expected+ "Not Matching with "+Actual +"Message");
          	          rpt.Fail("Message"+Expected+" NOT Displayed- For Welcome Message:");  
          	          rpt.Category("CC_Address Book_Check_Details");
      		          String path = rpt.CaptureScreen(browser, "InvalidMessage");
      		          rpt.imgPathFail(path);
                     }
 }
     
    /* String Actual_pInfo  = findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_0']").getText();
     Boolean personalInfo = findTheElement("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_0']").isDisplayed();
     String Expected_pInfo="Personal Information";
     if(Actual_pInfo == Expected_pInfo)
        {

         rpt.createTest("CC-Address Book-Check details", "Message"+Actual_pInfo+" Displayed For Personal Information:");
         rpt.Info("Expected Message"+Expected_pInfo+"Is Matching with "+Actual_pInfo +"Message:");
         rpt.Pass("Message"+Expected_pInfo+" Displayed- For Personal Information:");  
         rpt.Category("CC_Address Book_Check_Details");
	     String path = rpt.CaptureScreen(browser, "ValidMessage");
	     rpt.imgPathPass(path);
         }
         else
        {
        	 rpt.createTest("CC-Address Book-Check details", "Message"+Actual_pInfo+" Displayed- For Personal Information:");
 	          rpt.Info("Expected Message"+Expected_pInfo+ "Not Matching with "+Actual_pInfo +"Message:");
 	          rpt.Fail("Message"+Expected_pInfo+" NOT Displayed- For Personal Information:");  
 	         rpt.Category("CC_Address Book_Check_Details");
		      String path = rpt.CaptureScreen(browser, "InvalidMessage");
		      rpt.imgPathFail(path);
        }
 }
     
     
    /* Boolean personalEdit = findTheElement("xpath=//*[@id='WC_MyAccountCenterLinkDisplay_inputs_1']").isDisplayed();
     if(personalEdit)
     {
      System.out.println("edit Message Displayed:"+ personalEdit);
      //test = extent.createTest("CIRCUIT CITY - Address Book :Edit option Displayed:", personalEdit);

      }
        else
     {
    System.out.println("edit Message NOT Displayed");
     //test = extent.createTest("CIRCUIT CITY - Address Book :Edit option NOT Displayed");
     }
     
     
     Boolean recentOrder = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']").isDisplayed();
     if(recentOrder)
     {
      System.out.println(" Message Displayed:"+ recentOrder);
      //test = extent.createTest("CIRCUIT CITY - Address Book :Recent Order History option displayed:", recentOrder);

      }
        else
     {
     System.out.println("Message NOT Displayed");
     // test = extent.createTest("CIRCUIT CITY - Address Book :Recent Order History option NOT displayed");

     }
     
     Boolean viewOrder = findTheElement("xpath=//*[@id='Processed_View_All_Orders']").isDisplayed();
     if(viewOrder)
     {
      System.out.println(" Message Displayed:"+ viewOrder);
      // test = extent.createTest("CIRCUIT CITY - Address Book : View all orders option displayed:", viewOrder);
 
      
      }
        else
     {
     System.out.println("Message NOT Displayed");
     //test = extent.createTest("CIRCUIT CITY - Address Book : View all orders option NOT displayed");
  	
     }
     
     Boolean recurringOrder = findTheElement("xpath=//*[@id='container_MyAccountDisplayB2B']").isDisplayed();
     if(recurringOrder)
     {
      System.out.println(" Message Displayed:"+ recurringOrder);
      // test = extent.createTest("CIRCUIT CITY - Address Book : Recent recurring orders option displayed:", recurringOrder);
 
      }
        else
     {
     System.out.println("Message NOT Displayed");
     //test = extent.createTest("CIRCUIT CITY - Address Book : Recent recurring orders option NOT displayed");

     }
     
     Boolean viewRecurring = findTheElement("xpath=//*[@id='Recurring_View_All_Orders']").isDisplayed();
     if(viewRecurring)
     {
      System.out.println(" Message Displayed:"+ viewRecurring);
      //test = extent.createTest("CIRCUIT CITY - Address Book : View recurring orders option displayed:", viewRecurring);

      }
        else
     {
     System.out.println("Message NOT Displayed");
     //test = extent.createTest("CIRCUIT CITY - Address Book : View recurring orders option NOT displayed");

     }
 } */  
     
     //CC_ACC_002
     public void chk_AccSection() throws Exception
     {
     Map<String,String> ids= new HashMap<String,String>();
	 ids.put("Settings", "section_button_settings");
	 ids.put("Wishlist", "section_button_wishlists");
	 ids.put("Orders", "section_button_orders");
	 ids.put("Gifts", "section_button_coupons");
	 for(Map.Entry<String, String> id : ids.entrySet() )
	 {
		 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
		 {
			 //System.out.println(id.getKey() + " is displayed ");
	         //rpt.createTest("CC-Address Book-Check Account section", "Message"+id.getKey()+" Displayed For Account Section:");
	         
	         rpt.createTest("CC-Address Book-Check Account Section", "Message :"+id.getKey()+" Displayed - For Account Section");
	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Account Section");
	         rpt.Category("CC_Address Book-Check Account Section");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);

			 
		 }
		 else
		 {
			 //System.out.println(id.getKey() + " is not displayed ");
	         //rpt.createTest("CC-Address Book-Check Account section", "Message"+id.getKey()+" is NOT Displayed For Account Section:");
	         
	         rpt.createTest("CC-Address Book-Check Account Section", "Message :"+id.getKey()+"is NOT Displayed - For Account Section");
	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Account Section");
	         rpt.Category("CC_Address Book-Check Account Section");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);

		 }
	 }
     }
     
   //CC_ACC_003
	 
    public void chk_Sections() throws Exception
    {
   // click("xpath=//*[@id='section_button_settings");
   
     Map<String,String> ids= new HashMap<String,String>();
	 ids.put("Personal Information", "WC_MyAccountSidebarDisplayf_links_0");
	 ids.put("Change Password", "WC_MyAccountSidebarDisplayf_links_1");
	 ids.put("Address Book", "WC_MyAccountSidebarDisplayf_links_2");
	 ids.put("Quick Checkout Profile", "WC_MyAccountSidebarDisplayf_links_3");
	 ids.put("Saved Cards","WC_MyAccountSidebarDisplayf_links_0");
	 ids.put("Tax Exemption","WC_MyAccountSidebarDisplayf_links_0");
	 
	 for(Map.Entry<String, String> id : ids.entrySet() )
	 {
		 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
		 {
			 //System.out.println(id.getKey() + " is displayed ");
	         //rpt.createTest("CC-Address Book-Check Section", "Message"+id.getKey()+" Displayed For Settings Section:");
	         
	         rpt.createTest("CC-Address Book-Check Settings Section", "Message :"+id.getKey()+" Displayed - For Settings Section");
	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Settings Section");
	         rpt.Category("CC_Address Book-Check Settings Section");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);

		 }
		 else
		 {
			 //System.out.println(id.getKey() + " is not displayed ");
			 
			 rpt.createTest("CC-Address Book-Check Settings Section", "Message :"+id.getKey()+"is NOT Displayed - For Settings Section");
	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Settings Section");
	         rpt.Category("CC_Address Book-Check Settings Section");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	 }
    }
   
    //CC_ACC_004
    public void verify_myAcc()throws Exception
    {
    	 Map<String,String> ids= new HashMap<String,String>();
    	 ids.put("Settings", "section_button_settings");
    	 ids.put("Wishlist", "section_button_wishlists");
    	 ids.put("Orders", "section_button_orders");
    	 ids.put("Gifts", "section_button_coupons");
    	 for(Map.Entry<String, String> id : ids.entrySet() )
    	 {
    		 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
    		 {
    			 //System.out.println(id.getKey() + " is displayed ");
    	         
    	         rpt.createTest("CC-Address Book-Verify My Account", "Message :"+id.getKey()+" Displayed - For Verify My Account");
    	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account");
    	         rpt.Category("CC_Address Book-Verify My Account");
    	         String path = rpt.CaptureScreen(browser, "ValidMessage");
    	         rpt.imgPathPass(path);

    		 }
    		 else
    		 {
    			//System.out.println(id.getKey() + " is not displayed ");
    			 rpt.createTest("CC-Address Book-Verify My Account", "Message :"+id.getKey()+"is NOT Displayed - For Verify My Account");
    	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Verify My Account");
    	         rpt.Category("CC_Address Book-Verify My Account");
    	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	         rpt.imgPathFail(path);
    		 }
    	 }		 
    }
     
    //CC_ACC_005
	public void verify_myAccPage() throws Exception
	{
		 Map<String,String> ids= new HashMap<String,String>();
		 ids.put("Personal Information", "WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Change Password", "WC_MyAccountSidebarDisplayf_links_1");
		 ids.put("Address Book", "WC_MyAccountSidebarDisplayf_links_2");
		 ids.put("Quick Checkout Profile", "WC_MyAccountSidebarDisplayf_links_3");
		 ids.put("Saved Cards","WC_MyAccountSidebarDisplayf_links_0");
		 ids.put("Tax Exemption","WC_MyAccountSidebarDisplayf_links_0");
		 
		 for(Map.Entry<String, String> id : ids.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				 //System.out.println(id.getKey() + " is displayed ");
				 
    	         
    	         rpt.createTest("CC-Address Book-Verify My Account Page", "Message :"+id.getKey()+" Displayed - For Verify My Account Page");
    	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify My Account Page");
    	         rpt.Category("CC_Address Book-Verify My Account Page");
    	         String path = rpt.CaptureScreen(browser, "ValidMessage");
    	         rpt.imgPathPass(path);


			 }
			 else
			 {
				 //System.out.println(id.getKey() + " is not displayed ");
				 
				 rpt.createTest("CC-Address Book-Verify My Account Page", "Message :"+id.getKey()+"is NOT Displayed - For Verify My Account Page");
    	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Verify My Account Page");
    	         rpt.Category("CC_Address Book-Verify My Account Page");
    	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
    	         rpt.imgPathFail(path);
			 }
		 }
	}
    
    //CC_ACC_006
    public void chk_existing_Add()throws Exception
    {
    	click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_2']");
    	click("xpath=//*[@id='WC_AjaxAddressBookForm_links_1']");	
    	
    }
	 
    
    //CC_ACC_007
    public void verifyAddNewPage() throws Exception
    {
	 Map<String,String> ids= new HashMap<String,String>();
	 //ids.put("Radio Button", ""); //not there on page
	 ids.put("Add Shipping Address", "container_MyAccountDisplayB2B");
	 ids.put("First Name", "WC_AccountForm_NameEntryForm_FormInput_firstName_1");
	 ids.put("Last Name", "WC_AccountForm_NameEntryForm_FormInput_lastName_1");
	 ids.put("Address Line1", "WC_AccountForm_AddressEntryForm_FormInput_address1_1");
	 ids.put("Address Line2", "WC_AccountForm_AddressEntryForm_FormInput_address2_1");
	 ids.put("City", "WC_AccountForm_AddressEntryForm_FormInput_city_1");
	 ids.put("State", "WC_AccountForm_AddressEntryForm_FormInput_state_1");
	 ids.put("Country/Region", "WC_AccountForm_AddressEntryForm_FormInput_country_1-button");
	 ids.put("Zip Code", "WC_AccountForm_AddressEntryForm_FormInput_zipCode_1");
	 ids.put("Address Nickname", "nickName");
	 ids.put("Phone No", "WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1");
     ids.put("Save","WC_AjaxAddressBookForm_links_4a");
     ids.put("Cancel","WC_MyAccountSidebarDisplayf_links_2");
     Thread.sleep(4000);
	 for(Map.Entry<String, String> id : ids.entrySet() )
	 {
		 //Thread.sleep(4000);
		 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
		 {
			 //System.out.println(id.getKey() + " is displayed ");
			 Thread.sleep(2000);
	         rpt.createTest("CC-Address Book-Verify Add New Page", "Message :"+id.getKey()+" Displayed - For Verify Add New Page");
	         rpt.Pass("Message :"+id.getKey()+" Displayed - For Verify Add New Page");
	         rpt.Category("CC_Address Book-Verify Add New Page:");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);

		 }
		 else
		 {
			//System.out.println(id.getKey() + " is not displayed ");
			 
			 rpt.createTest("CC-Address Book-Verify Add New Page", "Message :"+id.getKey()+"is NOT Displayed - For Verify Add New Page");
	         rpt.Pass("Message :"+id.getKey()+" NOT Displayed - For Verify Add New Page");
	         rpt.Category("CC_Address Book-Verify Add New Page");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		 }
	 }
    }
 


     //CC_ACC_008
      public void field_Validation()throws Exception
      {
    	  Thread.sleep(2000);
    	click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_2']"); //addressbook
    	click("xpath=//*[@id='WC_AjaxAddressBookForm_links_1']"); //add address
    	 Thread.sleep(2000);
    	click("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']");//first name
    	 Thread.sleep(2000);
    	sendKeys("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']", "zoo");
    	
        String[] invalidName={"1234567890","!@#$%"," "};
        Thread.sleep(2000);
		
		for(String value :invalidName)
		{

			sendKeys("xpath=//*[@id='"+"WC_AccountForm_NameEntryForm_FormInput_lastName_1"+"']", value);
			
			click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']/div[2]");  

			 Thread.sleep(2000);
			 String Actual=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_lastname']").getText();
			Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_lastname']").isDisplayed();//error msg
			String Expected="The last name field cannot be empty";
			if(Actual == Expected)
			{

			    rpt.createTest("CC-Address Book-Invalid Name", "Message"+Expected+" Displayed- For Invalid Name");
			    rpt.Info("Expected Message "+Expected+"  Is Matching with "+Actual +"Message");
			    rpt.Pass("Message "+Expected+" Displayed- For Invalid Name");
			    rpt.Category("CC_Address Book-Invalid Name:");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
               rpt.createTest("CC-Address Book-Invalid Name", "Message"+Actual+" Displayed- For Invalid Name");
			    rpt.Info("Expected Message "+Expected+ " Not Matching with "+Actual +"Message");
			    rpt.Fail("Message "+Expected+" NOT Displayed- For Invalid Name");
			    rpt.Category("CC_Address Book-Invalid Name");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}

		}
		sendKeys("xpath=//*[@id='"+"WC_AccountForm_NameEntryForm_FormInput_lastName_1"+"']", "fird");
		 String[] invalidAddress={"!@#$%"," "};
			
			
			for(String value :invalidAddress)
			{
				 Thread.sleep(2000);

				sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address1_1']", value);
				
				click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");  

				 Thread.sleep(2000);
                String actualAdd=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_1']").getText();
				Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_1']").isDisplayed();//error msg
				String expectedAdd="The street address field cannot be empty";
				if(actualAdd == expectedAdd)
				{

				    rpt.createTest("CC-Address Book-Invalid Address", "Message"+expectedAdd+" Displayed- For Invalid Address");
				    rpt.Info("Expected Message "+expectedAdd+" Is Matching with "+actualAdd +"Message");
				    rpt.Pass("Message "+expectedAdd+" Displayed- For Invalid Address");
				    rpt.Category("CC_Address Book-Invalid Address");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					//System.out.println("Error Message NOT Displayed");

		             rpt.createTest("CC-Address Book-Invalid Address", "Message"+actualAdd+" Displayed- For Invalid Address");
					 rpt.Info("Expected Message "+expectedAdd+ "Not Matching with "+actualAdd +"Message");
					 rpt.Fail("Message "+expectedAdd+" NOT Displayed- For Invalid Address");
					 rpt.Category("CC_Address Book-Invalid Address");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				    
				}

			}
			
			sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address1_1']", "bh area");
			 String[] invalidCity={"!@#$%"," "};
				
				
				for(String value :invalidCity)
				{
					 Thread.sleep(2000);

					sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_city_1']", value);
					
					click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");  

					 Thread.sleep(2000);
                    String actualCity=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_4']").getText();
					Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_4']").isDisplayed();//error msg
					String expectedCity="The city field cannot be empty";
					if(actualCity == expectedCity)
					{
						//System.out.println("Message Displayed for city:"+ strMessage);

					    rpt.createTest("CC-Address Book-Invalid City", "Message"+expectedCity+" Displayed- For Invalid City");
					    rpt.Info("Expected Message "+expectedCity+"  Is Matching with "+actualCity +"Message");
					    rpt.Pass("Message "+expectedCity+" Displayed- For Invalid City");
					    rpt.Category("CC_Address Book-Invalid City");
				         String path = rpt.CaptureScreen(browser, "ValidMessage");
				         rpt.imgPathPass(path);
					}
					else
					{
						//System.out.println("Error Message NOT Displayed");
						 rpt.createTest("CC-Address Book-Invalid City", "Message"+actualCity+" Displayed- For Invalid City");
						 rpt.Info("Expected Message "+expectedCity+ "Not Matching with "+actualCity +"Message");
						 rpt.Fail("Message "+expectedCity+" NOT Displayed- For Invalid City");
						 rpt.Category("CC_Address Book-Invalid City");
				         String path = rpt.CaptureScreen(browser, "InvalidMessage");
				         rpt.imgPathFail(path);

					}

				}
				sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_city_1']", "jsr");
				 String[] invalidState={"!@#$%"," "};
					
					
					for(String value :invalidState)
					{
						 Thread.sleep(2000);

						sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_state_1']", value);
						
						click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");  

						 Thread.sleep(2000);
                        String actualState=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_10']").getText();
						Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_10']").isDisplayed();//error msg
						String expectedState="The state field cannot be empty";
						if(actualState == expectedState)
						{
							//System.out.println("Message Displayed for state:"+ strMessage);

							 rpt.createTest("CC-Address Book-Invalid State", "Message"+expectedState+" Displayed- For Invalid State");
							    rpt.Info("Expected Message "+expectedState+" Is Matching with "+actualState +"Message");
							    rpt.Pass("Message "+expectedState+" Displayed- For Invalid State");
							    rpt.Category("CC_Address Book-Invalid State");
						         String path = rpt.CaptureScreen(browser, "ValidMessage");
						         rpt.imgPathPass(path);
						}
						else
						{
							//System.out.println("Error Message NOT Displayed");

							rpt.createTest("CC-Address Book-Invalid State", "Message"+actualState+" Displayed- For Invalid State");
							 rpt.Info("Expected Message "+expectedState+ "Not Matching with "+actualState +"Message");
							 rpt.Fail("Message "+expectedState+" NOT Displayed- For Invalid State");
							 rpt.Category("CC_Address Book-Invalid State");
					         String path = rpt.CaptureScreen(browser, "InvalidMessage");
					         rpt.imgPathFail(path);
						}

					}
					sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_state_1']", "bih");
					
					/*click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_country_1-button']");//country
		            click("xpath=//*[@id='ui-id-61']");//selecting from drop down
		            sendKeys("xpath=//*[@id='ui-id-61']","India");*/
					 
					
					
					
					String[] invalidZipcode={"!@#$%"," "};
						
						
						for(String value :invalidZipcode)
						{
							 Thread.sleep(2000);

						    sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_zipCode_1']", value);
							
							click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");  

							 Thread.sleep(2000);
                            String actualZcode=findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_13']").getText();
							Boolean strMessage = findTheElement("xpath=//*[@id='WC_AddressEntryForm_div_13']").isDisplayed();//error msg
							String expectedZcode="The zip code field cannot be empty";
							if(actualZcode == expectedZcode)
							{
								//System.out.println("Message Displayed for zip:"+ strMessage);
								rpt.createTest("CC-Address Book-Invalid Zip code", "Message"+expectedZcode+" Displayed- For Invalid Zip code");
							    rpt.Info("Expected Message "+expectedZcode+" Is Matching with "+actualZcode +"Message");
							    rpt.Pass("Message "+expectedZcode+" Displayed- For Invalid Zip code");
							    rpt.Category("CC_Address Book-Invalid Zip code");
						         String path = rpt.CaptureScreen(browser, "ValidMessage");
						         rpt.imgPathPass(path);

							}
							else
							{
								//System.out.println("Error Message NOT Displayed");
								rpt.createTest("CC-Address Book-Invalid Zip code", "Message"+actualZcode+" Displayed- For Invalid Zip code");
								 rpt.Info("Expected Message "+expectedZcode+ "Not Matching with "+actualZcode +"Message");
								 rpt.Fail("Message "+expectedZcode+" NOT Displayed- For Invalid Zip code");
								 rpt.Category("CC_Address Book-Invalid Zip code");
						         String path = rpt.CaptureScreen(browser, "InvalidMessage");
						         rpt.imgPathFail(path);

							}

						}
						sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_zipCode_1']", "100000");
						
						String[] invalid_AddNickname={"!@#$%"," "};
							
							
							for(String value :invalid_AddNickname)
							{
								 Thread.sleep(2000);

								sendKeys("xpath=//*[@id='nickName']", value);
								
								click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");  

								 Thread.sleep(2000);
                                String actualNname=findTheElement("xpath=//*[@id='WC_AccountForm_div_9']").getText();
								Boolean strMessage = findTheElement("xpath=//*[@id='WC_AccountForm_div_9']").isDisplayed();//error msg
								String expectedNname="The recipient field cannot be empty";
								if(actualNname == expectedNname )
								{
									//System.out.println("Message Displayed for niick:"+ strMessage);
									rpt.createTest("CC-Address Book-Invalid Address Nick name", "Message"+expectedNname+" Displayed- For Invalid Address nick name");
								    rpt.Info("Expected Message "+expectedNname+" Is Matching with "+actualNname +"Message");
								    rpt.Pass("Message "+expectedNname+" Displayed- For Invalid Address nick name");
								    rpt.Category("CC_Address Book-Invalid Address Nick name");
							         String path = rpt.CaptureScreen(browser, "ValidMessage");
							         rpt.imgPathPass(path);

								}
								else
								{
									//System.out.println("Error Message NOT Displayed");
									rpt.createTest("CC-Address Book-Invalid Address Nick name", "Message"+actualNname+" Displayed- For Invalid Address nick name");
									 rpt.Info("Expected Message "+expectedNname+ "Not Matching with "+actualNname +"Message");
									 rpt.Fail("Message "+expectedNname+" NOT Displayed- For Invalid Address nick name:");
									 rpt.Category("CC_Address Book-Invalid Address Nick name");
							         String path = rpt.CaptureScreen(browser, "InvalidMessage");
							         rpt.imgPathFail(path);

								}

							}
							 Thread.sleep(4000);
                          sendKeys("xpath=//*[@id='nickName']","soloquenine1");
							
				click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");//phone no
				sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']", "9898989890");
				click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");								
      }
   
   
  //cc_ACC_009
  public void Add_Address()throws Exception
  {
	  click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_2']");
	  Thread.sleep(3000);
	  
	  Screen s = new Screen();
	  Pattern img=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\AddAddress_CC.png");
	  Thread.sleep(2000);
	  s.click(img);
	  click("xpath=//*[@id='WC_AjaxAddressBookForm_links_1']");
	  
	  
	  Thread.sleep(8000);
	  click("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']");//first name
	  Thread.sleep(5000);//WC_AccountForm_NameEntryForm_FormInput_firstName_1'
	  sendKeys("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']", "mahesh");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_lastName_1']");//last name
	  sendKeys("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_lastName_1']", "NVS");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address1_1']");//address1
	  sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address1_1']", "VB road");
	  Thread.sleep(1000);
	  
	  click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address2_1']");//address2
	  sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_address2_1']", "Mumbai");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_city_1']");//city
	  sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_city_1']", "Mumbai");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_state_1']");//state
	  sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_state_1']", "MH");
	  Thread.sleep(1000);
	  
	  /*click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_country_1-button']/span[1]");//country
	  Select country= new Select(getBrowser().findElement(By.xpath("//*[@id='WC_AccountForm_AddressEntryForm_FormInput_country_1-button']/span[1]")));
	  country.selectByVisibleText("India");*/
	 
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_zipCode_1']");//zipcode
	  sendKeys("xpath=//*[@id='WC_AccountForm_AddressEntryForm_FormInput_zipCode_1']", "400057");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='nickName']");//address nick name
	  sendKeys("xpath=//*[@id='nickName']","adda");
	  Thread.sleep(1000);

	  click("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']");//phone no
	  sendKeys("xpath=//*[@id='WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1']", "9090909090");
	  click("xpath=//*[@id='WC_AjaxAddressBookForm_links_4a']");//save
	  //welcome msg is nt displaying
	  
  }
	 
  //CC_ACC_10
 /* public void updated_Add()throws Exception
  {
	  System.out.println("in updated add");
	  click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_2']");
	  click("xpath=//*[@id='11866350065Icon']");
	  
	  click("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']");//updating data
	  sendKeys("xpath=//*[@id='WC_AccountForm_NameEntryForm_FormInput_firstName_1']", "zac");
	  
	  click("xpath=//*[@id='11866350065']/div/div/a[1]/div[2]/span");//save
	  
	  Boolean strMessage = findTheElement("xpath=//*[@id='ErrorMessageText']").isDisplayed();//updated msg
		if(strMessage)
		{
			System.out.println("Message Displayed:"+ strMessage);
		}
		else
		{
			System.out.println("Error Message NOT Displayed");
		}
	  
	  
  }*/
   
  //CC_ACC_11
  public void remove_Add()throws Exception
  {
	  
	  click("xpath=//*[@id='WC_MyAccountSidebarDisplayf_links_2']");
	  Thread.sleep(4000);
	  //click("xpath=//*[@id='WC_AjaxAddressBookForm_links_2']");
	  Screen s = new Screen();
	  Pattern img=new Pattern("C:\\CI_CD_CT\\Sikuli\\Images\\RemoveAdd_CC.png");
	  Thread.sleep(4000);
	  s.click(img);
	  Thread.sleep(2000); 
	  /*String actualRadd= findTheElement("xpath=//*[@id='ErrorMessageText']").getText();
	  Boolean strMessage = findTheElement("xpath=//*[@id='ErrorMessageText']").isDisplayed();//remove msg
	  String expectedRadd="The selected address has been removed from the address list";
		if(actualRadd == expectedRadd )
		{
			//System.out.println("Message Displayed:"+ strMessage);

		    rpt.createTest("CC-Address Book-Remove Address", "Message"+expectedRadd+" Displayed- For removing address :");
		    rpt.Info("Expected Message"+expectedRadd+"Is Matching with "+actualRadd +"Message");
		    rpt.Pass("Message"+expectedRadd+" Displayed- For removing address :");
		    rpt.Category("CC_Address Book-Remove Address");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Error Message NOT Displayed");

		    rpt.createTest("CC-Address Book-Remove Address", "Message"+actualRadd+" Displayed- For removing address :");
		    rpt.Info("Expected Message"+expectedRadd+ "Not Matching with "+actualRadd +"Message");
		    rpt.Fail("Message"+expectedRadd+" NOT Displayed- For removing address :");
		    rpt.Category("CC_Address Book-Remove Address");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}*/
	  
	  
  }
  
  
  }