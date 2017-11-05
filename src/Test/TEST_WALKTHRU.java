package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TEST_WALKTHRU {
	WebDriver wd;
	BrowserFactory brw = new BrowserFactory();
	Browser br = new Browser();
	
	@Test
	public void chkTest()throws Exception
	{
		brw.getBrowser("FF", "www.royalcyber.com");
		
		Thread.sleep(3000);
		br.click("xpath=.//*[@id='identifierId']");
		wd.findElement(By.xpath(".//*[@id='identifierId']")).click();
	
		
	}

}
