package com.mysefrmwrk.mytestproject.frmwrkext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;

import com.mysefrmwrk.sefrmwrk.helper.DriverManager;
import com.mysefrmwrk.sefrmwrk.helper.Enums.Driver;
import com.mysefrmwrk.sefrmwrk.helper.Enums.LogType;
import com.mysefrmwrk.sefrmwrk.helper.RunSettings;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class MyDriverManager extends DriverManager {
	
	private static Reporter reporter = new MasterReporter(MyDriverManager.class.getName());

	

	public static WebDriver getDriver(Driver driver) {

		switch (driver.toString()) {

		case "CHROME":
			setChromeDriverProperty(RunSettings.getChromeDriverPath());
			return getChromeDriver();
		case "FIREFOX": 
			setFirefoxDriverProperty(RunSettings.getFireFoxDriverPath());
			return getFirefoxDriver();
		default:
			reporter.log(LogType.ERROR, "Driver " + driver.toString() + " is not implemented");
		}
		return null;

	}

	/**
	 * Creates a chromedriver for this specific project
	 * 
	 * @return chromedriver
	 */
	protected static WebDriver getChromeDriver() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-geolocation");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap = cap.merge(DesiredCapabilities.chrome());

		return ThreadGuard.protect(new ChromeDriver(cap));

	}

	
}
