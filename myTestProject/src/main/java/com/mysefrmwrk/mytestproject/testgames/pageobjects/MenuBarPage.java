package com.mysefrmwrk.mytestproject.testgames.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mysefrmwrk.sefrmwrk.helper.DriverManager;

public class MenuBarPage extends BasePage {
	
	public MenuBarPage() {
		super();
		long threadId = Thread.currentThread().getId();
		System.out.println("Thread # " + threadId + " is doing MenuBarPage");
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(how = How.LINK_TEXT, using = "Log out")
	private WebElement lnkLogout;
	
	@FindBy(how = How.LINK_TEXT, using = "Admin")
	private WebElement lnkAdmin;
	
	@FindBy(how = How.LINK_TEXT, using = "Stats")
	private WebElement lnkStats;
	
	@FindBy(how = How.LINK_TEXT, using = "Connections")
	private WebElement lnkConnections;
	
	@FindBy(how = How.ID, using = "crudConnection")
	private WebElement lnkConnection;
	
	public LoginPage logout(){
		lnkLogout.click();
		return new LoginPage();
	}

	public void admin() {
		lnkAdmin.click();		
	}

	public void stats() {
		lnkStats.click();		
	}

	public void connections() {
		lnkConnections.click();		
	}

	public void connection() {
		lnkConnection.click();		
	}
}
