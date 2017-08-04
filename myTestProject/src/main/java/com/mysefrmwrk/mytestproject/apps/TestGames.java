package com.mysefrmwrk.mytestproject.apps;

import com.mysefrmwrk.mytestproject.testgames.pageobjects.LoginPage;
import com.mysefrmwrk.mytestproject.testgames.pageobjects.MenuBarPage;
import com.mysefrmwrk.mytestproject.testgames.pageobjects.WelcomePage;
import com.mysefrmwrk.sefrmwrk.base.BaseApp;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class TestGames extends BaseApp {

	public LoginPage loginPage;
	public MenuBarPage menuBarPage;
	public WelcomePage welcomePage;

	private Reporter reporter = new MasterReporter(TestGames.class.getName());

	public TestGames() {

		super();	
		
		loginPage = new LoginPage();
		menuBarPage = new MenuBarPage();
		welcomePage = new WelcomePage();
		

	}
}