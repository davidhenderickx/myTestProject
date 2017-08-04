package com.mysefrmwrk.mytestproject.testgames.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mysefrmwrk.sefrmwrk.helper.DriverManager;
import com.mysefrmwrk.sefrmwrk.helper.RunSettings;


public class LoginPage extends BasePage{
	
	public LoginPage() {
		super();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(how = How.ID, using="username")
	private WebElement fldUserName;
	
	@FindBy(how = How.ID, using="password")
	private WebElement fldPassword;
	
	@FindBy(how = How.XPATH, using="//td[@onclick='login()']")
	private WebElement btnLogin;
	
	@FindBy(how = How.NAME, using="language")
	private WebElement cboLanguage;
	
    @FindBy(how = How.XPATH, using = "//*[@id='errors']/p")
    private WebElement lblError;
    
    /**
	 * A check if you are on the correct page. The method will check if the
	 * element is shown within 5 seconds.
	 * 
	 * @return
	 */
	public boolean isShown() {
		return waitForElementToBeVisible(btnLogin, RunSettings.getWaitFor());
	}
	
	
	public WelcomePage loginWith(String username, String password){
		clearAndType(fldUserName, username);
		clearAndType(fldPassword, password);
		click(btnLogin);
		return new WelcomePage();
	}
	
	public void setLanguageTo(String language){
		new Select(cboLanguage).selectByVisibleText(language);
	}

	public String getErrorMessage() {
		return this.lblError.getText();
	}
	
	public void loginAsAdmin(){
		loginWith("admin", "superduper");
	}
	
	
}
