package com.mysefrmwrk.mytestproject.testgames.tests;

import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyAppType;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowser;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowserVersion;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyDriver;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyHost;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyLanguage;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyMobileDevice;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyOperatingSystem;
import com.mysefrmwrk.sefrmwrk.helper.Enums.AppType;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Browser;
import com.mysefrmwrk.sefrmwrk.helper.Enums.BrowserVersion;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Cloud;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Driver;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkCloud;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Host;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Language;
import com.mysefrmwrk.sefrmwrk.helper.Enums.MobileDevice;
import com.mysefrmwrk.sefrmwrk.helper.Enums.OperatingSystem;

public interface Config {

	final String driver = System.getProperty("driver", "");

	final String host = System.getProperty("host", "");

	final String operatingSystem = System.getProperty("operatingSystem", "");

	final String appType = System.getProperty("appType", "");

	final String mobileDevice = System.getProperty("mobileDevice", "");

	final String browser = System.getProperty("browser", "");

	final String browserVersion = System.getProperty("browserVersion", "");

	final String cloud = System.getProperty("cloud", "");

	final String gridUrl = System.getProperty("gridUrl", "");

	final String appiumUrl = System.getProperty("appiumUrl", "");

	final String appPath = System.getProperty("appPath", "");

	final String baseUrl = System.getProperty("baseUrl", "");

	final String language = System.getProperty("language", "");

	final String wait = System.getProperty("wait", "");

	final String waitFor = System.getProperty("waitFor", "");

	final String waitForLong = System.getProperty("waitForLong", "");

	final String retries = System.getProperty("retries", "");

	final String eventFiringDriver = System.getProperty("driverEventFiring", "");

	final String sauceLabsUsername = System.getProperty("sauceLabsUsername", "");

	final String sauceLabsAccessKey = System.getProperty("sauceLabsAccessKey", "");

	final String sauceLabsUrl = System.getProperty("sauceLabsUrl", "");

	final String chromeDriverPath = System.getProperty("chromeDriverPath", "");
	
	final String ieDriverPath = System.getProperty("ieDriverPath", "");
	
	final String firefoxDriverPath = System.getProperty("firefoxDriverPath", "");
	
	final String geckoDriverPath = System.getProperty("geckoDriverPath", "");
	
	final String edgeDriverPath = System.getProperty("edgeDriverPath", "");

	final String reportLog4JName = System.getProperty("reportLog4JName", "");
	
	final String reportLog4JFolder = System.getProperty("reportLog4JFolder", "");
	
	final String reportLog4JScreenshot = System.getProperty("reportLog4JScreenshot", "");
	
	final String reportExtentName = System.getProperty("reportExtentName", "");
	
	final String reportExtentFolder = System.getProperty("reportExtentFolder", "");
	
	final String reportExtentScreenshot = System.getProperty("reportExtentScreenshot", "");

	final String propertiesFile = System.getProperty("propertiesFile", "project.properties");

}
