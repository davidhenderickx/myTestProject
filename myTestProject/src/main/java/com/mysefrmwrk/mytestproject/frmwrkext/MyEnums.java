package com.mysefrmwrk.mytestproject.frmwrkext;

import com.mysefrmwrk.sefrmwrk.helper.Enums;

public class MyEnums extends Enums {
	
	public static enum MyDriver implements Driver {
		CHROME, FIREFOX
	}
	
	public static enum MyHost implements Host {
		LOCALHOST
	}

	public static enum MyOperatingSystem implements OperatingSystem {
		WINDOWS_7
	}

	public static enum MyAppType implements AppType {
		BROWSER
	}

	public static enum MyMobileDevice implements MobileDevice {
		UNKOWN
	}

	public static enum MyBrowser implements Browser {
		CHROME, FIREFOX
	}

	public static enum MyBrowserVersion implements BrowserVersion {
		UNKOWN
	}
	
	public static enum MyCloud implements Cloud {
		SAUCELABS
	}

	public static enum MyLanguage implements Language {
		NL, FR
	}
	

}
