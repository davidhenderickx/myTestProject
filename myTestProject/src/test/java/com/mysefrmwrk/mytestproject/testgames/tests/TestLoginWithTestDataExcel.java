package com.mysefrmwrk.mytestproject.testgames.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysefrmwrk.mytestproject.testgames.testdata.TestDataProvider;
import com.mysefrmwrk.sefrmwrk.helper.AssertExt;
import com.mysefrmwrk.sefrmwrk.helper.DriverManager;
import com.mysefrmwrk.sefrmwrk.helper.PropertiesCache;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class TestLoginWithTestDataExcel extends TestBase {

	private static String ERROR_INVALID_LOGIN = "Unable to log in with the given credentials. Please try again.";
	private static String ERROR_EMPTY = "Please fill in all the fields.";
	private static String HEADER_WELCOMEPAGE = "Welcome";

	private static Reporter reporter = new MasterReporter(TestLoginWithTestDataExcel.class.getName());

	@BeforeClass
	public static void setupBeforeClass() {

	}

	@BeforeMethod
	public void setupBeforeTest() {
		DriverManager.getDriver().get(PropertiesCache.getInstance().getProperty("testgames.url"));
		// logout before each test
		app.get().menuBarPage.logout();
	}

	@AfterMethod
	public void teardownAfterTest() {

	}

	@AfterClass
	public static void teardownAfterClass() {
	}

	@Test(enabled = true, groups = {}, dataProvider = "logins", dataProviderClass = TestDataProvider.class)
	public void Login(final String testname, final String username, final String password, final boolean welcomePage,
			final String message) {
		app.get().loginPage.loginWith(username, password);
		if (welcomePage) {
			AssertExt.assertTrue("Checking if welcome message exists", "Welcometext not shown",
					app.get().welcomePage.getWelcomeMessage().equals(message));
		} else {
			AssertExt.assertTrue("Checking if error message is displayed: " + message,
					"Error message not shown", app.get().loginPage.getErrorMessage().equals(message));
		}
	}

}
