package Test;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage extends Browser {
	Report rpt = new Report();
	//Browser br = new Browser();

	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	
	public void ExecuteAll_HomePage() throws Exception
	{
		homePage(); //TC-1
		HP_logoHyperlink();

		mainBanner(); //TC-6
		Hp_ShopNow_TopDeal();

		HP_LearnMore();

		HP_ShopNow_FeaturedProduct(); 

//		//HP_Discover_LearnMore(); //To Ask

		customiseRoom(); //TC-13 //
		smartRoom(); //TC-14   //
		featuredProduct(); //TC-15 
		HP_discoverMore();
     	ShopAllTopCategories(); //TC 25
		bestSeller(); //TC -26
		//shopNow_FeaturedProduct(); //TC 27 //repeated Tc
		bannerDisplay(); //TC-32

		HP_Chat();

//		HP_Call(); out of scope

		HP_Email();

		HP_PriceMatchguarantee();

		HP_FreeShipping();

//		HP_ScheduleService(); //TC 38 missing in prod-live
		HP_Subscribe();
		connectWithUs();
		HP_SigninOrCreateAccount();
		HP_wishlistFooter();
		
		HP_RebatesFooter();
		HP_OrderStatusFooter();
		
		HP_OrderHistoryFooter();
		HP_ShippingAndDeliveryFooter();

		HP_ReturnAndExchange();
		
		HP_ReturnAnItemFooter();
		HP_ContactUsFooter();
		HP_Help();
		HP_CustomerServicesFooter();
		HP_ProtectionPlanFooter();
		HP_TradeInProgramFooter();
		HP_ProductRecallsFooter();
		HP_PrivacyAndSecurityFooter();
		HP_FeedbackFooter();
		Installations();
		AboutUs();
		OurStory();
		HP_CareerFooter();
		PartnerWithUs();
		HP_featuredProductsCarosel();
		HP_BestSellerCarosel();
		HP_twitterFooter();
		HP_FacebookFooter();
		HP_YouTubeFooter();
		HP_PinterestFooter();
		HP_InstagramFooter();
		HP_GooglePlusFooter();
		
	}
	
	//CC_HP_001
	public void homePage() throws Exception
	{	
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		if(HomePagetitle.contains("CircuitCity Electronics, Camera, Video, Photo, Appliances, Accessories"))
		{
			//System.out.println("Passed");
			 rpt.createTest("CIRCUIT CITY - Verify Home Page Title", "Home Page is displayed : " +HomePagetitle);
	         rpt.Pass("Home Page is displayed : " +HomePagetitle);
	         rpt.Category("CIRCUIT CITY - Verify Home Page Title");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
		}
		else
		{
			//System.out.println("Failed");
			rpt.createTest("CIRCUIT CITY - Verify Home Page Title", "Home Page NOT displayed");
	         rpt.Fail("Home Page NOT displayed");
	         rpt.Category("CIRCUIT CITY - Verify Home Page Title");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
		}
		//header
		
		 Map<String,String> fields= new HashMap<String,String>();
   	  fields.put("FREE SHIPPING over $35*", "//div[@id='sample']/label");
   	  fields.put("24/7 Help | 1-877-234-8013 or Live Chat", ".//*[@id='header']/div[1]/div/div[2]");
   	  fields.put("Circuit City Logo", "//*[@id='logo']");
   	  fields.put("Search Box", "//*[@id='searchBar']");
   	  fields.put("Deal of the Day", "//div[@id='deal_of_the_day']/a/div[2]/p/span");
   	  fields.put("Save $250 on Apple 13.3 MacBook Pro", ".//*[@id='deal_of_the_day']/a/div[2]/p[2]");
   	  fields.put("Sign In", "//*[@id='Header_GlobalLogin_signInQuickLink']");
   	   fields.put("WishList", "//*[@id='wishListQuickLink_alt']");
   	   fields.put("Cart", "//*[@id='widget_minishopcart']");
   		
   		 for(Map.Entry<String, String> field : fields.entrySet() )
   		 {
   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
   			 {
   				 rpt.createTest("CIRCUIT CITY - Verify Header Content", "Header Content :"+field.getKey()+" Displayed ");
   		         rpt.Pass("Header Content :"+field.getKey()+" Displayed ");
   		         rpt.Category("CIRCUIT CITY - Verify Header Content");
   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
   		         rpt.imgPathPass(path);
   			 }
   			 else
   			 {
   				 rpt.createTest("CIRCUIT CITY - Verify Header Content", "Header Content :"+field.getKey()+" NOT Displayed");
   		         rpt.Fail("Header Content :"+field.getKey()+" NOT Displayed");
   		         rpt.Category("CIRCUIT CITY - Verify Header Content");
   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
   		         rpt.imgPathFail(path);
   			 }
   		 }
				 
		
		//category navigation
		Map<String,String> ids1= new HashMap<String,String>();
		 ids1.put("Products", "allDepartmentsButton");
		 ids1.put("Deals", "departmentButton_deals");
		 ids1.put("Services", "departmentButton_service");
		 ids1.put("Brands", "departmentButton_brands");
		 ids1.put("The City","departmentButton_thecity");
		 
		 
		 click("id=allDepartmentsButton"); //products
		 click("id=departmentButton_deals"); //deals
		 click("id=departmentButton_service"); //services
		 click("id=departmentButton_brands"); //brands
		 click("id=departmentButton_thecity"); //the city
		 
		 for(Map.Entry<String, String> id : ids1.entrySet() )
		 {
			 if(findTheElement("xpath=//*[@id='"+id.getValue()+"']").isDisplayed())
			 {
				
   	         rpt.createTest("CIRCUIT CITY - Verify Category Navigation", "Category :"+id.getKey()+" Displayed and is navigated to "+id.getKey()+" Page");
   	         rpt.Pass("Category :"+id.getKey()+" Displayed and is navigated to "+id.getKey()+" Page");
   	         rpt.Category("CIRCUIT CITY - Verify Category Navigation");
   	         String path = rpt.CaptureScreen(browser, "ValidMessage");
   	         rpt.imgPathPass(path);


			 }
			 else
			 {
			 rpt.createTest("CIRCUIT CITY - Verify Category Navigation", "Category :"+id.getKey()+"is NOT Displayed and NOT navigated to "+id.getKey()+" Page");
   	         rpt.Pass("Category :"+id.getKey()+"is NOT Displayed and NOT navigated to "+id.getKey()+" Page");
   	         rpt.Category("CIRCUIT CITY - Verify Category Navigation");
   	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
   	         rpt.imgPathFail(path);
			 }
		 }
		 
		 //search 
		 String searchbox=findTheElement("id=searchBar").getText();
		 System.out.println(searchbox);
			if(findTheElement("id=searchBar").isDisplayed())
			 {
		         rpt.createTest("CIRCUIT CITY - Verify Search Box", "Search Box is displayed : " +searchbox);
		         rpt.Pass("Search Box is displayed : " +searchbox);
		         rpt.Category("CIRCUIT CITY - Verify Search Box");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			 }
			 else
			 {
				 rpt.createTest("CIRCUIT CITY - Verify Search Box", "Search Box NOT displayed");
		         rpt.Fail("Search Box NOT displayed");
		         rpt.Category("CIRCUIT CITY - Verify Search Box");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			 }
		 
		 click("id=contentImage_1_HeaderStoreLogo_Content"); //logo
		 Thread.sleep(3000);
		 //footer
		
			/* Map<String,String> fields1= new HashMap<String,String>();
		   	  fields1.put(" 24/7 Support", "/html/body/div[4]/div[1]/div[1]/span[1]");
		   	 // fields1.put("Have a question? We're here to help.", "/html/body/div[4]/div[1]/div[1]/span[2]");
		   	  fields1.put("CHAT", "/html/body/div[4]/div[1]/div[1]/span[3]/a[1]");
		   	  fields1.put("CALL", "/html/body/div[4]/div[1]/div[1]/span[3]/a[2]");
		   	  fields1.put("EMAIL", "/html/body/div[4]/div[1]/div[1]/span[3]/a[3]");
		   	  fields1.put("Price Match Guarantee", "/html/body/div[4]/div[1]/div[3]/div[1]");
		   	  fields1.put("Free Shipping Over $35", "/html/body/div[4]/div[1]/div[3]/div[2]");
		   	   fields1.put("Schedule Service", "/html/body/div[4]/div[1]/div[3]/div[3]");
		   	   fields1.put("Subscribe", "//*[@id='footerSubscribe']");
		   	// fields1.put("My Account", "/html/body/div[5]/div[3]/div/div[1]/div/h3");
		   	//fields1.put("Sign in or Create Account", "/html/body/div[5]/div[3]/div/div[1]/ul/li[1]/a");
		   	//fields1.put("Wishlist", "/html/body/div[5]/div[3]/div/div[1]/ul/li[2]/a");
		   	//fields1.put("Rebates", "/html/body/div[5]/div[3]/div/div[1]/ul/li[3]/a");
		   	 //fields1.put("Customer Service", "/html/body/div[5]/div[3]/div/div[2]/div/h3");
		   	 fields1.put("Order Status", "/html/body/div[5]/div[3]/div/div[2]/ul/li[1]/a");
		   	 fields1.put("Order History", "/html/body/div[5]/div[3]/div/div[2]/ul/li[2]/a");
		   	 fields1.put("Shipping & Delivery", "/html/body/div[5]/div[3]/div/div[2]/ul/li[3]/a");
		   	 fields1.put("Return & Exchange Policy", "/html/body/div[5]/div[3]/div/div[2]/ul/li[4]/a");
		   	 fields1.put("Return an Item", "/html/body/div[5]/div[3]/div/div[2]/ul/li[5]/a");
		   	 fields1.put("Contact Us", "/html/body/div[5]/div[3]/div/div[2]/ul/li[6]/a");/*
		   	// fields1.put("Help", "/html/body/div[5]/div[3]/div/div[2]/ul/li[7]/a");
		   	 * 
		   	 
		   	  //fields1.put("Support & Service", "/html/body/div[5]/div[3]/div/div[3]/div/h3");
		   	// fields1.put("Customer Service", "/html/body/div[5]/div[3]/div/div[2]/div/h3");
		   	// fields1.put("Protection Plans", "/html/body/div[5]/div[3]/div/div[3]/ul/li[2]/a");
		   	 //fields1.put("Trade-In Program", "/html/body/div[5]/div[3]/div/div[3]/ul/li[3]/a");
		   	 //fields1.put("Product Recalls", "/html/body/div[5]/div[3]/div/div[3]/ul/li[4]/a");
		   	// fields1.put("Privacy & Security", "/html/body/div[5]/div[3]/div/div[3]/ul/li[5]/a");
		   	 //fields1.put("Feedback", "/html/body/div[5]/div[3]/div/div[3]/ul/li[6]/a");
		   	 //fields1.put("Installations", "/html/body/div[5]/div[3]/div/div[3]/ul/li[7]/a");
		   	  // fields1.put("Company Overview", "/html/body/div[5]/div[3]/div/div[4]/div/h3");
		   	 //fields1.put("About Us", "/html/body/div[5]/div[3]/div/div[4]/ul/li[1]/a");
		   	 //fields1.put("Our Story", "/html/body/div[5]/div[3]/div/div[4]/ul/li[2]/a");
		   	 //fields1.put("Careers", "/html/body/div[5]/div[3]/div/div[4]/ul/li[3]/a");
		   	 //fields1.put("Partner With Us", "/html/body/div[5]/div[3]/div/div[4]/ul/li[4]/a");
		   	 fields1.put("Connect With Us", "/html/body/div[4]/div[4]/h3");
		   	  fields1.put("Twitter", "/html/body/div[4]/div[4]/div[1]/a[1]");
		   	  fields1.put("Facebook", "/html/body/div[4]/div[4]/div[1]/a[2]");
		   	  fields1.put("Youtube", "/html/body/div[4]/div[4]/div[1]/a[3]");
		   	  fields1.put("Pinterest", "/html/body/div[4]/div[4]/div[1]/a[4]");
		   	  fields1.put("Instagram", "/html/body/div[4]/div[4]/div[1]/a[5]");
		   	  fields1.put("Google plus", "/html/body/div[4]/div[4]/div[1]/a[6]");
		   	  // fields1.put("Symantec", "/html/body/div[4]/div[5]/table");
		   	   fields1.put("TERMS", "/html/body/div[4]/div[5]/a[1]");
		   	 fields1.put("PRIVACY", "/html/body/div[4]/div[5]/a[2]");
		   	  
		   		
		   		 for(Map.Entry<String, String> field : fields1.entrySet() )
		   		 {
		   			 if (findTheElement("xpath=" + field.getValue() + "").isDisplayed())
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content :"+field.getKey()+" Displayed ");
		   		         rpt.Pass("Footer Content :"+field.getKey()+" Displayed ");
		   		         rpt.Category("CIRCUIT CITY - Verify Footer Content");
		   		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		   		         rpt.imgPathPass(path);
		   			 }
		   			 else
		   			 {
		   				 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content :"+field.getKey()+" NOT Displayed");
		   		         rpt.Fail("Footer Content :"+field.getKey()+" NOT Displayed");
		   		         rpt.Category("CIRCUIT CITY - Verify Footer Content");
		   		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		   		         rpt.imgPathFail(path);
		   			 }
		   		 }*/
		   		String myAcc=findTheElement("id=footerWrapper").getText();
				 System.out.println(myAcc);
					if(findTheElement("id=footerWrapper").isDisplayed())
					 {
				         rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content is displayed");
				         rpt.Pass("Footer Content is displayed : " +myAcc);
				         rpt.Category("CIRCUIT CITY - Verify Footer Content");
				         String path = rpt.CaptureScreen(browser, "ValidMessage");
				         rpt.imgPathPass(path);
					 }
					 else
					 {
						 rpt.createTest("CIRCUIT CITY - Verify Footer Content", "Footer Content NOT displayed");
				         rpt.Fail("Footer Content NOT displayed");
				         rpt.Category("CIRCUIT CITY - Verify Footer Content");
				         String path = rpt.CaptureScreen(browser, "InvalidMessage");
				         rpt.imgPathFail(path);
					 }		 
		   		 
	}	
	//CC_HP_002
	public void HP_logoHyperlink() throws Exception
	{
		Thread.sleep(3000);
		//click("id=contentImage_1_HeaderStoreLogo_Content");
		if (findTheElement(
				"id=contentImage_1_HeaderStoreLogo_Content")
				.isDisplayed()) {
			rpt.createTest("CC - Home Page - Verify Logo Hyperlink",
					"LogoHyperlink Displayed - For Verify Logo Hyperlink ");
			rpt.Pass("Logo Hyperlink Displayed - For Verify Logo Hyperlink");
			rpt.Category("CC_Home Page - Verify Logo Hyperlink");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("id=contentImage_1_HeaderStoreLogo_Content");

		} else {
			rpt.createTest("CC - Home Page - Verify Logo Hyperlink",
					"Logo Hyperlink Page is NOT Displayed - For Verify Logo Hyperlink");
			rpt.Fail("Logo Hyperlink Page is NOT Displayed - For Verify Logo Hyperlink");
			rpt.Category("CC_Home Page - Verify Logo Hyperlink");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}
		String HomePagetitle=Browser.getTitle();
		System.out.println(HomePagetitle);
		
		
		if(HomePagetitle.equals("Welcome to CircuitCityB2C"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
		}
		
		}
	//CC-TC 6
	public void mainBanner()throws Exception
	{
		
	}
	//CC_HP_009
	public void Hp_ShopNow_TopDeal() throws Exception
	{
		Thread.sleep(3000);
		//String ProdName=getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616682841_link_9b']");
		//click("xpath=/html/body/div[4]/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[1]/div/div[1]/div/div/a");
		if (findTheElement(
				"link=Shop Now")
				.isDisplayed()) {
			rpt.createTest("CC - Home Page - Verify Top Deal_Shop Now",
					"LogoHyperlink Displayed - For Verify Top Deal_Shop Now ");
			rpt.Pass("Top Deal_Shop Now Displayed - For Verify Top Deal_Shop Now");
			rpt.Category("CC_Home Page - Verify Top Deal_Shop Now");
			String path = rpt.CaptureScreen(browser, "ValidMessage");
			rpt.imgPathPass(path);
			click("link=Shop Now");

		} else {
			rpt.createTest("CC - Home Page - Verify Top Deal_Shop Now",
					"Top Deal_Shop Now Page is NOT Displayed - For Verify Top Deal_Shop Now");
			rpt.Fail("Top Deal_Shop Now Page is NOT Displayed - For Verify Top Deal_Shop Now");
			rpt.Category("CC_Home Page - Verify Top Deal_Shop Now");
			String path = rpt.CaptureScreen(browser, "InvalidMessage");
			rpt.imgPathFail(path);
		}

		
//		String ProdName2=getText("id=PageHeading_3074457345618265621");
//		
//		if(ProdName.equals(ProdName2))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		Thread.sleep(2000);
		 click("id=contentImage_1_HeaderStoreLogo_Content");
	}
	
	
	//CC_HP_011 - Learn More
	 public void HP_LearnMore() throws Exception
	 {
		 Thread.sleep(3000);
		 //click("xpath=//img[@src='https://my14.digitalexperience.ibm.com/217849ca-8c55-4fae-922a-9abba9366cf1/dxdam/77/773d2b2d-b900-4a7b-8f8c-d4cfded80b23/pimgpsh_fullsize_distr_less_size.jpg']");
		 if (findTheElement(
					"xpath=//img[@src='https://my14.digitalexperience.ibm.com/217849ca-8c55-4fae-922a-9abba9366cf1/dxdam/77/773d2b2d-b900-4a7b-8f8c-d4cfded80b23/pimgpsh_fullsize_distr_less_size.jpg']")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Learn More",
						"LogoHyperlink Displayed - For Verify Learn More ");
				rpt.Pass("Learn More Displayed - For Verify Learn More");
				rpt.Category("CC_Home Page - Verify Learn More");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//img[@src='https://my14.digitalexperience.ibm.com/217849ca-8c55-4fae-922a-9abba9366cf1/dxdam/77/773d2b2d-b900-4a7b-8f8c-d4cfded80b23/pimgpsh_fullsize_distr_less_size.jpg']");

			} else {
				rpt.createTest("CC - Home Page - Verify Learn More",
						"Learn More Page is NOT Displayed - For Verify Learn More");
				rpt.Fail("Learn More Page is NOT Displayed - For Verify Learn More");
				rpt.Category("CC_Home Page - Verify Learn More");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 Thread.sleep(2000);
		 click("id=contentImage_1_HeaderStoreLogo_Content");
	 }
	//CC-TC 13
	 public void customiseRoom()throws Exception
	 {
		 click("link=CUSTOMIZE THIS ROOM");
		 Thread.sleep(5000);
		 String HomePagetitle=Browser.getTitle();
			System.out.println(HomePagetitle);
			
			if(HomePagetitle.contains("Smart Rooms | Circuit City"))
			{
				//System.out.println("Passed");
				 rpt.createTest("CIRCUIT CITY - Verify Customise Room Navigation", "Customise Room from home page is navigating to its respective page : " +HomePagetitle);
		         rpt.Pass("Customise Room from home page is navigating to its respective page : " +HomePagetitle);
		         rpt.Category("CIRCUIT CITY - Verify Customise Room Navigation");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Failed");
				rpt.createTest("CIRCUIT CITY - Verify Customise Room Navigation", "Customise Room from home page NOT navigating to its respective page");
		         rpt.Fail("Customise Room from home page NOT navigating to its respective page");
		         rpt.Category("CIRCUIT CITY - Verify Customise Room Navigation");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
			Thread.sleep(3000);
			click("id=contentImage_1_HeaderStoreLogo_Content");
	 }
	 //CC-14
	 public void smartRoom()throws Exception
	 {
		 click("link=VIEW ALL SMART ROOMS");
		 Thread.sleep(5000);
		 String HomePagetitle=Browser.getTitle();
			System.out.println(HomePagetitle);
			
			if(HomePagetitle.contains("Smart Rooms | Circuit City"))
			{
				//System.out.println("Passed");
				 rpt.createTest("CIRCUIT CITY - Verify Smart Room Navigation", "Smart Room from home page is navigating to its respective page : " +HomePagetitle);
		         rpt.Pass("Smart Room from home page is navigating to its respective page : " +HomePagetitle);
		         rpt.Category("CIRCUIT CITY - Verify Smart Room Navigation");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				//System.out.println("Failed");
				rpt.createTest("CIRCUIT CITY - Verify Smart Room Navigation", "Smart Room from home page NOT navigating to its respective page");
		         rpt.Fail("Smart Room from home page NOT navigating to its respective page");
		         rpt.Category("CIRCUIT CITY - Verify Smart Room Navigation");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
			Thread.sleep(3000);
			click("id=contentImage_1_HeaderStoreLogo_Content");
	 }
	 //CC-15
	 public void featuredProduct()throws Exception
	 {
		 String product=findTheElement("css=div.carouselWrapper").getText();
		 Thread.sleep(2000);
		 System.out.println(product);
		 if(product!=null)
		 {
			
				 rpt.createTest("CIRCUIT CITY - Verify Featured Product", "Featured Product Section is displayed properly");
		         rpt.Pass("Featured Product Section is displayed properly : " +product);
		         rpt.Category("CIRCUIT CITY - Verify Featured Product");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				
				rpt.createTest("CIRCUIT CITY - Verify Featured Productr", "Featured Product NOT displayed properly");
		         rpt.Fail("Featured Product NOT displayed properly");
		         rpt.Category("CIRCUIT CITY - Verify Featured Product");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
	 }
	 
	 //CC_HP_016 TO CHECK 
	 
	 public void HP_ShopNow_FeaturedProduct() throws Exception
	 {
		 Thread.sleep(5000);
		// click("xpath=/html/body/div[3]/div/div[1]/div[2]/div[1]/div[4]/div/div[2]/div[1]/div/div[1]/div/div/a");
		 
		 
		// String FeaturedProBefore=getText("xpath=//*[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616698676_link_9b']");
		 
		 
		 //click("xpath=//a[@href ='https://qalive.circuitcity.com/ClickInfo?URL=http%3a%2f%2fqalive.circuitcity.com%2fProductDisplay%3ftop_category5%3d%26top_category4%3d%26top_category3%3d%26urlRequestType%3dBase%26productId%3d3074457345616698676%26catalogId%3d3074457345616676668%26top_category2%3d%26categoryId%3d%26errorViewName%3dProductDisplayErrorView%26urlLangId%3d-1%26langId%3d-1%26top_category%3d%26parent_category_rn%3d%26storeId%3d10801&evtype=CpgnClick&mpe_id=715839388&intv_id=715839384&storeId=10801&catalogId=3074457345616676668&langId=-1&expDataType=CatalogEntryId&expDataUniqueID=3074457345616698676&catEntryId=3074457345616698676']");
		 if (findTheElement(
					"xpath=(//a[contains(text(),'Shop Now')])[7]")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify ShopNow_FeaturedProduct",
						"ShopNow FeaturedProduct Displayed - For Verify ShopNow_FeaturedProduct");
				rpt.Pass("ShopNow_FeaturedProductDisplayed - For Verify ShopNow_FeaturedProduct");
				rpt.Category("CC_Home Page - Verify ShopNow_FeaturedProduct");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=(//a[contains(text(),'Shop Now')])[7]");
				//click("xpath=//a[contains(text(),'Shop Now')][8]");

			} else {
				rpt.createTest("CC - Home Page - Verify ShopNow_FeaturedProduct",
						"ShopNow_FeaturedProductPage is NOT Displayed - For Verify ShopNow_FeaturedProduct");
				rpt.Fail("ShopNow_FeaturedProductPage is NOT Displayed - For Verify ShopNow_FeaturedProduct");
				rpt.Category("CC_Home Page - Verify ShopNow_FeaturedProduct");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 
		// String FeaturedProductafter= getText("xpath=/html/body/div[11]/div/div[2]/div[1]/div[2]/div[3]/h1");
		 
		 //Verifying for the Same Product after Navigation
		 
//		 if(FeaturedProBefore.equals(FeaturedProductafter))
//		 {
//			 System.out.println("Working Fine and Passed");
//		 }
//		 else
//		 {
//			 System.out.println("Failed");
//		 }
		 Thread.sleep(3000);
			click("id=contentImage_1_HeaderStoreLogo_Content");
	 }
	 //CC_HP_019 - Discover-Learn More
	 public void HP_Discover_LearnMore() throws Exception
	 {
		 Thread.sleep(6000);
		// String Script = "javascript:document.getElementById('WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345616682663_link_9b').click();";
		 //((JavascriptExecutor)br).executeScript(Script); 
		// WebElement element = driver.findElement("));

		 JavascriptExecutor executor = (JavascriptExecutor)browser;
		 executor.executeScript("window.scrollBy(0,2300)");
		
		 System.out.println("browser:"+browser);
		 WebElement element = browser.findElement(By.xpath("(//div[@class='product-image'])[1]"));
		 Actions action = new Actions(browser);
		  action.moveToElement(element).build().perform();
		  element.click();
		  String BeforeClick = getText("xpath=//div[@class='item-name'][1]");
		  Thread.sleep(2000);
		  //click("xpath=//button[@class='learn-more'][1]");
		  if (findTheElement(
				  "xpath=//button[@class='learn-more'][1]")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Discover Learn More",
						"Discover  Learn More Displayed - For Verify Discover Learn More ");
				rpt.Pass("Discover  Learn More Displayed - For Verify Discover  Learn More ");
				rpt.Category("CC_Home Page - Verify Discover  Learn More ");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//button[@class='learn-more'][1]");

			} else {
				rpt.createTest("CC - Home Page - Verify Discover  Learn More ",
						" Discover Learn More Page is NOT Displayed - For Verify Discover  Learn More ");
				rpt.Fail("Discover  Learn More is NOT Displayed - For Verify Discover  Learn More ");
				rpt.Category("CC_Home Page - Verify Discover  Learn More ");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		  String AfterClick = getText("id=PageHeading_3074457345618265621");
		  
		  if(BeforeClick.equals(AfterClick))
		  {
			  System.out.println("Passed "+BeforeClick+"Same as" +AfterClick);
		  }
		  else
		  {
			  System.out.println("Fail");
		  }
		  }
	 
	//CC_HP_020
	 public void HP_discoverMore() throws Exception
	 {
		// JavascriptExecutor executor = (JavascriptExecutor)browser;
		// executor.executeScript("window.scrollBy(0,2700)");
		 Thread.sleep(30000);
		 //click("xpath=/html/body/div[3]/div/div[1]/div[2]/div[1]/div[7]/div/div/div/div/div/a");
		 
		 if (findTheElement(
				 "link=DISCOVER MORE")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Discover More",
						"Discover More Displayed - For Verify Discover More");
				rpt.Pass("Discover MoreDisplayed - For Verify Discover More");
				rpt.Category("CC_Home Page - Verify Discover More");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("link=DISCOVER MORE");

			} else {
				rpt.createTest("CC - Home Page - Verify Discover More",
						" Discover More Page is NOT Displayed - For Verify Discover More");
				rpt.Fail("Discover More is NOT Displayed - For Verify Discover More");
				rpt.Category("CC_Home Page - Verify Discover More");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 Thread.sleep(2000);
		 click("id=contentImage_1_HeaderStoreLogo_Content");
		 
//		String s= getText("xpath=/html/body/div[2]/div[2]/div[2]/div[4]/div/ul/li[1]/div/div[1]/ul/h3");
//		System.out.println(s);
//		if(s.equals("Product by Category"))
//		{
//			System.out.println("Discover More - Passed");
//		}
//		else
//		{
//			System.out.println("Discover More - Failed");
//		}
	 }
	 //CC 25
	   public void ShopAllTopCategories() throws Exception
	   {
	     Thread.sleep(5000);
	     
	     if (findTheElement(
	       "link=SHOP ALL CATEGORIES").isDisplayed()) {
	      rpt.createTest("CC - Home Page - Verify Shop All Top Categories",
	        "Shop All Top Categories Displayed - For Verify Shop All Top Categories");
	      rpt.Pass("Discover MoreDisplayed - For Verify Discover More");
	      rpt.Category("CC_Home Page - Verify Shop All Top Categories");
	      String path = rpt.CaptureScreen(browser, "ValidMessage");
	      rpt.imgPathPass(path);
	      click("link=SHOP ALL CATEGORIES");

	     } else {
	      rpt.createTest("CC - Home Page - Verify Shop All Top Categories",
	        " Shop All Top Categories buttonis NOT Displayed - For Verify Shop All Top Categories");
	      rpt.Fail("Shop All Top Categories is NOT Displayed - For Verify Shop All Top Categories");
	      rpt.Category("CC_Home Page - Verify Shop All Top Categories");
	      String path = rpt.CaptureScreen(browser, "InvalidMessage");
	      rpt.imgPathPass(path);
	     }
	     Thread.sleep(3000);
			click("id=contentImage_1_HeaderStoreLogo_Content");
	   }
	 
	 //CC-TC 26
	 public void bestSeller() throws Exception
	 {
		 String product=findTheElement("css=div.carouselWrapper").getText();
		 Thread.sleep(2000);
		 System.out.println(product);
		 if(product!=null)
		 {
			
				 rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Best Seller Section is displayed properly");
		         rpt.Pass("Best Seller Section is displayed properly : " +product);
		         rpt.Category("CIRCUIT CITY - Verify Best Seller");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				
				rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Best Seller Section NOT displayed properly");
		         rpt.Fail("Best Seller Section NOT displayed properly");
		         rpt.Category("CIRCUIT CITY - Verify Best Seller");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
	 }
	 //TC 27
	 public void shopNow_FeaturedProduct() throws Exception
	 {
//		 String product=findTheElement("css=div.carouselWrapper").getText();
//		 Thread.sleep(2000);
//		 System.out.println(product);
		 if(findTheElement("xpath=//div[5]/div/div[2]/div/div/div/div/div/a").isDisplayed())
		 {
			 	//click("css=div.button primary");
				 rpt.createTest("CIRCUIT CITY - Home Page", "Shop now from featured product is navigating to respective page");
		         rpt.Pass("Shop now from featured product is navigating to respective page");
		         rpt.Category("CIRCUIT CITY - Home Page");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
		         click("xpath=//div[5]/div/div[2]/div/div/div/div/div/a");
			}
			else
			{
				
				rpt.createTest("CIRCUIT CITY - Home Page", "Shop now from featured product NOT navigating to respective page");
		         rpt.Fail("Shop now from featured product NOT navigating to respective page");
		         rpt.Category("CIRCUIT CITY - Home Page");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
		 Thread.sleep(3000);
			click("id=contentImage_1_HeaderStoreLogo_Content");
	 }
	 
	 //TC-32 
	 public void bannerDisplay()throws Exception
	 { 
		 String product=findTheElement("xpath=//div[@id='footerWrapper']/div/div").getText();
//		 Thread.sleep(2000);
		 System.out.println(product);
		 if(findTheElement("xpath=//div[@id='footerWrapper']/div/div").isDisplayed())
		 {
			 	//click("css=div.button primary");
				 rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Banner is displayed with chat,call and email :" +product);
		         rpt.Pass("Banner is displayed with chat,call and email :"+product);
		         rpt.Category("CIRCUIT CITY - Verify Best Seller");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			}
			else
			{
				
				rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Banner NOT displayed with chat,call and email");
		         rpt.Fail("Banner NOT displayed with chat,call and email");
		         rpt.Category("CIRCUIT CITY - Verify Best Seller");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
		 
	 }
	 //CC_HP_033 - Chat
	 public void HP_Chat() throws Exception
	 {
		 //Thread.sleep(30000);
		// click("xpath=//img[@src='/wcsstore/CircuitCitySAS/images/chat.png']");
		 //Report
		 if (findTheElement(
				 "xpath=//div[@id='footerWrapper']/div/div/span[3]/a/span")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat",
						"Chat Displayed - For Verify Chat");
				rpt.Pass("Chat Displayed - For Verify Chat");
				rpt.Category("CC_Home Page - Verify Chat");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[@id='footerWrapper']/div/div/span[3]/a/span");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat",
						" Chat Page is NOT Displayed - For Verify Chat");
				rpt.Fail("Chat is NOT Displayed - For Verify Chat");
				rpt.Category("CC_Home Page - Verify Chat");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		 String s=getText("id=lc_chat_title");
		// Verifying chat Pop Up display
				 if(s.equals("Please leave us a message!"))
				 {
					 System.out.println("Chat - Passed");
				 }
				 else
				 {
					 System.out.println("Chat - Failed");
				 }
				 
		 Thread.sleep(2000);
		//Submit Chat
		//click("id=lc_chat_offline_name");	
				 if (findTheElement(
						 "id=lc_chat_offline_name")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Chat - User Name",
								"Chat - User Name Displayed - For Verify Chat - User Name");
						rpt.Pass("Chat - User Name Displayed - For Verify Chat - User Name");
						rpt.Category("CC_Home Page - Verify Chat - User Name");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("id=lc_chat_offline_name");

					} else {
						rpt.createTest("CC - Home Page - Verify Chat - User Name",
								" Chat - User Name Page is NOT Displayed - For Verify Chat - User Name");
						rpt.Fail("Chat - User Name is NOT Displayed - For Verify Chat - User Name");
						rpt.Category("CC_Home Page - Verify Chat - User Name");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

		 if (findTheElement(
				 "id=lc_chat_offline_name")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - User Name",
						"Chat - User Name Displayed - For Verify Chat - User Name");
				rpt.Pass("Chat - User Name Displayed - For Verify Chat - User Name");
				rpt.Category("CC_Home Page - Verify Chat - User Name");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=lc_chat_offline_name", "Test User");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - User Name",
						" Chat - User Name Page is NOT Displayed - For Verify Chat - User Name");
				rpt.Fail("Chat - User Name is NOT Displayed - For Verify Chat - User Name");
				rpt.Category("CC_Home Page - Verify Chat - User Name");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		 
		 
		 //click("id=lc_chat_offline_email");
		 if (findTheElement(
				 "id=lc_chat_offline_email")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - eMail",
						"Chat - eMail Displayed - For Verify Chat - eMail");
				rpt.Pass("Chat - eMail Displayed - For Verify Chat - eMail");
				rpt.Category("CC_Home Page - Verify Chat - eMail");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=lc_chat_offline_email");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - eMail",
						" Chat - eMail Page is NOT Displayed - For Verify Chat - eMail");
				rpt.Fail("Chat - eMail is NOT Displayed - For Verify Chat - eMail");
				rpt.Category("CC_Home Page - Verify Chat - eMail");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		 
		 //sendKeys("id=lc_chat_offline_email","kanimozhi.p@rr.com");
		 if (findTheElement(
				 "id=lc_chat_offline_email")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - eMail",
						"Chat - eMail Displayed - For Verify Chat - eMail");
				rpt.Pass("Chat - eMail Displayed - For Verify Chat - eMail");
				rpt.Category("CC_Home Page - Verify Chat - eMail");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=lc_chat_offline_email","user@test.com");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - eMail",
						" Chat - eMail Page is NOT Displayed - For Verify Chat - eMail");
				rpt.Fail("Chat - eMail is NOT Displayed - For Verify Chat - eMail");
				rpt.Category("CC_Home Page - Verify Chat - eMail");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		 
		// click("id=lc_chat_offline_textarea");
		 
		 if (findTheElement(
				 "id=lc_chat_offline_textarea")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - Message",
						"Chat - Message Displayed - For Verify Chat - Message");
				rpt.Pass("Chat - Message Displayed - For Verify Chat - Message");
				rpt.Category("CC_Home Page - Verify Chat - Message");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=lc_chat_offline_textarea");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - Message",
						" Chat - Message Page is NOT Displayed - For Verify Chat - Message");
				rpt.Fail("Chat - Message is NOT Displayed - For Verify Chat - Message");
				rpt.Category("CC_Home Page - Verify Chat - Message");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
//
//		// sendKeys("id=lc_chat_offline_textarea","Testing");
//		 
		 if (findTheElement(
				 "id=lc_chat_offline_textarea")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - Message",
						"Chat - Message Displayed - For Verify Chat - Message");
				rpt.Pass("Chat - Message Displayed - For Verify Chat - Message");
				rpt.Category("CC_Home Page - Verify Chat - Message");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				sendKeys("id=lc_chat_offline_textarea","Testing");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - Message",
						" Chat - Message Page is NOT Displayed - For Verify Chat - Message");
				rpt.Fail("Chat - Message is NOT Displayed - For Verify Chat - Message");
				rpt.Category("CC_Home Page - Verify Chat - Message");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 
		// click("id=lc_offline_submit");
		 if (findTheElement(
				 "id=lc_offline_submit")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Chat - Submission",
						"Chat - Submission Displayed - For Verify Chat - Submission");
				rpt.Pass("Chat - Submission Displayed - For Verify Chat - Submission");
				rpt.Category("CC_Home Page - Verify Chat - Submission");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("id=lc_offline_submit");

			} else {
				rpt.createTest("CC - Home Page - Verify Chat - Submission",
						" Chat - Submission Page is NOT Displayed - For Verify Chat - Submission");
				rpt.Fail("Chat - Submission is NOT Displayed - For Verify Chat - Submission");
				rpt.Category("CC_Home Page - Verify Chat - Submission");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
		 Thread.sleep(4000);
		 click("id=lc_minimize");
		 //click("id=close");
		// click("xpath=//div[@id='close']/i");
		
		 //Verifying Successfull Submissions
		 String MessageAfterSubmission=getText("id=lc_chat_title");

		 
		 //Verifying Chat Functionality
		 if(MessageAfterSubmission.equals("Thank you!"))
		 {
			 System.out.println("Chat - Passed");
		 }
		 else
		 {
			 System.out.println("Chat - Failed");
		 }
		 
		
	 }
	 
	 //CC_HP_034 - Home page - Call (Captcha is present in this screen - N\A for Automate)
	 public void HP_Call() throws Exception
	 {
		 Thread.sleep(30000);
		//click("xpath=//img[@src='/wcsstore/CircuitCitySAS/images/call.png']");
		 
		 if (findTheElement(
				 "xpath=//img[@src='/wcsstore/CircuitCitySAS/images/call.png']")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Call",
						"Home Page_Call Displayed - For Verify Home Page_Call");
				rpt.Pass("Home Page_Call Displayed - For Verify Home Page_Call");
				rpt.Category("CC_Home Page - Verify Home Page_Call");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//img[@src='/wcsstore/CircuitCitySAS/images/call.png']");
			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Call",
						" Home Page_Call Page is NOT Displayed - For Verify Home Page_Call");
				rpt.Fail("Home Page_Call is NOT Displayed - For Verify Home Page_Call");
				rpt.Category("CC_Home Page - Verify Home Page_Call");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		 String PageTitle=Browser.getTitle();
		// Verifying Contact Us Page display
				 if(PageTitle.equals("Contact Us"))
				 {
					 System.out.println("Call - Passed");
				 }
				 else
				 {
					 System.out.println("Call - Failed");
				 }
				 
		//Contact Us Page submitting
   /*		click("id=subject");
		sendKeys("id=subject","Test");
		click("id=name");
		sendKeys("id=name","Test");
		
		click("id=email");
		sendKeys("id=email","Test");
		
		click("id=orderId");
		sendKeys("id=orderId","Test");
		
		click("id=message");
		sendKeys("id=message","Test");
		*/
	             }

	//CC_HP_035 - Home page - Email (Captcha is present in this screen - N\A for Automate)
		 public void HP_Email() throws Exception
		 {
			 //Thread.sleep(30000);
			 //click("xpath=//img[@src='/wcsstore/CircuitCitySAS/images/latter.png']");
			 
			 if (findTheElement(
					 "xpath=//div[@id='footerWrapper']/div/div/span[3]/a[3]/span")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Email",
							"Home Page_Email Displayed - For Verify Home Page_Email");
					rpt.Pass("Home Page_Email Displayed - For Verify Home Page_Email");
					rpt.Category("CC_Home Page - Verify Home Page_Email");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[@id='footerWrapper']/div/div/span[3]/a[3]/span");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Email",
							" Home Page_Email Page is NOT Displayed - For Verify Home Page_Email");
					rpt.Fail("Home Page_Email is NOT Displayed - For Verify Home Page_Email");
					rpt.Category("CC_Home Page - Verify Home Page_Email");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 String PageTitle=Browser.getTitle();
			// Verifying Contact Us Page display
					 if(PageTitle.equals("Contact Us"))
					 {
						 System.out.println("Email - Passed");
					 }
					 else
					 {
						 System.out.println("Email - Failed");
					 }
					 Thread.sleep(2000);
					 browser.navigate().back();
	 
		 }
		 
		//CC_HP_036 - Home page - Price Match
		 public void HP_PriceMatchguarantee() throws Exception
		 {
			// Thread.sleep(30000);
			 //click("xpath=//a[@href='/en/shopPriceMatchGuarantee']");
			 if (findTheElement(
					 "link=DETAILS")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Price Match",
							"Home Page_Price Match Displayed - For Verify Home Page_Price Match");
					rpt.Pass("Home Page_Price Match Displayed - For Verify Home Page_Price Match");
					rpt.Category("CC_Home Page - Verify Home Page_Price Match");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("link=DETAILS");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Price Match",
							" Home Page_Price Match Page is NOT Displayed - For Verify Home Page_Price Match");
					rpt.Fail("Home Page_Price Match is NOT Displayed - For Verify Home Page_Price Match");
					rpt.Category("CC_Home Page - Verify Home Page_Price Match");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
			 Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");

			 String PageTitle=Browser.getTitle();
			// Verifying Contact Us Page display
					 if(PageTitle.equals("Contact Us"))
					 {
						 System.out.println("Email - Passed");
					 }
					 else
					 {
						 System.out.println("Email - Failed");
					 } 
					 String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow); 
					     }
					  }   
		 }
	 
		//CC_HP_037 - Home page - Free Shipping
		 public void HP_FreeShipping() throws Exception
		 {
			 Thread.sleep(30000);
			 //click("xpath=//a[@href='/en/shopPriceMatchGuarantee']");
			 if (findTheElement(
					 "xpath=(//a[contains(text(),'DETAILS')])[2]")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Free Shipping",
							"Home Page_Free Shipping Displayed - For Verify Home Page_Free Shipping");
					rpt.Pass("Home Page_Free Shipping Displayed - For Verify Home Page_Free Shipping");
					rpt.Category("CC_Home Page - Verify Home Page_Free Shipping");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=(//a[contains(text(),'DETAILS')])[2]");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Free Shipping",
							" Home Page_Free Shipping Page is NOT Displayed - For Verify Home Page_Free Shipping");
					rpt.Fail("Home Page_Free Shipping is NOT Displayed - For Verify Home Page_Free Shipping");
					rpt.Category("CC_Home Page - Verify Home Page_Free Shipping");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
			 Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");
			 String PageTitle=Browser.getTitle();
			// Verifying Contact Us Page display
					 if(PageTitle.equals("Contact Us"))
					 {
						 System.out.println("Email - Passed");
					 }
					 else
					 {
						 System.out.println("Email - Failed");
					 } 
					 String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow); 
					     }
					  }   
		 }
		 
		//CC_HP_038 - Home page - schedule service 
		 public void HP_ScheduleService() throws Exception
		 {
			 Thread.sleep(30000);
			// click("xpath=//a[@href='/en/shop/Installations']");
			 if (findTheElement(
					 "link=SCHEDULE NOW")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Schedule Service",
							"Home Page_Schedule Service Displayed - For Verify Home Page_Schedule Service");
					rpt.Pass("Home Page_Schedule Service Displayed - For Verify Home Page_Schedule Service");
					rpt.Category("CC_Home Page - Verify Home Page_Schedule Service");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("link=SCHEDULE NOW");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Schedule Service",
							" Home Page_Schedule Service Page is NOT Displayed - For Verify Home Page_Schedule Service");
					rpt.Fail("Home Page_Schedule Service is NOT Displayed - For Verify Home Page_Schedule Service");
					rpt.Category("CC_Home Page - Verify Home Page_Schedule Service");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
			 Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");

			 String PageTitle=Browser.getTitle();
			// Verifying Contact Us Page display
					 if(PageTitle.equals("Contact Us"))
					 {
						 System.out.println("Email - Passed");
					 }
					 else
					 {
						 System.out.println("Email - Failed");
					 } 
		 }
	 
	   //cc_HP_39 - subscribe
		 
		 public void HP_Subscribe() throws Exception
		 {
			 Thread.sleep(20000);
			 click("id=subscribeemail");
			 //sendKeys("id=subscribeemail","Test@testmail.com");
			 
			 if (findTheElement(
					 "id=subscribeemail")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Subscribe_Email id ",
							"Home Page_Subscribe_Email id  Displayed - For Verify Home Page_Subscribe_Email id ");
					rpt.Pass("Home Page_Subscribe_Email id  Displayed - For Verify Home Page_Subscribe_Email id ");
					rpt.Category("CC_Home Page - Verify Home Page_Subscribe_Email id ");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					sendKeys("id=subscribeemail","Test@testmail.com");
					

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Subscribe_Email id ",
							" Home Page_Subscribe_Email id  Page is NOT Displayed - For Verify Home Page_Subscribe_Email id ");
					rpt.Fail("Home Page_Subscribe_Email id  is NOT Displayed - For Verify Home Page_Subscribe_Email id ");
					rpt.Category("CC_Home Page - Verify Home Page_Subscribe_Email id ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 //click("xpath=//input[@value='SUBSCRIBE']");
			 if (findTheElement(
					 "xpath=//div[@id='emailsubscribe']/input[2]")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Subcribe functionality Verification",
							"Home Page_Subcribe functionality Verification Displayed - For Verify Home Page_Subcribe functionality Verification");
					rpt.Pass("Home Page_Subcribe functionality Verification Displayed - For Verify Home Page_Subcribe functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Subcribe functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[@id='emailsubscribe']/input[2]");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Subcribe functionality Verification",
							" Home Page_Subcribe functionality Verification Page is NOT Displayed - For Verify Home Page_Subcribe functionality Verification");
					rpt.Fail("Home Page_Subcribe functionality Verification is NOT Displayed - For Verify Home Page_Subcribe functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Subcribe functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 Thread.sleep(2000);
			 String SubsText=getText("xpath=//*[@id='subscribetext']");
			 System.out.println(SubsText);
			 
			 if(SubsText.equals("Thank you for signing up."))
			 {
				 System.out.println("Subscribe done Successfully & Passed");
			 }
			 else
			 {
				 System.out.println("Subscribe not Done - Failed");
			 }
		 }
		 //TC-41
		 public void connectWithUs()throws Exception
		 {
			 String product=findTheElement("css=div.connect_us").getText();
//			 Thread.sleep(2000);
			 System.out.println(product);
			 if(findTheElement("css=div.connect_us").isDisplayed())
			 {
				 	//click("css=div.button primary");
					 rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Connect with us in footer section is displayed");
			         rpt.Pass("Connect with us in footer section is displayed");
			         rpt.Category("CIRCUIT CITY - Verify Best Seller");
			         String path = rpt.CaptureScreen(browser, "ValidMessage");
			         rpt.imgPathPass(path);
				}
				else
				{
					
					rpt.createTest("CIRCUIT CITY - Verify Best Seller", "Connect with us in footer section NOT displayed");
			         rpt.Fail("Connect with us in footer section NOT displayed");
			         rpt.Category("CIRCUIT CITY - Verify Best Seller");
			         String path = rpt.CaptureScreen(browser, "InvalidMessage");
			         rpt.imgPathFail(path);
				}
		 }
		 //CC_HP_042 Sign in or create account 
		 
		 public void HP_SigninOrCreateAccount() throws Exception
		 {
			// click("xpath=//a[@href='/AjaxLogonForm?catalogId=3074457345616676668&langId=-1&storeId=10801']");
			 
			if (findTheElement(
					 
					 "xpath=//div[3]/div/div/ul/li/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Sign In or Create Account functionality Verification",
							"Home Page_Footer - Sign In or Create Account functionality Verification Displayed - For Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					rpt.Pass("Home Page_Footer - Sign In or Create Account functionality Verification Displayed - For Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div/ul/li/a");

				} 
						else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Sign In or Create Account functionality Verification",
							" Home Page_Footer - Sign In or Create Account functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					rpt.Fail("Home Page_Footer - Sign In or Create Account functionality Verification is NOT Displayed - For Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Sign In or Create Accountfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 
			 //String PageTitle=getTitle();
			 
//			if(PageTitle.equals("SignIn"))
//			{
//			 System.out.println("Signin Or Create Account Working Properly");
//			}
//			else
//			{
//				System.out.println("Signin Or Create Account Working Properly. Case Failed");
//			}
			Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");
		 }
		 
 //CC_HP_045 Wish List Footer
		 
		 public void HP_wishlistFooter() throws Exception
		 {
			 Thread.sleep(2000);
			// click("xpath=//a[@href='/WishListDisplayView?listId=.&catalogId=3074457345616676668&langId=-1&storeId=10801']");
			 
			 if (findTheElement(
					 "xpath=//div[3]/div/div/ul/li[2]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Wishlistfunctionality Verification",
							"Home Page_Footer - Wishlistfunctionality Verification Displayed - For Verify Home Page_Footer - Wishlistfunctionality Verification");
					rpt.Pass("Home Page_Footer - Wishlistfunctionality Verification Displayed - For Verify Home Page_Footer - Wishlistfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Wishlistfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div/ul/li[2]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Wishlistfunctionality Verification",
							" Home Page_Footer - Wishlistfunctionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Wishlistfunctionality Verification");
					rpt.Fail("Home Page_Footer - Wishlistfunctionality Verification is NOT Displayed - For Verify Home Page_Footer - Wishlistfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Wishlistfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 
//			 String PageTitle=getTitle();
//			 
//			if(PageTitle.equals("SignIn"))
//			{
//			 System.out.println("Footer Wish list is navigating to corresponding Page");
//			}
//			else
//			{
//				System.out.println("Footer Wish list is not navigating to corresponding Page,Case Failed");
//			}
			Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");
		 }
		 
 //CC_HP_048 User Rebates
		 
		 public void HP_RebatesFooter() throws Exception 
		 {
			 Thread.sleep(2000);
			 //click("xpath=//a[@href='/rebateUserTrackStatusView?catalogId=3074457345616676668&langId=-1&storeId=10801']");
			 if (findTheElement(
					 "xpath=//div[3]/div/div/ul/li[3]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Rebates functionality Verification",
							"Home Page_Footer - Rebates functionality Verification Displayed - For Verify Home Page_Footer - Rebates functionality Verification");
					rpt.Pass("Home Page_Footer - Rebates functionality Verification Displayed - For Verify Home Page_Footer - Rebates functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Rebates functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div/ul/li[3]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Rebates functionality Verification",
							" Home Page_Footer - Rebates functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Rebates functionality Verification");
					rpt.Fail("Home Page_Footer - Rebates functionality Verification is NOT Displayed - For Verify Home Page_Footer - Rebates functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Rebates functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 
//			 String PageTitle=getTitle();
//			 
//			if(PageTitle.equals("User Rebate"))
//			{
//			 System.out.println("Footer-Rebate is navigating to corresponding Page");
//			}
//			else
//			{
//				System.out.println("Footer-Rebate is not navigating to corresponding Page. Case Failed");
//			}
			Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");
		 }
		 
//CC_HP_049 Order Status - footer
		 
		 public void HP_OrderStatusFooter() throws Exception 
		 {
			 Thread.sleep(2000);
			 //click("xpath=//a[@href='/TrackOrderSearch?catalogId=3074457345616676668&langId=-1&storeId=10801']");
			 if (findTheElement(
					 "xpath=//div[3]/div/div[2]/ul/li/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Order Status functionality Verification",
							"Home Page_Footer - Order Status functionality Verification Displayed - For Verify Home Page_Footer - Order Status functionality Verification");
					rpt.Pass("Home Page_Footer - Order Status functionality Verification Displayed - For Verify Home Page_Footer - Order Status functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Order Status functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div[2]/ul/li/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Order Status functionality Verification",
							" Home Page_Footer - Order Status functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Order Status functionality Verification");
					rpt.Fail("Home Page_Footer - Order Status functionality Verification is NOT Displayed - For Verify Home Page_Footer - Order Status functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Order Status functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 Thread.sleep(4000);
			 
//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();
			 
			if(NewWindowTitle.equals("Track Order"))
			{
			 System.out.println("Order Status Footer link is navigating to corresponding Page");
			}
			else
			{
				System.out.println("Order Status Footer link is not navigating to corresponding Page. Case Failed");
			}
//			Thread.sleep(2000);
//			 click("id=contentImage_1_HeaderStoreLogo_Content");
			String parentWindow = browser.getWindowHandle();
			  Set<String> handles =  browser.getWindowHandles();
			  for(String windowHandle  : handles)
			  {
			      if(!windowHandle.equals(parentWindow))
			     {
			       browser.switchTo().window(windowHandle);
			       String childWindowTitle = getTitle();
			       System.out.print(childWindowTitle);
			       browser.close(); 
			       browser.switchTo().window(parentWindow); }}
		 }
	 
		 
//CC_HP_050 Order History - footer
		 
		 public void HP_OrderHistoryFooter() throws Exception 
		 {
			 Thread.sleep(4000);
			 //click("xpath=//a[@href='/en/shop/TrackOrderStatus?showOrderHeader=true&catalogId=3074457345616676668&langId=-1&storeId=10801&orderStatusStyle=strong']");
			 
			 if (findTheElement(
					 "xpath=//div[3]/div/div[2]/ul/li[2]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Order History functionality Verification",
							"Home Page_Footer - Order History functionality Verification Displayed - For Verify Home Page_Footer - Order History functionality Verification");
					rpt.Pass("Home Page_Footer - Order History functionality Verification Displayed - For Verify Home Page_Footer - Order History functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Order History functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div[2]/ul/li[2]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Order History functionality Verification",
							" Home Page_Footer - Order History functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Order History functionality Verification");
					rpt.Fail("Home Page_Footer - Order History functionality Verification is NOT Displayed - For Verify Home Page_Footer - Order History functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Order History functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 
			 Thread.sleep(4000);
			 
//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();
			 
			if(NewWindowTitle.equals("Sign In"))
			{
			 System.out.println("Footer-Order History Link is navigating to corresponding Page");
			}
			else
			{
				System.out.println("Footer-Order History Link is not navigating to corresponding Page. Case Failed");
			}
//			Thread.sleep(2000);
//			 click("id=contentImage_1_HeaderStoreLogo_Content");
			String parentWindow = browser.getWindowHandle();
			  Set<String> handles =  browser.getWindowHandles();
			  for(String windowHandle  : handles)
			  {
			      if(!windowHandle.equals(parentWindow))
			     {
			       browser.switchTo().window(windowHandle);
			       String childWindowTitle = getTitle();
			       System.out.print(childWindowTitle);
			       browser.close(); 
			       browser.switchTo().window(parentWindow); }}
		 
		 }
		 
//CC_HP_051 Shipping and Delivery - footer
		 
		 public void HP_ShippingAndDeliveryFooter() throws Exception 
		 {
			 Thread.sleep(2000);
			 //click("xpath=//a[@href='/en/shop/shippingdelivery']");
			 if (findTheElement(
					 "xpath=//div[3]/div/div[2]/ul/li[3]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification",
							"Home Page_Footer - Shipping and Deliveryfunctionality Verification Displayed - For Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					rpt.Pass("Home Page_Footer - Shipping and Deliveryfunctionality Verification Displayed - For Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					 click("xpath=//div[3]/div/div[2]/ul/li[3]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification",
							" Home Page_Footer - Shipping and Deliveryfunctionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					rpt.Fail("Home Page_Footer - Shipping and Deliveryfunctionality Verification is NOT Displayed - For Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Shipping and Deliveryfunctionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 Thread.sleep(4000);
			 
//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();
				
			if(NewWindowTitle.equals("Shipping & Delivery"))
			{
			 System.out.println("Footer-Shipoping and Delivery Link is navigating to corresponding Page");
			}
			else
			{
				System.out.println("Footer-Shipoping and Delivery Link is not navigating to corresponding Page. Case Failed");
			}
//			Thread.sleep(2000);
//			 click("id=contentImage_1_HeaderStoreLogo_Content");
			String parentWindow = browser.getWindowHandle();
			  Set<String> handles =  browser.getWindowHandles();
			  for(String windowHandle  : handles)
			  {
			      if(!windowHandle.equals(parentWindow))
			     {
			       browser.switchTo().window(windowHandle);
			       String childWindowTitle = getTitle();
			       System.out.print(childWindowTitle);
			       browser.close(); 
			       browser.switchTo().window(parentWindow);
			       }
			  }
		 }
	 
	// CC_HP_052 Return and Exchange - footer

	public void HP_ReturnAndExchange() throws Exception {
		Thread.sleep(2000);

		//click("xpath=//a[@href='/en/shop/return-policy']");
		if (findTheElement(
				 "xpath=//div[3]/div/div[2]/ul/li[4]/a")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Return and Exchange functionality Verification",
						"Home Page_Footer - Return and Exchange functionality Verification Displayed - For Verify Home Page_Footer - Return and Exchange functionality Verification");
				rpt.Pass("Home Page_Footer - Return and Exchange functionality Verification Displayed - For Verify Home Page_Footer - Return and Exchange functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Return and Exchange functionality Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[3]/div/div[2]/ul/li[4]/a");
			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Return and Exchange functionality Verification",
						" Home Page_Footer - Return and Exchange functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Return and Exchange functionality Verification");
				rpt.Fail("Home Page_Footer - Return and Exchange functionality Verification is NOT Displayed - For Verify Home Page_Footer - Return and Exchange functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Return and Exchange functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		Thread.sleep(2000);

//		java.util.Set<String> handles = browser.getWindowHandles();
//		System.out.println(handles);
//
//		for (String handle1 : browser.getWindowHandles()) {
//
//			System.out.println(handle1);
//
//			browser.switchTo().window(handle1);
//
//		}

		System.out.println(browser.getTitle());

		String NewWindowTitle = Browser.getTitle();

		if (NewWindowTitle.equals("Return Policy for CircuitCityB2C")) {
			System.out
					.println("Footer-Return and Exchange Link is navigating to corresponding Page");
		} else {
			System.out
					.println("Footer-Return and Exchange Link is not navigating to corresponding Page. Case Failed");
		}
		Thread.sleep(2000);
		// click("id=contentImage_1_HeaderStoreLogo_Content");
		 String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		       String childWindowTitle = getTitle();
		       System.out.print(childWindowTitle);
		       browser.close(); 
		       browser.switchTo().window(parentWindow);
		       }
		  }
	}
	
	//CC_HP_053 - Return an Item Footer
	public void HP_ReturnAnItemFooter() throws Exception {
		Thread.sleep(2000);

		//click("xpath=//a[@href='/TrackOrderStatus?catalogId=3074457345616676668&langId=-1&storeId=10801&orderStatusStyle=strong']");
		if (findTheElement(
				 "xpath=//div[3]/div/div[2]/ul/li[5]/a")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Return An Item functionality Verification",
						"Home Page_Footer - Return An Item functionality Verification Displayed - For Verify Home Page_Footer - Return An Item functionality Verification");
				rpt.Pass("Home Page_Footer - Return An Item functionality Verification Displayed - For Verify Home Page_Footer - Return An Item functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Return An Item functionality Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[3]/div/div[2]/ul/li[5]/a");

			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Return An Item functionality Verification",
						" Home Page_Footer - Return An Item functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Return An Item functionality Verification");
				rpt.Fail("Home Page_Footer - Return An Item functionality Verification is NOT Displayed - For Verify Home Page_Footer - Return An Item functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Return An Item functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		Thread.sleep(2000);

//		java.util.Set<String> handles = browser.getWindowHandles();
//		System.out.println(handles);
//
//		for (String handle1 : browser.getWindowHandles()) {
//
//			System.out.println(handle1);
//
//			browser.switchTo().window(handle1);
//
//		}

		System.out.println(browser.getTitle());

		String NewWindowTitle = Browser.getTitle();

		if (NewWindowTitle.equals("Sign In"))
		{
			System.out
					.println("Footer-Return an Item Link is navigating to corresponding Page");
		} else {
			System.out
					.println("Footer-Return an ItemLink is not navigating to corresponding Page. Case Failed");
		}
		Thread.sleep(2000);
		 //click("id=contentImage_1_HeaderStoreLogo_Content");
		String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		       String childWindowTitle = getTitle();
		       System.out.print(childWindowTitle);
		       browser.close(); 
		       browser.switchTo().window(parentWindow);
		       }
		  }
	}
	
	//CC_HP_053 - Return an Item Footer
	public void HP_ContactUsFooter() throws Exception {
		Thread.sleep(3000);

		//click("xpath=//a[@href='/en/shop/contact-us']");
		
		if (findTheElement(
				 "xpath=//div[3]/div/div[2]/ul/li[6]/a")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Contact Us functionality Verification",
						"Home Page_Footer - Contact Us functionality Verification Displayed - For Verify Home Page_Footer - Contact Us functionality Verification");
				rpt.Pass("Home Page_Footer - Contact Us functionality Verification Displayed - For Verify Home Page_Footer - Contact Us functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Contact Us functionality Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[3]/div/div[2]/ul/li[6]/a");

			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Contact Us functionality Verification",
						" Home Page_Footer - Contact Us functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Contact Us functionality Verification");
				rpt.Fail("Home Page_Footer - Contact Us functionality Verification is NOT Displayed - For Verify Home Page_Footer - Contact Us functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Contact Us functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		Thread.sleep(3000);

//		java.util.Set<String> handles = browser.getWindowHandles();
//		System.out.println(handles);
//
//		for (String handle1 : browser.getWindowHandles()) {
//
//			System.out.println(handle1);
//
//			browser.switchTo().window(handle1);
//
//		}

		System.out.println(browser.getTitle());

		String NewWindowTitle = Browser.getTitle();

		if (NewWindowTitle.equals("Contact Us"))
		{
			System.out
					.println("Footer-Contact Us Link is navigating to corresponding Page");
		} else {
			System.out
					.println("Footer-Contact Us Link is not navigating to corresponding Page. Case Failed");
		}
		Thread.sleep(2000);
		// click("id=contentImage_1_HeaderStoreLogo_Content");
		String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		       String childWindowTitle = getTitle();
		       System.out.print(childWindowTitle);
		       browser.close(); 
		       browser.switchTo().window(parentWindow);
		       }
		  }

	}
	
	//CC_HP_054 - Help Footer
	public void HP_Help() throws Exception {
		Thread.sleep(2000);

		//click("xpath=//a[@href='/en/shop/help']");
		if (findTheElement(
				 "xpath=//div[3]/div/div[2]/ul/li[7]/a")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Help functionality Verification",
						"Home Page_Footer - Help functionality Verification Displayed - For Verify Home Page_Footer - Help functionality Verification");
				rpt.Pass("Home Page_Footer - Help functionality Verification Displayed - For Verify Home Page_Footer - Help functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Help functionality Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[3]/div/div[2]/ul/li[7]/a");

			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Help functionality Verification",
						" Home Page_Footer - Help functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Help functionality Verification");
				rpt.Fail("Home Page_Footer - Help functionality Verification is NOT Displayed - For Verify Home Page_Footer - Help functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Help functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		Thread.sleep(2000);

//		java.util.Set<String> handles = browser.getWindowHandles();
//		System.out.println(handles);
//
//		for (String handle1 : browser.getWindowHandles()) {
//
//			System.out.println(handle1);
//
//			browser.switchTo().window(handle1);
//
//		}

		System.out.println(browser.getTitle());

		String NewWindowTitle = Browser.getTitle();

		if (NewWindowTitle.equals("Help at CircuitCityB2C"))
		{
			System.out
					.println("Footer-Help Link is navigating to corresponding Page");
		} else {
			System.out
					.println("Footer-Help is not navigating to corresponding Page. Case Failed");
		}
		Thread.sleep(2000);
		// click("id=contentImage_1_HeaderStoreLogo_Content");
		String parentWindow = browser.getWindowHandle();
		  Set<String> handles =  browser.getWindowHandles();
		  for(String windowHandle  : handles)
		  {
		      if(!windowHandle.equals(parentWindow))
		     {
		       browser.switchTo().window(windowHandle);
		       String childWindowTitle = getTitle();
		       System.out.print(childWindowTitle);
		       browser.close(); 
		       browser.switchTo().window(parentWindow);
		       }
		  }

	}
	//CC_HP_055 - Customer services
	public void HP_CustomerServicesFooter() throws Exception {
		Thread.sleep(2000);

		//click("xpath=//a[@href='/en/shop/contact-us']");
		if (findTheElement(
				 "xpath=//div[3]/div/div[3]/ul/li/a")
					.isDisplayed()) {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Customer Services functionality Verification",
						"Home Page_Footer - Customer Services functionality Verification Displayed - For Verify Home Page_Footer - Customer Services functionality Verification");
				rpt.Pass("Home Page_Footer - Customer Services functionality Verification Displayed - For Verify Home Page_Footer - Customer Services functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Customer Services functionality Verification");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				click("xpath=//div[3]/div/div[3]/ul/li/a");

			} else {
				rpt.createTest("CC - Home Page - Verify Home Page_Footer - Customer Services functionality Verification",
						" Home Page_Footer - Customer Services functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Customer Services functionality Verification");
				rpt.Fail("Home Page_Footer - Customer Services functionality Verification is NOT Displayed - For Verify Home Page_Footer - Customer Services functionality Verification");
				rpt.Category("CC_Home Page - Verify Home Page_Footer - Customer Services functionality Verification");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}

		Thread.sleep(2000);

//		java.util.Set<String> handles = browser.getWindowHandles();
//		System.out.println(handles);
//
//		for (String handle1 : browser.getWindowHandles()) {
//
//			System.out.println(handle1);
//
//			browser.switchTo().window(handle1);
//
//		}

		System.out.println(browser.getTitle());

		String NewWindowTitle = Browser.getTitle();

		if (NewWindowTitle.equals("Contact Us"))
		{
			System.out
					.println("Footer-Customer Services Link is navigating to corresponding Page");
		} else {
			System.out
					.println("Footer-Customer Services is not navigating to corresponding Page. Case Failed");
		}
		Thread.sleep(2000);
		 click("id=contentImage_1_HeaderStoreLogo_Content");

	}
	 
	//CC_HP_056 - Protection Plan
		public void HP_ProtectionPlanFooter() throws Exception {
			Thread.sleep(2000);

			//click("xpath=//a[@href='/en/shop/protectionplans']");
			if (findTheElement(
					 "xpath=//div[3]/div/div[3]/ul/li[2]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Protection Plan functionality Verification",
							"Home Page_Footer - Protection Plan functionality Verification Displayed - For Verify Home Page_Footer - Protection Plan functionality Verification");
					rpt.Pass("Home Page_Footer - Protection Plan functionality Verification Displayed - For Verify Home Page_Footer - Protection Plan functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Protection Plan functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div[3]/ul/li[2]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Protection Plan functionality Verification",
							" Home Page_Footer - Protection Plan functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Protection Plan functionality Verification");
					rpt.Fail("Home Page_Footer - Protection Plan functionality Verification is NOT Displayed - For Verify Home Page_Footer - Protection Plan functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Protection Plan functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			Thread.sleep(2000);

//			java.util.Set<String> handles = browser.getWindowHandles();
//			System.out.println(handles);
//
//			for (String handle1 : browser.getWindowHandles()) {
//
//				System.out.println(handle1);
//
//				browser.switchTo().window(handle1);
//
//			}

			System.out.println(browser.getTitle());

			String NewWindowTitle = Browser.getTitle();

			if (NewWindowTitle.equals("Protection Plans"))
			{
				System.out
						.println("Footer-Protection Plan Link is navigating to corresponding Page");
			} else {
				System.out
						.println("Footer-Protection Plan link is not navigating to corresponding Page. Case Failed");
			}
			Thread.sleep(2000);
			 //click("id=contentImage_1_HeaderStoreLogo_Content");
			String parentWindow = browser.getWindowHandle();
			  Set<String> handles =  browser.getWindowHandles();
			  for(String windowHandle  : handles)
			  {
			      if(!windowHandle.equals(parentWindow))
			     {
			       browser.switchTo().window(windowHandle);
			       String childWindowTitle = getTitle();
			       System.out.print(childWindowTitle);
			       browser.close(); 
			       browser.switchTo().window(parentWindow);
			       }
			  }

		}
		//CC_HP_057 - Trade In Program
				public void HP_TradeInProgramFooter() throws Exception {
					Thread.sleep(2000);

					//click("xpath=//a[@href='/en/shop/tradeinprogram']");
					if (findTheElement(
							 "xpath=//div[3]/div/div[3]/ul/li[3]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Trade In Program functionality Verification",
									"Home Page_Footer - Trade In Program functionality Verification Displayed - For Verify Home Page_Footer - Trade In Program functionality Verification");
							rpt.Pass("Home Page_Footer - Trade In Program functionality Verification Displayed - For Verify Home Page_Footer - Trade In Program functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Trade In Program functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[3]/ul/li[3]/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Trade In Program functionality Verification",
									" Home Page_Footer - Trade In Program functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Trade In Program functionality Verification");
							rpt.Fail("Home Page_Footer - Trade In Program functionality Verification is NOT Displayed - For Verify Home Page_Footer - Trade In Program functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Trade In Program functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}

					Thread.sleep(2000);

//					java.util.Set<String> handles = browser.getWindowHandles();
//					System.out.println(handles);
//
//					for (String handle1 : browser.getWindowHandles()) {
//
//						System.out.println(handle1);
//
//						browser.switchTo().window(handle1);
//
//					}

					System.out.println(browser.getTitle());

					String NewWindowTitle = Browser.getTitle();

					if (NewWindowTitle.equals("tradeinprogram"))
					{
						System.out
								.println("Footer-Trade-In Program Link is navigating to corresponding Page");
					} else {
						System.out
								.println("Footer-Trade-In Program Link is not navigating to corresponding Page. Case Failed");
					}
					Thread.sleep(2000);
					// click("id=contentImage_1_HeaderStoreLogo_Content");
					String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow);
					       }
					  }

				}
				
				//CC_HP_058 - Product Recalls
				public void HP_ProductRecallsFooter() throws Exception {
					Thread.sleep(2000);

					//click("xpath=//a[@href='/en/shop/productrecalls']");
					if (findTheElement(
							 "xpath=//div[3]/div/div[3]/ul/li[4]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Product Recalls functionality Verification",
									"Home Page_Footer - Product Recalls functionality Verification Displayed - For Verify Home Page_Footer - Product Recalls functionality Verification");
							rpt.Pass("Home Page_Footer - Product Recalls functionality Verification Displayed - For Verify Home Page_Footer - Product Recalls functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Product Recalls functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[3]/ul/li[4]/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Product Recalls functionality Verification",
									" Home Page_Footer - Product Recalls functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Product Recalls functionality Verification");
							rpt.Fail("Home Page_Footer - Product Recalls functionality Verification is NOT Displayed - For Verify Home Page_Footer - Product Recalls functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Product Recalls functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}

					Thread.sleep(2000);

//					java.util.Set<String> handles = browser.getWindowHandles();
//					System.out.println(handles);
//
//					for (String handle1 : browser.getWindowHandles()) {
//
//						System.out.println(handle1);
//
//						browser.switchTo().window(handle1);
//
//					}

					System.out.println(browser.getTitle());

					String NewWindowTitle = Browser.getTitle();

					if (NewWindowTitle.equals("Product Recalls"))
					{
						System.out
								.println("Footer-Product Recalls Link is navigating to corresponding Page");
					} else {
						System.out
								.println("Footer-Product Recalls Link is not navigating to corresponding Page. Case Failed");
					}
					Thread.sleep(2000);
					// click("id=contentImage_1_HeaderStoreLogo_Content");
					String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow);
					       }
					  }

				}
				
				//CC_HP_059 - Privacy and Security
				public void HP_PrivacyAndSecurityFooter() throws Exception {
					Thread.sleep(2000);

					//click("xpath=//a[@href='/en/shop/privacy-policy']");
					
					if (findTheElement(
							 "xpath=//div[3]/div/div[3]/ul/li[5]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Privacy and Security functionality Verification",
									"Home Page_Footer - Privacy and Security functionality Verification Displayed - For Verify Home Page_Footer - Privacy and Security functionality Verification");
							rpt.Pass("Home Page_Footer - Privacy and Security functionality Verification Displayed - For Verify Home Page_Footer - Privacy and Security functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Privacy and Security functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[3]/ul/li[5]/a");
						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Privacy and Security functionality Verification",
									" Home Page_Footer - Privacy and Security functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Privacy and Security functionality Verification");
							rpt.Fail("Home Page_Footer - Privacy and Security functionality Verification is NOT Displayed - For Verify Home Page_Footer - Privacy and Security functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Privacy and Security functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}

					Thread.sleep(2000);

//					java.util.Set<String> handles = browser.getWindowHandles();
//					System.out.println(handles);
//
//					for (String handle1 : browser.getWindowHandles()) {
//
//						System.out.println(handle1);
//
//						browser.switchTo().window(handle1);
//
//					}

					System.out.println(browser.getTitle());

					String NewWindowTitle = Browser.getTitle();

					if (NewWindowTitle.equals("Website Privacy Policy for CircuitCityB2C"))
					{
						System.out
								.println("Footer-Privacy And Security Link is navigating to corresponding Page");
					} else {
						System.out
								.println("Footer-Privacy And Security Link is not navigating to corresponding Page. Case Failed");
					}
					Thread.sleep(2000);
					// click("id=contentImage_1_HeaderStoreLogo_Content");
					String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow);
					       }
					  }

				}
				
				
				//CC_HP_060 - Privacy and Security
				public void HP_FeedbackFooter() throws Exception {
					Thread.sleep(2000);

					//click("xpath=//a[@href='/en/shop/feedback']");
					if (findTheElement(
							 "xpath=//div[3]/div/div[3]/ul/li[6]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Feedback functionality Verification",
									"Home Page_Footer - Feedback functionality Verification Displayed - For Verify Home Page_Footer - Feedback functionality Verification");
							rpt.Pass("Home Page_Footer - Feedback functionality Verification Displayed - For Verify Home Page_Footer - Feedback functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Feedback functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[3]/ul/li[6]/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Feedback functionality Verification",
									" Home Page_Footer - Feedback functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Feedback functionality Verification");
							rpt.Fail("Home Page_Footer - Feedback functionality Verification is NOT Displayed - For Verify Home Page_Footer - Feedback functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Feedback functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}

					Thread.sleep(2000);

//					java.util.Set<String> handles = browser.getWindowHandles();
//					System.out.println(handles);
//
//					for (String handle1 : browser.getWindowHandles()) {
//
//						System.out.println(handle1);
//
//						browser.switchTo().window(handle1);
//
//					}

					System.out.println(browser.getTitle());

					String NewWindowTitle = Browser.getTitle();

					if (NewWindowTitle.equals("Feedback"))
					{
						System.out
								.println("Footer-Feedback Link is navigating to corresponding Page");
					} else {
						System.out
								.println("Footer-Feedback Link is not navigating to corresponding Page. Case Failed");
					}
					Thread.sleep(2000);
					 click("id=contentImage_1_HeaderStoreLogo_Content");

				}
				public void Installations()throws Exception
				{
					if (findTheElement(
							 "xpath=(//a[contains(text(),'Installations')])[2]")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Installations functionality Verification",
									"Home Page_Footer - Installations functionality Verification Displayed - For Verify Home Page_Footer - Installations functionality Verification");
							rpt.Pass("Home Page_Footer - Installations functionality Verification Displayed - For Verify Home Page_Footer - Installations functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Installations functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=(//a[contains(text(),'Installations')])[2]");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Installations functionality Verification",
									" Home Page_Footer - Installations functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Installations functionality Verification");
							rpt.Fail("Home Page_Footer - Installations functionality Verification is NOT Displayed - For Verify Home Page_Footer - Installations functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Installations functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
					Thread.sleep(2000);
					// click("id=contentImage_1_HeaderStoreLogo_Content");
					String parentWindow = browser.getWindowHandle();
					  Set<String> handles =  browser.getWindowHandles();
					  for(String windowHandle  : handles)
					  {
					      if(!windowHandle.equals(parentWindow))
					     {
					       browser.switchTo().window(windowHandle);
					       String childWindowTitle = getTitle();
					       System.out.print(childWindowTitle);
					       browser.close(); 
					       browser.switchTo().window(parentWindow);
					       }
					  }
				}
				public void AboutUs()throws Exception
				{
					if (findTheElement(
							 "xpath=//div[3]/div/div[4]/ul/li/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - About Us functionality Verification",
									"Home Page_Footer - About Us functionality Verification Displayed - For Verify Home Page_Footer - About Us functionality Verification");
							rpt.Pass("Home Page_Footer - About Us functionality Verification Displayed - For Verify Home Page_Footer - About Us functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - About Us functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[4]/ul/li/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - About Us functionality Verification",
									" Home Page_Footer - About Us functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - About Us functionality Verification");
							rpt.Fail("Home Page_Footer - About Us functionality Verification is NOT Displayed - For Verify Home Page_Footer - About Us functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - About Us functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
					Thread.sleep(2000);
					 click("id=contentImage_1_HeaderStoreLogo_Content");
				}
				
				public void OurStory()throws Exception
				{
					if (findTheElement(
							 "xpath=//div[3]/div/div[4]/ul/li[2]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Our Story functionality Verification",
									"Home Page_Footer - Our Story functionality Verification Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Pass("Home Page_Footer - Our Story functionality Verification Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Our Story functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[4]/ul/li[2]/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Our Story functionality Verification",
									" Home Page_Footer - Our Story functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Fail("Home Page_Footer - Our Story functionality Verification is NOT Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Our Story functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
					Thread.sleep(2000);
					 click("id=contentImage_1_HeaderStoreLogo_Content");
				}
				
				public void PartnerWithUs()throws Exception
				{
					if (findTheElement(
							 "xpath=//div[3]/div/div[4]/ul/li[4]/a")
								.isDisplayed()) {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Our Story functionality Verification",
									"Home Page_Footer - Our Story functionality Verification Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Pass("Home Page_Footer - Our Story functionality Verification Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Our Story functionality Verification");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[3]/div/div[4]/ul/li[4]/a");

						} else {
							rpt.createTest("CC - Home Page - Verify Home Page_Footer - Our Story functionality Verification",
									" Home Page_Footer - Our Story functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Fail("Home Page_Footer - Our Story functionality Verification is NOT Displayed - For Verify Home Page_Footer - Our Story functionality Verification");
							rpt.Category("CC_Home Page - Verify Home Page_Footer - Our Story functionality Verification");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
					Thread.sleep(2000);
					 click("id=contentImage_1_HeaderStoreLogo_Content");
				}
		
	 //CC_HP_062 Career Footer
		 
		 public void HP_CareerFooter() throws Exception 
		 {
			 Thread.sleep(2000);
			 //click("xpath=//a[@href='/en/shop/careers']");
			 
			 if (findTheElement(
					 "xpath=//div[3]/div/div[4]/ul/li[3]/a")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Careers functionality Verification",
							"Home Page_Footer - Careers functionality Verification Displayed - For Verify Home Page_Footer - Careers functionality Verification");
					rpt.Pass("Home Page_Footer - Careers functionality Verification Displayed - For Verify Home Page_Footer - Careers functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Careers functionality Verification");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=//div[3]/div/div[4]/ul/li[3]/a");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer - Careers functionality Verification",
							" Home Page_Footer - Careers functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Careers functionality Verification");
					rpt.Fail("Home Page_Footer - Careers functionality Verification is NOT Displayed - For Verify Home Page_Footer - Careers functionality Verification");
					rpt.Category("CC_Home Page - Verify Home Page_Footer - Careers functionality Verification");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}

			 Thread.sleep(2000);
			 
			 String PageTitle=getTitle();
			 System.out.println(PageTitle);
			 
			if(PageTitle.equals("Careers"))
			{
			 System.out.println("Footer- Career Link is navigating to corresponding Page");
			}
			else
			{
				System.out.println("Footer-Career Link is not navigating to corresponding Page. Case Failed");
			}
			Thread.sleep(2000);
			 click("id=contentImage_1_HeaderStoreLogo_Content");
		 }
		
			//CC_HP_068 - Twitter Footer
			public void HP_twitterFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@href='http://twitter.com/CircuitCity']");
				if (findTheElement(
						 "xpath=//a[@href='http://twitter.com/CircuitCity']")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - twitter functionality Verification",
								"Home Page_Footer - twitter functionality Verification Displayed - For Verify Home Page_Footer - twitter functionality Verification");
						rpt.Pass("Home Page_Footer - twitter functionality Verification Displayed - For Verify Home Page_Footer - twitter functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - twitter functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//a[@href='http://twitter.com/CircuitCity']");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - twitter functionality Verification",
								" Home Page_Footer - twitter functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - twitter functionality Verification");
						rpt.Fail("Home Page_Footer - twitter functionality Verification is NOT Displayed - For Verify Home Page_Footer - twitter functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - twitter functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				Thread.sleep(2000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("Circuit City (@CircuitCity) | Twitter"))
				{
					System.out
							.println("Footer-Twitter Link is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-Twitter Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				 //click("id=contentImage_1_HeaderStoreLogo_Content");
				String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       browser.close(); 
				       browser.switchTo().window(parentWindow);
				       }
				  }

			}
			//CC_HP_069 - Facebook Footer
			public void HP_FacebookFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@href='http://www.facebook.com/CircuitCity-1663290060604757/']");
				
				if (findTheElement(
						 "xpath=//div[@id='footerWrapper']/div[4]/div/a[2]")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Facebook functionality Verification",
								"Home Page_Footer - Facebook functionality Verification Displayed - For Verify Home Page_Footer - Facebook functionality Verification");
						rpt.Pass("Home Page_Footer - Facebook functionality Verification Displayed - For Verify Home Page_Footer - Facebook functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Facebook functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//div[@id='footerWrapper']/div[4]/div/a[2]");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Facebook functionality Verification",
								" Home Page_Footer - Facebook functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Facebook functionality Verification");
						rpt.Fail("Home Page_Footer - Facebook functionality Verification is NOT Displayed - For Verify Home Page_Footer - Facebook functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Facebook functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				Thread.sleep(2000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("Facebook"))
				{
					System.out
							.println("Footer-FaceBook Link is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-FaceBook Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       browser.close(); 
				       browser.switchTo().window(parentWindow);
				       }
				  }

			}
		
		
			//CC_HP_070 - Youtube Footer
			public void HP_YouTubeFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@class='youtube']");
				
				if (findTheElement(
						 "xpath=//div[@id='footerWrapper']/div[4]/div/a[3]")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - YouTube functionality Verification",
								"Home Page_Footer - YouTube functionality Verification Displayed - For Verify Home Page_Footer - YouTube functionality Verification");
						rpt.Pass("Home Page_Footer - YouTube functionality Verification Displayed - For Verify Home Page_Footer - YouTube functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - YouTube functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//div[@id='footerWrapper']/div[4]/div/a[3]");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - YouTube functionality Verification",
								" Home Page_Footer - YouTube functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - YouTube functionality Verification");
						rpt.Fail("Home Page_Footer - YouTube functionality Verification is NOT Displayed - For Verify Home Page_Footer - YouTube functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - YouTube functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				Thread.sleep(2000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("Youtube"))
				{
					System.out
							.println("Footer-You Tube Link is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-YouTube Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				browser.navigate().back();
			}

			//CC_HP_071 - Printerest Footer
			public void HP_PinterestFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@href='http://www.pinterest.com/circuitcity1490/pins/']");
				
				if (findTheElement(
						 "xpath=//a[@href='http://www.pinterest.com/circuitcity1490/pins/']")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Pinterest functionality Verification",
								"Home Page_Footer - Pinterest functionality Verification Displayed - For Verify Home Page_Footer - Pinterest functionality Verification");
						rpt.Pass("Home Page_Footer - Pinterest functionality Verification Displayed - For Verify Home Page_Footer - Pinterest functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Pinterest functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//a[@href='http://www.pinterest.com/circuitcity1490/pins/']");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Pinterest functionality Verification",
								" Home Page_Footer - Pinterest functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Pinterest functionality Verification");
						rpt.Fail("Home Page_Footer - Pinterest functionality Verification is NOT Displayed - For Verify Home Page_Footer - Pinterest functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Pinterest functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				
				Thread.sleep(4000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("Site Blocked"))
				{
					System.out
							.println("Footer-Pinterest Link is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-Pinterest Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				
				String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       browser.close(); 
				       browser.switchTo().window(parentWindow);
				       }
				  }
			}
			//CC_HP_072 - Instagram Footer
			public void HP_InstagramFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@href='http://www.instagram.com/circuitcity/']");
				
				if (findTheElement(
						 "xpath=//a[@href='http://www.instagram.com/circuitcity/']")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Instagram functionality Verification",
								"Home Page_Footer - Instagram functionality Verification Displayed - For Verify Home Page_Footer - Instagram functionality Verification");
						rpt.Pass("Home Page_Footer - Instagram functionality Verification Displayed - For Verify Home Page_Footer - Instagram functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Instagram functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//a[@href='http://www.instagram.com/circuitcity/']");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Instagram functionality Verification",
								" Home Page_Footer - Instagram functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Instagram functionality Verification");
						rpt.Fail("Home Page_Footer - Instagram functionality Verification is NOT Displayed - For Verify Home Page_Footer - Instagram functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Instagram functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				Thread.sleep(4000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("Circuit City (@circuitcity) "
						+ " Instagram photos and videos"))
				{
					System.out
							.println("Footer-InstagramLink is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-Instagram Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       browser.close(); 
				       browser.switchTo().window(parentWindow);
				       }
				  }
			}	 
	 
			//CC_HP_073 - GooglePlus Footer
			public void HP_GooglePlusFooter() throws Exception {
				Thread.sleep(2000);

				//click("xpath=//a[@href='http://plus.google.com/102502279675017944350']");
				
				if (findTheElement(
						 "xpath=//a[@href='http://plus.google.com/102502279675017944350']")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Google Plus functionality Verification",
								"Home Page_Footer - Google Plus functionality Verification Displayed - For Verify Home Page_Footer - Google Plus functionality Verification");
						rpt.Pass("Home Page_Footer - Google Plus functionality Verification Displayed - For Verify Home Page_Footer - Google Plus functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Google Plus functionality Verification");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=//a[@href='http://plus.google.com/102502279675017944350']");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer - Google Plus functionality Verification",
								" Home Page_Footer - Google Plus functionality Verification Page is NOT Displayed - For Verify Home Page_Footer - Google Plus functionality Verification");
						rpt.Fail("Home Page_Footer - Google Plus functionality Verification is NOT Displayed - For Verify Home Page_Footer - Google Plus functionality Verification");
						rpt.Category("CC_Home Page - Verify Home Page_Footer - Google Plus functionality Verification");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}

				Thread.sleep(4000);

//				java.util.Set<String> handles = browser.getWindowHandles();
//				System.out.println(handles);
//
//				for (String handle1 : browser.getWindowHandles()) {
//
//					System.out.println(handle1);
//
//					browser.switchTo().window(handle1);
//
//				}

				System.out.println(browser.getTitle());

				String NewWindowTitle = Browser.getTitle();

				if (NewWindowTitle.equals("CircuitCity - Google+"))
				{
					System.out
							.println("Footer-Google Plus Link is navigating to corresponding Page");
				} else {
					System.out
							.println("Footer-Google Plus Link is not navigating to corresponding Page. Case Failed");
				}
				Thread.sleep(2000);
				String parentWindow = browser.getWindowHandle();
				  Set<String> handles =  browser.getWindowHandles();
				  for(String windowHandle  : handles)
				  {
				      if(!windowHandle.equals(parentWindow))
				     {
				       browser.switchTo().window(windowHandle);
				       String childWindowTitle = getTitle();
				       System.out.print(childWindowTitle);
				       browser.close(); 
				       browser.switchTo().window(parentWindow);
				       }
				  }
			}	
			//CC_75 Featured Product Carousel
			public void HP_featuredProductsCarosel() throws Exception
			{
				Thread.sleep(2000);
//				click("xpath=//a[@id='nextPageButton_4_-3012_3074457345618261104']"); //--Right Click
//				List<WebElement> a =browser.findElements(By.xpath(".//*[@id='catalogEntryRecommckendationWidget_4_-3012_3074457345618261104']"));
//				System.out.println("Number of Element"+a.size());
			 //click("xpath=//div[5]/div/div[3]/a");
			 if (findTheElement(
					 "xpath=(//a[contains(@href, '#')])[62]")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer",
							"Home Page_Footer - 5 products is moved to right on clicking right carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Pass("Home Page_Footer - 5 products is moved to right on clicking right carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Category("CC_Home Page - Verify Home Page_Footer");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=(//a[contains(@href, '#')])[62]");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer",
							" Home Page_Footer - 5 products NOT moved to right on clicking right carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Fail("Home Page_Footer - 5 products NOT moved to right on clicking right carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Category("CC_Home Page - Verify Home Page_Footer ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
			 
			 //click("xpath=//div[2]/div/div[5]/div/div/a");
			 if (findTheElement(
					 "xpath=(//a[contains(@href, '#')])[61]")
						.isDisplayed()) {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer",
							"Home Page_Footer - 5 products is moved to left on clicking left carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Pass("Home Page_Footer - 5 products is moved to left on clicking left carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Category("CC_Home Page - Verify Home Page_Footer");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("xpath=(//a[contains(@href, '#')])[61]");

				} else {
					rpt.createTest("CC - Home Page - Verify Home Page_Footer",
							" Home Page_Footer - 5 products NOT moved to left on clicking left carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Fail("Home Page_Footer - 5 products NOT moved to left on clicking left carosel from featured products section - For Verify Home Page_Footer ");
					rpt.Category("CC_Home Page - Verify Home Page_Footer ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
				
				//click("xpath=//a[@id='prevPageButton_4_-3012_3074457345618261104']"); //--Left Click		
				}
			
			//CC_76 Best Seller Carousel
			public void HP_BestSellerCarosel() throws Exception
			{
//				Thread.sleep(2000);
//				click("xpath=//a[@id='nextPageButton_9_-3012_3074457345618261105']");
//				List<WebElement> a =browser.findElements(By.xpath(".//*[@id='catalogEntryRecommendationWidget_4_-3012_3074457345618261104']"));
//				System.out.println("Number of Element"+a.size());
//			
				//click("xpath=//a[@id='prevPageButton_9_-3012_3074457345618261105']"); //Left Click
				 if (findTheElement(
						 "xpath=(//a[contains(@href, '#')])[100]")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer",
								"Home Page_Footer - 5 products is moved to right on clicking right carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Pass("Home Page_Footer - 5 products is moved to right on clicking right carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Category("CC_Home Page - Verify Home Page_Footer");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=(//a[contains(@href, '#')])[100]");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer",
								" Home Page_Footer - 5 products NOT moved to right on clicking right carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Fail("Home Page_Footer - 5 products NOT moved to right on clicking right carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Category("CC_Home Page - Verify Home Page_Footer ");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}
				 
				 //click("xpath=//div[2]/div/div[5]/div/div/a");
				 if (findTheElement(
						 "xpath=(//a[contains(@href, '#')])[99]")
							.isDisplayed()) {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer",
								"Home Page_Footer - 5 products is moved to left on clicking left carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Pass("Home Page_Footer - 5 products is moved to left on clicking left carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Category("CC_Home Page - Verify Home Page_Footer");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						click("xpath=(//a[contains(@href, '#')])[99]");

					} else {
						rpt.createTest("CC - Home Page - Verify Home Page_Footer",
								" Home Page_Footer - 5 products NOT moved to left on clicking left carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Fail("Home Page_Footer - 5 products NOT moved to left on clicking left carosel from Best Seller section - For Verify Home Page_Footer ");
						rpt.Category("CC_Home Page - Verify Home Page_Footer ");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}
					
				
			}
			
			
			
}
			
	
			
			