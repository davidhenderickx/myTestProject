package com.mysefrmwrk.mytestproject.testgames.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysefrmwrk.mytestproject.apps.TestGames;
import com.mysefrmwrk.mytestproject.frmwrkext.MyDriverManager;
import com.mysefrmwrk.mytestproject.frmwrkext.MyRunSettings;
import com.mysefrmwrk.sefrmwrk.helper.AssertExt;
import com.mysefrmwrk.sefrmwrk.helper.DriverManager;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;


public class TestLogin extends TestBase {

	private static String ERROR_INVALID_LOGIN = "Unable to log in with the given crzedentials. Please try again.";
	private static String ERROR_EMPTY = "Please fill in all the fields.";
	private static String HEADER_WELCOMEPAGE = "Welcome";
	
	private static Reporter reporter = new MasterReporter(MyRunSettings.class.getName());
	
	@BeforeClass
	public static void setupBeforeClass() {

	}

	@BeforeMethod
	public void setupBeforeTest() {
		
		DriverManager.getDriver().get(MyRunSettings.getBaseUrl());
		// logout before each test
		app.get().menuBarPage.logout();		
	}

	@AfterMethod
	public void teardownAfterTest() {
	}

	@AfterClass
	public static void teardownAfterClass() {
	}
	
	
	@Test
	public void validLogin(){
		app.get().loginPage.loginWith("admin", "superduper");
		AssertExt.assertTrue("Checking if welcome message exists", "Welcometext not shown", app.get().welcomePage.getWelcomeMessage().equals(HEADER_WELCOMEPAGE));
	}
	
	@Test
	public void invalidLogin_WrongUsername(){
		app.get().menuBarPage.logout();	
		app.get().loginPage.loginWith("doesnotexist", "test");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_INVALID_LOGIN, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_INVALID_LOGIN));
	}
	
	@Test
	public void invalidLogin_WrongPassword(){
		app.get().menuBarPage.logout();	
		app.get().loginPage.loginWith("admin", "test");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_INVALID_LOGIN, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_INVALID_LOGIN));
	}
	
	@Test
	public void invalidLogin_Empty(){
		app.get().loginPage.loginWith("", "");
		AssertExt.assertTrue("Checking if error message is displayed: " + ERROR_EMPTY, "Error message not shown", app.get().loginPage.getErrorMessage().equals(ERROR_EMPTY));
	}
}
