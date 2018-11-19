package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects
{
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}
	
//	public void enterUserName(String username)
//	{
//		txtUsername.sendKeys(username);
//	}
//	
//	public void enterPassword(String password)
//	{
//		txtPassword.sendKeys(password);
//	}
//	
//	public void clickLoignButton()
//	{
//		btnLogin.click();
//	}
	
	public void login(String username, String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getErrorLoginMessage()
	{
		return msgErrorLogin.getText();
	}
	
	public String getLoginPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public void clickLinkedIn()
	{
		lnkLinkedIn.click();
	}
}
