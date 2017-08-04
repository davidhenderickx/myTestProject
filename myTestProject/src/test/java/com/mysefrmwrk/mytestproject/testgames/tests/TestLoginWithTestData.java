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


public class TestLoginWithTestData extends TestBase {

	private static String ERROR_INVALID_LOGIN = "Unable to log in with the given credentials. Please try again.";
	private static String ERROR_EMPTY = "Please fssill in all the fields.";
	private static String HEADER_WELCOMEPAGE = "Welcome";
	
	private static Reporter reporter = new MasterReporter(TestLoginWithTestData.class.getName());
	
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
	
	
	@Test(enabled = true , groups = { }, dataProvider = "loginValid", dataProviderClass = TestDataProvider.class)
	public void validLogin(final String username, final String password){
		app.get().loginPage.loginWith("admin", "superduper");
		AssertExt.assertTrue("Checking if welcome message exists", "Welcometext not shown", app.get().welcomePage.getWelcomeMessage().equals(HEADER_WELCOMEPAGE));
	}
	
	@Test(enabled = true , groups = { }, dataProvider = "loginInvalidUserName", dataProviderClass = TestDataProvider.class)
	public void invalidLogin_WrongUsername(final String username, final String password){
		app.get().loginPage.loginWith("doesnotexist", "test");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_INVALID_LOGIN, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_INVALID_LOGIN));
	}
	
	@Test(enabled = true , groups = { }, dataProvider = "loginInvalidPassword", dataProviderClass = TestDataProvider.class)
	public void invalidLogin_WrongPassword(final String username, final String password){
		app.get().loginPage.loginWith("admin", "test");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_INVALID_LOGIN, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_INVALID_LOGIN));
	}
	
	@Test(enabled = true , groups = { }, dataProvider = "loginEmpty", dataProviderClass = TestDataProvider.class)
	public void invalidLogin_Empty(final String username, final String password){
		app.get().loginPage.loginWith("", "");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_EMPTY, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_EMPTY));
	}
}
