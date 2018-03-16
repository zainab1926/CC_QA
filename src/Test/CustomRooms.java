package Test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomRooms extends Browser
{
	Report rpt = new Report();
	JavascriptExecutor jse = (JavascriptExecutor)browser;
	WebElement Element;
	
	@SuppressWarnings("static-access")
	@Parameters({ "browser" })
	@Test
	
	public void executeAll()throws Exception
	{
		Thread.sleep(2000);
		PDPModule p=new PDPModule();
		p.Login();
		//TC 1
		 Thread.sleep(3000);
		 click("id=allDepartmentsButton"); // Select Products
		 Thread.sleep(3000);
		 click("link=Smart Rooms");//categories
		 Thread.sleep(3000);
		 String pagetitle=getTitle();
			System.out.println(pagetitle);
			Thread.sleep(2000);
			if (pagetitle.contains("Smart Rooms | Circuit City")) {
				rpt.createTest("Circuit City - Custom Rooms", "Smart room from category is navigated to respective page");
				rpt.Pass("Smart room from category is navigated to respective page ");
				rpt.Category("Circuit City - Custom Rooms");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				
			} else {
				rpt.createTest("Circuit City - Custom Rooms", " Smart room from category NOT navigated to respective page");
				rpt.Fail(" Smart room from category NOT navigated to respective page ");
				rpt.Category("Circuit City - Custom Rooms ");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
			Thread.sleep(2000);
			
			//TC 3
			click("id=StarterKitchenShopNow");
			String pagetitle1=getTitle();
			System.out.println(pagetitle1);
			Thread.sleep(2000);
			if (pagetitle1.contains("Starter Kitchen")) {
				rpt.createTest("Circuit City - Custom Rooms", "Shop now is navigated to respective page");
				rpt.Pass("Shop now is navigated to respective page ");
				rpt.Category("Circuit City - Custom Rooms");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				
			} else {
				rpt.createTest("Circuit City - Custom Rooms", " Shop now NOT navigated to respective page");
				rpt.Fail(" Shop now NOT navigated to respective page ");
				rpt.Category("Circuit City - Custom Rooms ");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
			Thread.sleep(2000);
			browser.navigate().back();
			Thread.sleep(2000);
			
			//TC 7
			//click("link=SEE MORE IDEAS");
			Thread.sleep(2000);
			
			//TC 9
			click("link=BUY NOW");
			Thread.sleep(2000);
			String msg=findTheElement("id=cartDropdownMessage").getText();
			System.out.println(msg);
			String actual="Your item was added";
			if (msg.contains(actual)) {
				rpt.createTest("Circuit City - Custom Rooms", "Shop now from top seller is navigated to respective page");
				rpt.Pass("Shop now from top seller is navigated to respective page");
				rpt.Category("Circuit City - Custom Rooms");
				String path = rpt.CaptureScreen(browser, "ValidMessage");
				rpt.imgPathPass(path);
				
			} else {
				rpt.createTest("Circuit City - Custom Rooms", " Shop now from top seller NOT navigated to respective page");
				rpt.Fail(" Shop now from top seller NOT navigated to respective page ");
				rpt.Category("Circuit City - Custom Rooms ");
				String path = rpt.CaptureScreen(browser, "InvalidMessage");
				rpt.imgPathFail(path);
			}
			Thread.sleep(2000);
			click("id=GotoCartButton2");
			Thread.sleep(2000);
			click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
			Thread.sleep(2000);
			browser.navigate().back();
			Thread.sleep(2000);
			browser.navigate().back();
			Thread.sleep(2000);
			
			
			//TC 10
			//click("xpath=//li[2]/.//div[@class='compare_target compare_target_hidden']//label[contains(text(),'Compare')]");
			click("xpath=//div[7]/label");
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,90)");
			Thread.sleep(2000);
			//click("xpath=//li[3]/.//div[@class='compare_target compare_target_hidden']//label[contains(text(),'Compare')]");
			click("xpath=//div[2]/div/div[2]/div[7]/label");
			Thread.sleep(2000);
			click("id=stickyCompare");
			Thread.sleep(2000);
			 String pagetitle11=getTitle();
				System.out.println(pagetitle11);
				Thread.sleep(2000);
				if (pagetitle11.contains("Circuit City - Compare Products")) {
					rpt.createTest("Circuit City - Custom Rooms", "Compare from top seller is navigated to respective page");
					rpt.Pass("Compare from top seller is navigated to respective page ");
					rpt.Category("Circuit City - Custom Rooms");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					
				} else {
					rpt.createTest("Circuit City - Custom Rooms", " Compare from top seller NOT navigated to respective page");
					rpt.Fail(" Compare from top seller NOT navigated to respective page ");
					rpt.Category("Circuit City - Custom Rooms ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
				Thread.sleep(2000);
				browser.navigate().back();
				Thread.sleep(2000);
				
				//TC 16
				//click("link=SHOP ALL SMART PRODUCTS");
				if(findTheElement("link=SHOP ALL SMART PRODUCTS").isDisplayed())
				 {
					rpt.createTest("Circuit City - Custom Rooms", "Shop all smart products from shop smart products is navigated to respective page");
					rpt.Pass("Shop all smart products from shop smart products is navigated to respective page ");
					rpt.Category("Circuit City - Custom Rooms");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("link=SHOP ALL SMART PRODUCTS");
					
				} else {
					rpt.createTest("Circuit City - Custom Rooms", " Shop all smart products from shop smart products NOT navigated to respective page");
					rpt.Fail(" Shop all smart products from shop smart products NOT navigated to respective page ");
					rpt.Category("Circuit City - Custom Rooms ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
				Thread.sleep(2000);
				 click("link=Smart Rooms");//categories
				 Thread.sleep(3000);
				 
				 //TC 18 (missing in PROD)
				/* if(findTheElement("css=div.our_top_brands").isDisplayed())
				 {
					rpt.createTest("Circuit City - Custom Rooms", "Brands we love banner is displayed");
					rpt.Pass("Brands we love banner is displayed");
					rpt.Category("Circuit City - Custom Rooms");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("link=SHOP ALL SMART PRODUCTS");
					
				} else {
					rpt.createTest("Circuit City - Custom Rooms", " Brands we love banner NOT displayed");
					rpt.Fail(" Brands we love banner NOT displayed ");
					rpt.Category("Circuit City - Custom Rooms ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
				Thread.sleep(2000);*/
				
				//TC 20 (missing in PROD)
				/* if(findTheElement("css=div.banner-ad").isDisplayed())
				 {
					rpt.createTest("Circuit City - Custom Rooms", "Sponsored Banner ad is displayed");
					rpt.Pass("Sponsored Banner ad is displayed");
					rpt.Category("Circuit City - Custom Rooms");
					String path = rpt.CaptureScreen(browser, "ValidMessage");
					rpt.imgPathPass(path);
					click("link=SHOP ALL SMART PRODUCTS");
					
				} else {
					rpt.createTest("Circuit City - Custom Rooms", " Sponsored Banner ad NOT displayed");
					rpt.Fail(" Sponsored Banner ad NOT displayed ");
					rpt.Category("Circuit City - Custom Rooms ");
					String path = rpt.CaptureScreen(browser, "InvalidMessage");
					rpt.imgPathFail(path);
				}
				Thread.sleep(2000);*/
				
				//TC 25
				click("link=ASK US");
				Thread.sleep(2000);
				 String pagetitle111=getTitle();
					System.out.println(pagetitle111);
					Thread.sleep(2000);
					if (pagetitle111.contains("Contact Us")) {
						rpt.createTest("Circuit City - Custom Rooms", " ASK US from FAQ section is navigating to respective page");
						rpt.Pass(" ASK US from FAQ section is navigating to respective page ");
						rpt.Category("Circuit City - Custom Rooms");
						String path = rpt.CaptureScreen(browser, "ValidMessage");
						rpt.imgPathPass(path);
						
					} else {
						rpt.createTest("Circuit City - Custom Rooms", "  ASK US from FAQ section NOT navigating to respective page");
						rpt.Fail("  ASK US from FAQ section NOT navigating to respective page ");
						rpt.Category("Circuit City - Custom Rooms ");
						String path = rpt.CaptureScreen(browser, "InvalidMessage");
						rpt.imgPathFail(path);
					}
					Thread.sleep(2000);
					browser.navigate().back();
					Thread.sleep(2000);
					
					//TC 26 (missing in PROD)
					/*click("link=ASK US");
					Thread.sleep(2000);
					 String pagetitle1111=getTitle();
						System.out.println(pagetitle1111);
						Thread.sleep(2000);
						if (pagetitle1111.contains("FAQ")) {
							rpt.createTest("Circuit City - Custom Rooms", " Show more from FAQ section is navigating to respective page");
							rpt.Pass(" Show more from FAQ section is navigating to respective page ");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", "  Show more from FAQ section NOT navigating to respective page");
							rpt.Fail("  Show more from FAQ section NOT navigating to respective page ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);*/
						
						//TC 28
						//click("link=START");
						
						//TC 30
						click("xpath=//div[3]/div/div/div/div/div/a/img");
						Thread.sleep(2000);
						 if(findTheElement("css=ul.tabs").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Tabs(Starter, Enhanced, Premium) in Smart Room is displayed");
							rpt.Pass("Tabs(Starter, Enhanced, Premium) in Smart Room is displayed");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							//click("link=SHOP ALL SMART PRODUCTS");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Tabs(Starter, Enhanced, Premium) in Smart Room NOT displayed");
							rpt.Fail(" Tabs(Starter, Enhanced, Premium) in Smart Room NOT displayed ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						if(findTheElement("css=h1").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Tabs(Customise this bundle) in Smart Room is displayed");
							rpt.Pass("Tabs(Customise this bundle) in Smart Room is displayed");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							//click("link=SHOP ALL SMART PRODUCTS");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Tabs(Customise this bundle) in Smart Room NOT displayed");
							rpt.Fail(" Tabs(Customise this bundle) in Smart Room NOT displayed ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						
						//TC 36
						if(findTheElement("css=h1").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Customize this bundle is displayed");
							rpt.Pass("Customize this bundle is displayed");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							//click("link=SHOP ALL SMART PRODUCTS");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Customize this bundle NOT displayed");
							rpt.Fail(" Customize this bundle NOT displayed ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						
						//TC 37
						click("link=ADD");
						Thread.sleep(2000);
						if(findTheElement("xpath=//div[8]/div/div/div[2]/div/div[3]/img").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Product is added to smart room");
							rpt.Pass("Product is added to smart room");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							//click("link=ADD");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Product NOT added to smart room");
							rpt.Fail(" Product NOT added to smart room ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						
						//TC 38
						
						if(findTheElement("link=REMOVE").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Product is removed from smart room");
							rpt.Pass("Product is removed from smart room");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("link=REMOVE");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Product NOT removed from smart room");
							rpt.Fail(" Product NOT removed from smart room ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						
						//TC 39
						if(findTheElement("xpath=//div[2]/div/div/div/div/div[2]/div/a/img").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "Product is added to wishlist");
							rpt.Pass("Product is added to wishlist");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("xpath=//div[2]/div/div/div/div/div[2]/div/a/img");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Product NOT added to wishlist");
							rpt.Fail(" Product NOT added to wishlist ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						click("id=wishListQuickLink_alt");
						Thread.sleep(2000);
						click("link=Remove");
						Thread.sleep(2000);
						click("id=shoppingListCreateSuccessPopup_continue_shopping");
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 43
						click("xpath=//a[contains(@href, 'javascript:addBundleTocart();')]");
						Thread.sleep(2000);
						Thread.sleep(2000);
						String msg1=findTheElement("id=cartDropdownMessage").getText();
						System.out.println(msg1);
						String actual1="Your item was added";
						if (msg1.contains(actual1)) {
							rpt.createTest("Circuit City - Custom Rooms", "Products from bundles are added to cart");
							rpt.Pass("Products from bundles are added to cart");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Products from bundles NOT added to cart");
							rpt.Fail(" Products from bundles NOT added to cart ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						click("id=GotoCartButton2");
						Thread.sleep(2000);
						click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
						Thread.sleep(2000);
						click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_2']/b");
						Thread.sleep(2000);
						click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
						Thread.sleep(2000);
						click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 46
						click("link=LEARN MORE");
						Thread.sleep(2000);
						String pagetitle11111=getTitle();
						System.out.println(pagetitle11111);
						Thread.sleep(2000);
						if (pagetitle11111.contains("Contact Us")) {
							rpt.createTest("Circuit City - Custom Rooms", " Learn more from installation charge is navigating to respective page");
							rpt.Pass(" Learn more from installation charge is navigating to respective page ");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", "  Learn more from installation charge NOT navigating to respective page");
							rpt.Fail("  Learn more from installation charge NOT navigating to respective page ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 51
						if(findTheElement("xpath=//div[@id='ci_espot_3074457345618259658_Widget_ContentRecommendation_801_3074457345618259658']/div/div/div").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", " Compatability of your devices with this room is displayed and working");
							rpt.Pass("Compatability of your devices with this room is displayed and working");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("link=Amazon Echo");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Compatability of your devices with this room NOT displayed and working");
							rpt.Fail(" Compatability of your devices with this room NOT displayed and working ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 52
						if(findTheElement("css=div.tabButtonContainer").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", "  Tabs below customize this bundle is displayed");
							rpt.Pass("Tabs below customize this bundle is displayed");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							//click("link=Amazon Echo");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Tabs below customize this bundle NOT displayed");
							rpt.Fail(" Tabs below customize this bundle NOT displayed ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						
						//TC 59
						if(findTheElement("css=div.red-banner").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", " Worry-Free installation | 24/7 Support is displayed and navigating to respective page");
							rpt.Pass("Worry-Free installation | 24/7 Support is displayed and navigating to respective page");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							click("link=LEARN MORE");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Worry-Free installation | 24/7 Support NOT displayed and navigating to respective page");
							rpt.Fail("Worry-Free installation | 24/7 Support NOT displayed and navigating to respective page");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 65
						Thread.sleep(2000);
						if(findTheElement("xpath=//a[@id='SMART_ROOM_DETAIL_COMP_ACCESSORY3074457345616822718addToShoppingList']/img").isDisplayed())
						 {
							rpt.createTest("Circuit City - Custom Rooms", " Product is added to wishlist from compatible accessories section");
							rpt.Pass("Product is added to wishlist from compatible accessories section");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							Thread.sleep(2000);
							//click("xpath=//div[2]/div/div[2]/div/span/div[2]/div/a/img");
							click("xpath=//a[@id='SMART_ROOM_DETAIL_COMP_ACCESSORY3074457345616822718addToShoppingList']/img");
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", "Product NOT added to wishlist from compatible accessories section");
							rpt.Fail("Product NOT added to wishlist from compatible accessories section");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						click("id=wishListQuickLink_alt");
						Thread.sleep(2000);
						click("link=Remove");
						Thread.sleep(2000);
						click("id=shoppingListCreateSuccessPopup_continue_shopping");
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 66
						click("link=BUY NOW");
						Thread.sleep(2000);
						
						String msg11=findTheElement("id=cartDropdownMessage").getText();
						System.out.println(msg11);
						String actual11="Your item was added";
						if (msg11.contains(actual11)) {
							rpt.createTest("Circuit City - Custom Rooms", "Shop now from compatible accessories is navigated to respective page");
							rpt.Pass("Shop now from compatible accessories is navigated to respective page");
							rpt.Category("Circuit City - Custom Rooms");
							String path = rpt.CaptureScreen(browser, "ValidMessage");
							rpt.imgPathPass(path);
							
						} else {
							rpt.createTest("Circuit City - Custom Rooms", " Shop now from compatible accessories NOT navigated to respective page");
							rpt.Fail(" Shop now from compatible accessories NOT navigated to respective page ");
							rpt.Category("Circuit City - Custom Rooms ");
							String path = rpt.CaptureScreen(browser, "InvalidMessage");
							rpt.imgPathFail(path);
						}
						Thread.sleep(2000);
						click("id=GotoCartButton2");
						Thread.sleep(2000);
						click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						browser.navigate().back();
						Thread.sleep(2000);
						
						//TC 67
						click("xpath=//div[7]/label");
						Thread.sleep(2000);
						jse.executeScript("window.scrollBy(0,90)");
						Thread.sleep(2000);
						//click("xpath=//li[3]/.//div[@class='compare_target compare_target_hidden']//label[contains(text(),'Compare')]");
						click("xpath=//div[2]/div/div[2]/div[7]/label");
						Thread.sleep(2000);
						click("xpath=(//a[contains(text(),'Compare')])[3]");
						Thread.sleep(2000);
						 String pagetitle111111=getTitle();
							System.out.println(pagetitle111111);
							Thread.sleep(2000);
							if (pagetitle111111.contains("Circuit City - Compare Products")) {
								rpt.createTest("Circuit City - Custom Rooms", "Compare from compatible accessories is navigated to respective page");
								rpt.Pass("Compare from compatible accessories is navigated to respective page ");
								rpt.Category("Circuit City - Custom Rooms");
								String path = rpt.CaptureScreen(browser, "ValidMessage");
								rpt.imgPathPass(path);
								
							} else {
								rpt.createTest("Circuit City - Custom Rooms", " Compare from compatible accessories NOT navigated to respective page");
								rpt.Fail(" Compare from compatible accessories NOT navigated to respective page ");
								rpt.Category("Circuit City - Custom Rooms ");
								String path = rpt.CaptureScreen(browser, "InvalidMessage");
								rpt.imgPathFail(path);
							}
							Thread.sleep(2000);
							browser.navigate().back();
							Thread.sleep(2000);
							
							//TC 69
							
							if(findTheElement("xpath=//a[@id='SMART_ROOM_DETAIL_MOST_LOVED3074457345616721506addToShoppingList']/img").isDisplayed())
							 {
								rpt.createTest("Circuit City - Custom Rooms", " Product is added to wishlist from Most loved section");
								rpt.Pass("Product is added to wishlist from Most loved section");
								rpt.Category("Circuit City - Custom Rooms");
								String path = rpt.CaptureScreen(browser, "ValidMessage");
								rpt.imgPathPass(path);
								//click("xpath=//div[3]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div/span/div[2]/div/a/img");
								click("xpath=//a[@id='SMART_ROOM_DETAIL_MOST_LOVED3074457345616721506addToShoppingList']/img");
								
							} else {
								rpt.createTest("Circuit City - Custom Rooms", "Product NOT added to wishlist from Most loved section");
								rpt.Fail("Product NOT added to wishlist from Most loved section");
								rpt.Category("Circuit City - Custom Rooms ");
								String path = rpt.CaptureScreen(browser, "InvalidMessage");
								rpt.imgPathFail(path);
							}
							Thread.sleep(2000);
							click("id=wishListQuickLink_alt");
							Thread.sleep(2000);
							click("link=Remove");
							Thread.sleep(2000);
							click("id=shoppingListCreateSuccessPopup_continue_shopping");
							Thread.sleep(2000);
							browser.navigate().back();
							Thread.sleep(2000);
							
							//TC 70
							click("xpath=(//a[contains(text(),'BUY NOW')])[4]");
							Thread.sleep(2000);
							
							String msg111=findTheElement("id=cartDropdownMessage").getText();
							System.out.println(msg111);
							String actual111="Your item was added";
							if (msg111.contains(actual111)) {
								rpt.createTest("Circuit City - Custom Rooms", "Shop now from Most loved is navigated to respective page");
								rpt.Pass("Shop now from Most loved is navigated to respective page");
								rpt.Category("Circuit City - Custom Rooms");
								String path = rpt.CaptureScreen(browser, "ValidMessage");
								rpt.imgPathPass(path);
								
							} else {
								rpt.createTest("Circuit City - Custom Rooms", " Shop now from Most loved NOT navigated to respective page");
								rpt.Fail(" Shop now from Most loved NOT navigated to respective page ");
								rpt.Category("Circuit City - Custom Rooms ");
								String path = rpt.CaptureScreen(browser, "InvalidMessage");
								rpt.imgPathFail(path);
							}
							Thread.sleep(2000);
							click("id=GotoCartButton2");
							Thread.sleep(2000);
							click("xpath=//a[@id='WC_OrderItemDetailsf_links_2_1']/b");
							Thread.sleep(2000);
							browser.navigate().back();
							Thread.sleep(2000);
							browser.navigate().back();
							Thread.sleep(2000);
							
							//TC 71
							
							click("xpath=//div[3]/div/div[2]/div/div/div/div/div[2]/div[7]/label");
							Thread.sleep(2000);
							jse.executeScript("window.scrollBy(0,90)");
							Thread.sleep(2000);
							//click("xpath=//li[3]/.//div[@class='compare_target compare_target_hidden']//label[contains(text(),'Compare')]");
							click("xpath=//div[3]/div/div[2]/div/div/div[2]/div/div[2]/div[7]/label");
							Thread.sleep(2000);
							click("xpath=(//a[contains(text(),'Compare')])[6]");
							Thread.sleep(2000);
							 String pagetitle1111111=getTitle();
								System.out.println(pagetitle1111111);
								Thread.sleep(2000);
								if (pagetitle1111111.contains("Circuit City - Compare Products")) {
									rpt.createTest("Circuit City - Custom Rooms", "Compare from Most loved is navigated to respective page");
									rpt.Pass("Compare from Most loved is navigated to respective page ");
									rpt.Category("Circuit City - Custom Rooms");
									String path = rpt.CaptureScreen(browser, "ValidMessage");
									rpt.imgPathPass(path);
									
								} else {
									rpt.createTest("Circuit City - Custom Rooms", " Compare from Most loved NOT navigated to respective page");
									rpt.Fail(" Compare from Most loved NOT navigated to respective page ");
									rpt.Category("Circuit City - Custom Rooms ");
									String path = rpt.CaptureScreen(browser, "InvalidMessage");
									rpt.imgPathFail(path);
								}
								Thread.sleep(2000);
								browser.navigate().back();
								Thread.sleep(2000);
								
							//TC 76
							click("link=Living room");
							Thread.sleep(2000);
							 String pagetitle11111111=getTitle();
								System.out.println(pagetitle11111111);
								Thread.sleep(2000);
								if (pagetitle11111111.contains("Starter Living Room | Circuit City")) {
									rpt.createTest("Circuit City - Custom Rooms", "Link from Featured Room is navigated to respective page");
									rpt.Pass("Link from Featured Room is navigated to respective page ");
									rpt.Category("Circuit City - Custom Rooms");
									String path = rpt.CaptureScreen(browser, "ValidMessage");
									rpt.imgPathPass(path);
									
								} else {
									rpt.createTest("Circuit City - Custom Rooms", "Link from Featured Room NOT navigated to respective page");
									rpt.Fail("Link from Featured Room NOT navigated to respective page ");
									rpt.Category("Circuit City - Custom Rooms ");
									String path = rpt.CaptureScreen(browser, "InvalidMessage");
									rpt.imgPathFail(path);
								}
								Thread.sleep(2000);
								browser.navigate().back();
								Thread.sleep(2000);
								
								
						
	}
	
}
