package com.mysefrmwrk.mytestproject.testgames.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mysefrmwrk.mytestproject.frmwrkext.MyPageObjectActions;
import com.mysefrmwrk.sefrmwrk.helper.DriverManager;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class BasePage extends MyPageObjectActions {
	
	private static Reporter reporter = new MasterReporter(BasePage.class.getName());
	
	@FindBy(how = How.XPATH, using="//div[@class='loading-wrapper']")
	private WebElement wrapper;
	
	@FindBy(how = How.XPATH, using = "//html")
	private WebElement page;
	
	public BasePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}


	public WebElement getPage() {
		return page;
	}
	
	protected void waitForLoadingWrapper(){
		waitForElementToAppearAndDisappear(wrapper, 1, 5);
	}
	
}
