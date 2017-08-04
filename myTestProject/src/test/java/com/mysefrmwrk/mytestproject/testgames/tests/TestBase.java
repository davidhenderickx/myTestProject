package com.mysefrmwrk.mytestproject.testgames.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysefrmwrk.mytestproject.apps.TestGames;
import com.mysefrmwrk.mytestproject.frmwrkext.MyDriverManager;
import com.mysefrmwrk.mytestproject.frmwrkext.MyRunSettings;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyAppType;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowser;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowserVersion;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyCloud;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyDriver;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyHost;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyLanguage;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyMobileDevice;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyOperatingSystem;
import com.mysefrmwrk.sefrmwrk.base.TestBaseFrmwrk;
import com.mysefrmwrk.sefrmwrk.helper.ExceptionHandler;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Driver;
import com.mysefrmwrk.sefrmwrk.reports.Log4JReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;
import com.mysefrmwrk.sefrmwrk.reports.log4jreports.Log4JUtils;

public abstract class TestBase extends TestBaseFrmwrk implements Config {

	protected static ThreadLocal<TestGames> app  = new ThreadLocal<TestGames>();

	@BeforeSuite
	public static void beforeSuite() {
		// Set the runsettings
		setRunSettings();
		
		// Need to reconfigure the log4j settings
		//Log4JUtils logUtil = new Log4JUtils();
		//logUtil.updateLog4jConfiguration();

	}
	
	@BeforeMethod
	public static void beforeMethod(Method m) {

		// Because the runSettings are threadsafe, the runsettings need to be
		setRunSettings();
		
		MyDriverManager.setDriver(MyRunSettings.getDriver());
     	app.set(new TestGames());

	}

	@AfterMethod
	public static void afterMethod(Method m) {
		MyDriverManager.gracefulQuit();
	}


	@AfterSuite
	public static void afterSuite() {
		MyDriverManager.gracefulQuit();
	}

	
	
	
	
	/**
	 * This method will contain the logic in order to set the correct initial
	 * properties 1. If a propertiesfile is set, update the RunSettings with
	 * those values 2. If variables in Config.class interface are defined,
	 * update these values in RunSettings 3. Use the default variable values of
	 * the runsettings.
	 */
	public static void setRunSettings() {

		if (!propertiesFile.isEmpty()) {

			// log.testDebug("Propertiesfile has been defined in Config.java: "
			// + propertiesFile);
			InputStream in = null;

			// Propertiesfile has been defined
			if (propertiesFile.contains("\\") || propertiesFile.contains("/")) {
				// There is a path available
				// log.testDebug("Opening the properties file at an absolute
				// path.");
				try {
					in = new FileInputStream(propertiesFile);
				} catch (FileNotFoundException e) {
					new ExceptionHandler("Error while opening the properties file: " + propertiesFile, e);
				}
			} else if (propertiesFile.contains(".properties")) {
				// Updating the runSettings with a .properties file
				// log.testDebug("Opening the properties file from the
				// resources.");
				in = TestBase.class.getClassLoader().getResourceAsStream(propertiesFile);
			} else {
				// log.testDebug("Opening the default properties file
				// 'project.properties' from the resources.");
				in = TestBase.class.getClassLoader().getResourceAsStream("project.properties");
			}

			Properties prop = new Properties();
			try {
				prop.load(in);
			} catch (IOException e) {
				new ExceptionHandler("Error while loading the properties.", e);
			}
			MyRunSettings.init(prop);

		} else {
			// No propertiesfile has been defined
			if (!driver.isEmpty()) {
				MyRunSettings.setDriver(MyDriver.valueOf(driver));
			}
			if (!host.isEmpty()) {
				MyRunSettings.setHost(MyHost.valueOf(host));
			}
			if (!operatingSystem.isEmpty()) {
				MyRunSettings.setOperatingSystem(MyOperatingSystem.valueOf(operatingSystem));
			}
			if (!appType.isEmpty()) {
				MyRunSettings.setAppType(MyAppType.valueOf(appType));
			}
			if (!mobileDevice.isEmpty()) {
				MyRunSettings.setMobileDevice(MyMobileDevice.valueOf(mobileDevice));
			}
			if (!browser.isEmpty()) {
				MyRunSettings.setBrowser(MyBrowser.valueOf(browser));
			}
			if (!browserVersion.isEmpty()) {
				MyRunSettings.setBrowserVersion(MyBrowserVersion.valueOf(browserVersion));
			}
			if (!cloud.isEmpty()) {
				MyRunSettings.setCloud(MyCloud.valueOf(cloud));
			}
			if (!gridUrl.isEmpty()) {
				MyRunSettings.setGridUrl(gridUrl);
			}
			if (!appiumUrl.isEmpty()) {
				MyRunSettings.setAppiumUrl(appiumUrl);
			}
			if (!appPath.isEmpty()) {
				MyRunSettings.setAppPath(appPath);
			}
			if (!baseUrl.isEmpty()) {
				MyRunSettings.setBaseUrl(baseUrl);
			}
			if (!language.isEmpty()) {
				MyRunSettings.setLanguage(MyLanguage.valueOf(language));
			}
			if (!wait.isEmpty()) {
				MyRunSettings.setWait(Integer.valueOf(wait));
			}
			if (!waitFor.isEmpty()) {
				MyRunSettings.setWaitFor(Integer.valueOf(waitFor));
			}
			if (!waitForLong.isEmpty()) {
				MyRunSettings.setWaitForLong(Integer.valueOf(waitForLong));
			}
			if (!retries.isEmpty()) {
				MyRunSettings.setRetries(Integer.valueOf(retries));
			}
			if (!eventFiringDriver.isEmpty()) {
				MyRunSettings.setEventFiringDriver(Boolean.valueOf(eventFiringDriver));
			}
			if (!sauceLabsUsername.isEmpty()) {
				MyRunSettings.setSauceLabsUsername(sauceLabsUsername);
			}
			if (!sauceLabsAccessKey.isEmpty()) {
				MyRunSettings.setSauceLabsAccessKey(sauceLabsAccessKey);
			}
			if (!sauceLabsUrl.isEmpty()) {
				MyRunSettings.setSauceLabsUrl(sauceLabsUrl);
			}
			if (!chromeDriverPath.isEmpty()) {
				MyRunSettings.setChromeDriverPath(chromeDriverPath);
			}
			if (!ieDriverPath.isEmpty()) {
				MyRunSettings.setIEDriverPath(ieDriverPath);
			}
			if (!firefoxDriverPath.isEmpty()) {
				MyRunSettings.setFireFoxDriverPath(firefoxDriverPath);
			}
			if (!geckoDriverPath.isEmpty()) {
				MyRunSettings.setGeckoDriverPath(geckoDriverPath);
			}
			if (!edgeDriverPath.isEmpty()) {
				MyRunSettings.setEdgeDriverPath(edgeDriverPath);
			}
			if (!reportLog4JName.isEmpty()) {
				MyRunSettings.setReportLog4JName(reportLog4JName);
			}
			if (!reportLog4JFolder.isEmpty()) {
				MyRunSettings.setReportLog4JFolder(reportLog4JFolder);
			}
			if (!reportLog4JScreenshot.isEmpty()) {
				MyRunSettings.setReportLog4JScreenshot(Boolean.valueOf(reportLog4JScreenshot));
			}
			if (!reportExtentName.isEmpty()) {
				MyRunSettings.setReportExtentName(reportExtentName);
			}
			if (!reportExtentFolder.isEmpty()) {
				MyRunSettings.setReportExtentFolder(reportExtentFolder);
			}
			if (!reportExtentScreenshot.isEmpty()) {
				MyRunSettings.setReportExtentScreenshot(Boolean.valueOf(reportExtentScreenshot));
			}

		}
	}

}