package Test;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SEARCH extends Browser
{
	public WebDriver browser = BrowserFactory.getBrowser("Browser","url");
	//WebDriver driver=new FirefoxDriver();
	
	public void execute_Alltestcases()throws Exception
	{
		verify_searchPageUI();
		verify_nosearch();
		alreadySearched();
		searchWithPname();
		searchWithItemNo();
		searchWithKeyword();
		searchWithDescription();
		searchWithCategoryname();
		//verifyDiscontinuedProducts();
		searchRelevance();
	    searchResultPage();
		verifyinvalidInput();
		verifySpecialCharacter();
		ConfinedSearch();
		spellChecker();
		categoryPage();
		//advancedSearch();
		typeAhead();
		sortingSearch();
		itemPerPage();
		
	}
	
	public void verify_searchPageUI()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
        Thread.sleep(2000);
	}
	public void verify_nosearch()throws Exception
	{

        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","");
        Thread.sleep(2000);

	}
	public void alreadySearched()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
        Thread.sleep(4000);


	}
	public void searchWithPname()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);


    }
	public void searchWithItemNo()throws Exception
	{
	    click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","1200");
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);



	}
	public void searchWithKeyword()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","len");	
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);


	
	}
	public void searchWithDescription()throws Exception
	{
        click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","speaker");	
	   click("xpath=//*[@id='autoSelectOption_0']");	
       Thread.sleep(4000);


	}
	public void searchWithCategoryname()throws Exception
	{
     click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","TV");	
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);

		

	}
	/*public void verifyDiscontinuedProducts()throws Exception
	{
		click("xpath=//*[@id='searchBox']");
		

	}*/
	
	public void searchRelevance()throws Exception
	{
       click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","speaker");	
	   click("xpath=//*[@id='autoSelectOption_0']");
       Thread.sleep(4000);


	}
	
	public void searchResultPage()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");	
		   click("xpath=//*[@id='autoSelectOption_0']");
	        Thread.sleep(4000);

	}
	public void verifyinvalidInput()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","!@#");
	        Thread.sleep(4000);

			/*Boolean errorMsg=findTheElement("xpath=//*[@id='PageHeading_5_-3014_2306']/h1").isDisplayed();
			 if(errorMsg)
	         {
	           System.out.println("Message Displayed:"+ errorMsg);
			//test = rpt.createTest("Circuit_City-Search, CIRCUIT CITY - Search :Error Message Displayed for invalid input:", errorMsg);

	           
	          }
	        else
	        {
	           System.out.println("Error Message NOT Displayed");
				//test = rpt.createTest("Circuit_City-Search, CIRCUIT CITY - Search :Error Message NOT Displayed for invalid input");

	        	
	         }*/

	}
	public void verifySpecialCharacter()throws Exception
	{
		 click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
			sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","***");	
	        Thread.sleep(4000);

			/*Boolean errorMsg=findTheElement("xpath=//*[@id='errorPage']/h1").isDisplayed();
			 if(errorMsg)
	         {
	           System.out.println("Message Displayed:"+ errorMsg);
	           //test = extent.createTest("CIRCUIT CITY - Search :Error Message Displayed for special character:", errorMsg);

	          }
	        else
	        {
	           System.out.println("Error Message NOT Displayed");
	           //test = extent.createTest("CIRCUIT CITY - Search :Error Message NOT Displayed for special character");

	         }*/

	}
	public void ConfinedSearch()throws Exception
	{

		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);

		

	}
	public void spellChecker()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenov");
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);

	}
	public void categoryPage()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","monitor");
		click("xpath=//*[@id='autoSelectOption_0']");
        Thread.sleep(4000);


	}
	/*public void advancedSearch()throws Exception
	{
		click("xpath=//*[@id='searchBox']");
		

	}*/
	public void typeAhead()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","sam");	
        Thread.sleep(4000);

	}
	public void sortingSearch()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","lenovo");
		click("xpath=//*[@id='autoSelectOption_0']");
		click("xpath=//*[@id='orderBy_6_-3011_2310-button']");
		click("xpath=//*[@id='orderBy_6_-3011_2310-button']");
        Thread.sleep(4000);

	}
	public void itemPerPage()throws Exception
	{
		click("xpath=//*[@id='SimpleSearchForm_SearchTerm']");
		sendKeys("xpath=//*[@id='SimpleSearchForm_SearchTerm']","samsung");
		click("xpath=//*[@id='autoSelectOption_0']");
		click("xpath=//*[@id='pageSize_6_-3011_2310-button']");
		click("xpath=//*[@id='pageSize_6_-3011_2310-button']");
        Thread.sleep(4000);

	}
	
	
	
	
}
