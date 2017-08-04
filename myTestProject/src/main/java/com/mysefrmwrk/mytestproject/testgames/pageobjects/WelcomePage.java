package com.mysefrmwrk.mytestproject.testgames.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mysefrmwrk.sefrmwrk.helper.DriverManager;


public class WelcomePage extends BasePage {
	
	public WelcomePage() {
		super();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='welcome']/h1")
	private WebElement txtWelcome;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Show me']")
	private WebElement btnBear;
	
	@FindBy(how = How.ID, using = "bear")
	private WebElement imgBear;

	public String getWelcomeMessage() {
		if (txtWelcome.isDisplayed()) {
			return txtWelcome.getText();
		}
		return "";
	}
	
	public boolean isDisplayed(){
		return getWelcomeMessage() != "";
	}
	
	public void displayTheBear(){
		this.btnBear.click();
	}
	
	public boolean isTheBearDisplayed(){
		return imgBear.isDisplayed();
	}
}
