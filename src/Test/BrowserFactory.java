package Test;

/**
 * Functional Decomposition Framework
 *  Mahesh NVS 30/5/2016
 *
 * 
 */
import java.io.File;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	public static WebDriver browser = null;
	
	public static WebDriver getBrowser(String browserName) {

		if (browser == null) {
			try {

//				String browserName = CommonUtils.readFromConfig("Browser");

				if ("FF".equalsIgnoreCase(browserName)) {
					
					browser = loadFireFoxDriver();
				} else if ("IE".equalsIgnoreCase(browserName)) {
					browser = loadIEDriver();
				} else if ("chrome".equalsIgnoreCase(browserName)) {
					browser = loadChromeDriver();
				}				
			} catch (Exception exception) {
			}

		}

		return browser;
	}

	
	private static RemoteWebDriver loadFireFoxDriver() throws Exception {

		String loadffProfile = CommonUtils.readFromConfig("loadffProfile");
		RemoteWebDriver remoteDriver = null;
		FirefoxProfile profile = null;

		if ("true".equalsIgnoreCase(loadffProfile)) {
			String profilePath = CommonUtils
					.readFromConfig("FIREFOXPROFILEDIR");
			File profileDir = new File(profilePath);
			profile = new FirefoxProfile(profileDir);
			profile.setAcceptUntrustedCertificates(false);
		}

		if ("true".equalsIgnoreCase(loadffProfile)) {
			remoteDriver = new FirefoxDriver(profile);
		} else {
			System.setProperty("webdriver.gecko.driver", "C:\\CI_CD_CT\\Browser_Executables\\geckodriver.exe");
		    browser  = new FirefoxDriver();	
		    SAIB_Register chkLogin = new SAIB_Register();
		    chkLogin.chkLogin();
		}
		return remoteDriver;

	}

	
	private static RemoteWebDriver loadIEDriver() throws Exception {

		RemoteWebDriver remoteDriver = null;
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

		System.setProperty("webdriver.ie.driver",
				"C:\\CI_CD_CT\\Browser_Executables\\IEDriverServer.exe");
		remoteDriver = new InternetExplorerDriver(capabilities);
			
	    SAIB_Register chkLogin = new SAIB_Register();
	    chkLogin.chkLogin();
		
		return remoteDriver;

	}

	

	private static RemoteWebDriver loadChromeDriver() throws Exception {

		RemoteWebDriver remoteDriver = null;
		String hostOS = CommonUtils.getHostOperatingSystem();

		if (hostOS.equalsIgnoreCase("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/browser_exe/chrome/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\CI_CD_CT\\Browser_Executables\\chromedriver.exe");
		}		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
		remoteDriver = new ChromeDriver(capabilities);
					
	    SAIB_Register chkLogin = new SAIB_Register();
	    chkLogin.chkLogin();
		return remoteDriver;
	}

}
