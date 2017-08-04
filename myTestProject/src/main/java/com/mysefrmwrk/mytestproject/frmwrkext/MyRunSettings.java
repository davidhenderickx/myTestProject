package com.mysefrmwrk.mytestproject.frmwrkext;

import java.util.Properties;

import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyAppType;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowser;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyBrowserVersion;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyCloud;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyDriver;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyHost;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyLanguage;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyMobileDevice;
import com.mysefrmwrk.mytestproject.frmwrkext.MyEnums.MyOperatingSystem;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkAppType;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkBrowser;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkBrowserVersion;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkCloud;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkDriver;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkHost;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkLanguage;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkMobileDevice;
import com.mysefrmwrk.sefrmwrk.helper.Enums.FrmwrkOperatingSystem;
import com.mysefrmwrk.sefrmwrk.helper.Enums.LogType;
import com.mysefrmwrk.sefrmwrk.helper.Enums.OperatingSystem;
import com.mysefrmwrk.sefrmwrk.helper.RunSettings;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class MyRunSettings extends RunSettings {

	private static Reporter reporter = new MasterReporter(MyRunSettings.class.getName());

	public MyRunSettings() {
		super();
	}

	public static void init(Properties prop) {

		if (prop.containsKey("driver")) {
			setDriver(MyDriver.valueOf(prop.getProperty("driver")));
		}
		if (prop.containsKey("host")) {
			setHost(MyHost.valueOf(prop.getProperty("host")));
		}
		if (prop.containsKey("operatingSystem")) {
			setOperatingSystem(MyOperatingSystem.valueOf(prop.getProperty("operatingSystem")));
		}
		if (prop.containsKey("appType")) {
			setAppType(MyAppType.valueOf(prop.getProperty("appType")));
		}
		if (prop.containsKey("mobileDevice")) {
			setMobileDevice(MyMobileDevice.valueOf(prop.getProperty("mobileDevice")));
		}
		if (prop.containsKey("browser")) {
			setBrowser(MyBrowser.valueOf(prop.getProperty("browser")));
		}
		if (prop.containsKey("browserVersion")) {
			setBrowserVersion(MyBrowserVersion.valueOf(prop.getProperty("browserVersion")));
		}
		if (prop.containsKey("cloud")) {
			setCloud(MyCloud.valueOf(prop.getProperty("cloud")));
		}
		if (prop.containsKey("gridUrl")) {
			setGridUrl(prop.getProperty("gridUrl"));
		}
		if (prop.containsKey("appiumUrl")) {
			setAppiumUrl(prop.getProperty("appiumUrl"));
		}
		if (prop.containsKey("appPath")) {
			setAppPath(prop.getProperty("appPath"));
		}
		if (prop.containsKey("baseUrl")) {
			setBaseUrl(prop.getProperty("baseUrl"));
		}
		if (prop.containsKey("language")) {
			setLanguage(MyLanguage.valueOf(prop.getProperty("language")));
		}
		if (prop.containsKey("wait")) {
			setWait(Integer.parseInt(prop.getProperty("wait")));
		}
		if (prop.containsKey("waitFor")) {
			setWaitFor(Integer.parseInt(prop.getProperty("waitFor")));
		}
		if (prop.containsKey("waitForLong")) {
			setWaitForLong(Integer.parseInt(prop.getProperty("waitForLong")));
		}
		if (prop.containsKey("retries")) {
			setRetries(Integer.parseInt(prop.getProperty("retries")));
		}
		if (prop.containsKey("eventFiringDriver")) {
			setEventFiringDriver(Boolean.valueOf(prop.getProperty("eventFiringDriver")));
		}
		if (prop.containsKey("sauceLabsUsername")) {
			setSauceLabsUsername(prop.getProperty("sauceLabsUsername"));
		}
		if (prop.containsKey("sauceLabsAccessKey")) {
			setSauceLabsAccessKey(prop.getProperty("sauceLabsAccessKey"));
		}
		if (prop.containsKey("sauceLabsUrl")) {
			setSauceLabsUrl(prop.getProperty("sauceLabsUrl"));
		}
		if (prop.containsKey("chromeDriverPath")) {
			setChromeDriverPath(prop.getProperty("chromeDriverPath"));
		}
		if (prop.containsKey("ieDriverPath")) {
			setIEDriverPath(prop.getProperty("ieDriverPath"));
		}
		if (prop.containsKey("firefoxDriverPath")) {
			setFireFoxDriverPath(prop.getProperty("firefoxDriverPath"));
		}
		if (prop.containsKey("geckoDriverPath")) {
			setGeckoDriverPath(prop.getProperty("geckoDriverPath"));
		}
		if (prop.containsKey("edgeDriverPath")) {
			setGeckoDriverPath(prop.getProperty("edgeDriverPath"));
		}
		if (prop.containsKey("reportLog4JName")) {
			setReportLog4JName(prop.getProperty("reportLog4JName"));
		}
		if (prop.containsKey("reportLog4JFolder")) {
			setReportLog4JFolder(prop.getProperty("reportLog4JFolder"));
		}
		if (prop.containsKey("reportLog4JScreenshot")) {
			setReportLog4JScreenshot(Boolean.valueOf(prop.getProperty("reportLog4JScreenshot")));
		}
		if (prop.containsKey("reportExtentName")) {
			setReportExtentName(prop.getProperty("reportExtentName"));
		}
		if (prop.containsKey("reportExtentFolder")) {
			setReportExtentFolder(prop.getProperty("reportExtentFolder"));
		}
		if (prop.containsKey("reportExtentScreenshot")) {
			setReportExtentScreenshot(Boolean.valueOf(prop.getProperty("reportExtentScreenshot")));
		}
	}

}