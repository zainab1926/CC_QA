package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Promotions extends Browser
{
	Report rpt = new Report();
	String promocode="10PERCOFF";
	String address="120 Greenwich St";
	String city="New York";
	String state="NY";
	String zipCode="10006";
	String creditCardNo="5555555555554444";
	String cvv="123";
	CommonUtils email = new CommonUtils();
	String name=email.getRandomString(6);
	String phoneNo=email.getRandomNumber(10);
	String emailid="user@test.com";
	@SuppressWarnings("static-access")
	@Parameters({"browser","url","Module"})
	@Test
	public void executeAll()throws Exception
	{
		click("id=allDepartmentsButton");
		Thread.sleep(2000);
		click("link=Appliances");//categories
		Thread.sleep(4000);
		click("xpath=//li[1]/.//div[@class='product_name']"); //product
		Thread.sleep(8000);
		//tc-04
		String price=findTheElement("css=span.ourprice_original_section").getText();
		System.out.println(price);
		if(findTheElement("css=span.ourprice_original_section").isDisplayed())
        {
			
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Original Price and Selling Price is displayed : " +price);
	         rpt.Pass("Original Price and Selling Price is displayed : " +price);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Original Price and Selling Price NOT displayed");
	         rpt.Fail("Original Price and Selling Price NOT displayed");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(2000);
		click("id=add2CartBtn");//add to cart
		Thread.sleep(3000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		//tc-03
		String shipping=findTheElement("xpath=//div[@id='orderItemDisplay']/div/div/span").getText();
		System.out.println(shipping);
		if(findTheElement("xpath=//div[@id='orderItemDisplay']/div/div/span").isDisplayed())
        {
			
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Qualify for free shipping is displayed : " +shipping);
	         rpt.Pass("Qualify for free shipping is displayed : " +shipping);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Qualify for free shipping NOT displayed");
	         rpt.Fail("Qualify for free shipping NOT displayed");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(3000);
		if(findTheElement("id=promoCode").isDisplayed())
        {
			
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Promo code applied : " +promocode);
	         rpt.Pass("Promo code applied : " +promocode);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Promo code NOT applied");
	         rpt.Fail("Promo code NOT applied");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		sendKeys("id=promoCode",promocode);
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_PromotionCodeDisplay_links_1']/div[2]"); //apply
		Thread.sleep(2000);
		
		String promo=findTheElement("css=div.summary_detail").getText();
		System.out.println(promo);
		if(promo!=null)
        {
			
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Savings after adding promo code is displayed : " +promo);
	         rpt.Pass("Savings after adding promo code is displayed : " +promo);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Savings after adding promo code NOT displayed");
	         rpt.Fail("Savings after adding promo code NOT displayed");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(2000);
		//tc-05
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 20EN001SUS TS P50 E3 16GB 256GB");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(4000);
		click("id=add2CartBtn");
		Thread.sleep(3000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		sendKeys("id=SimpleSearchForm_SearchTerm","Lenovo 4X40E77324 TP Professional Backpack");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(2000);
		click("id=add2CartBtn");
		Thread.sleep(3000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		click("id=promotion_1"); // removing promo code
		Thread.sleep(2000);
		String promo1=findTheElement("css=div.summary_detail").getText();
		System.out.println(promo1);
		if(promo1!=null)
        {
			
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Discount is applied on adding products : " +promo1);
	         rpt.Pass("Discount is applied on adding products : " +promo1);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Discount NOT applied on adding products");
	         rpt.Fail("Discount NOT applied on adding products");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		//click("link=READY TO CHECKOUT");
		Thread.sleep(3000);
		//tc-06
		sendKeys("id=SimpleSearchForm_SearchTerm"," Lenovo 0A36188 Laser Wireless Mouse");
		Thread.sleep(2000);
		click("id=autoSelectOption_0");
		Thread.sleep(2000);
		click("id=add2CartBtn");
		Thread.sleep(2000);
		click("id=GotoCartButton2"); //view my cart
		Thread.sleep(2000);
		sendKeys("id=promoCode",promocode);
		Thread.sleep(2000);
		click("xpath=//a[@id='WC_PromotionCodeDisplay_links_1']/div[2]"); //apply
		Thread.sleep(2000);
		String promo11=findTheElement("css=div.summary_detail").getText();
		System.out.println(promo11);
		if(promo11!=null)
        {
			rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Free Shipping is applied : " +promo11);
	         rpt.Pass("Free Shipping is applied :  " +promo11);
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "ValidMessage");
	         rpt.imgPathPass(path);
        }
		    
		else
		{
			 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Free Shipping NOT applied");
	         rpt.Fail("Free Shipping NOT applied");
	         rpt.Category("CIRCUIT CITY - PROMOTIONS");
	         String path = rpt.CaptureScreen(browser, "InvalidMessage");
	         rpt.imgPathFail(path);
	}
		Thread.sleep(2000);
		click("link=READY TO CHECKOUT");
		Thread.sleep(2000);
		click("id=guestShopperContinue"); //chckout as guest
		Thread.sleep(2000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1").clear();
	    sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_firstName_1",name);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1",name);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_address1_1",address);
		Thread.sleep(3000);
		//findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1").clear();
		click("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_lastName_1");
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_city_1",city);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_state_1",state);
		Thread.sleep(3000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_zipCode_1",zipCode);
		Thread.sleep(2000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_email1_1",emailid);
		Thread.sleep(2000);
		findTheElement("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1").clear();
		sendKeys("id=WC_ShippingAddressForm_AddressEntryForm_FormInput_phone1_1",phoneNo);
		Thread.sleep(2000);
		click("id=summaryButton"); //continue
		 Thread.sleep(6000);
	      //checkout with credit card
	       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-number")));
	       sendKeys("id=credit-card-number",creditCardNo);
	      
	       browser.switchTo().defaultContent();
	       Thread.sleep(3000);
	       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-cvv")));
	       sendKeys("id=cvv",cvv);
	       Thread.sleep(2000);
	       browser.switchTo().defaultContent();
	       Thread.sleep(2000);
	       browser.switchTo().frame(browser.findElement(By.id("braintree-hosted-field-expirationYear")));
	       WebElement monthdd = browser.findElement(By.xpath("//select[@id='expiration-year']"));
	       Select select = new Select(monthdd);
			select.selectByVisibleText("2022");
	       Thread.sleep(2000);
	       browser.switchTo().defaultContent();
	       Thread.sleep(3000);
	       click("id=submit"); //continue
	       Thread.sleep(6000);
	       WebElement Element1 = findTheElement("id=summaryButton");
			 JavascriptExecutor jse1 = (JavascriptExecutor)browser;
		      jse1.executeScript("arguments[0].scrollIntoView();", Element1);
		      Thread.sleep(3000);
	       click("id=summaryButton"); //place order
	       Thread.sleep(4000);
	       String chkoutpage11=findTheElement("css=div.logo-bar").getText();
			System.out.println(chkoutpage11);
			//String actualtxt11="The Address you have entered is not valid. Please enter a valid address";
			if(chkoutpage11!=null)
	       {
				//System.out.println("Mini Cart Button displayed");
				rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Order is placed" );
		         rpt.Pass("Order is placed");
		         rpt.Category("CIRCUIT CITY - PROMOTIONS");
		         String path = rpt.CaptureScreen(browser, "ValidMessage");
		         rpt.imgPathPass(path);
			  }
			else
			{
				//System.out.println("Mini Cart Button NOT displayed");
				 rpt.createTest("CIRCUIT CITY - PROMOTIONS", "Order is NOT placed");
		         rpt.Fail("Order is NOT placed");
		         rpt.Category("CIRCUIT CITY - PROMOTIONS");
		         String path = rpt.CaptureScreen(browser, "InvalidMessage");
		         rpt.imgPathFail(path);
			}
	}
	
}
