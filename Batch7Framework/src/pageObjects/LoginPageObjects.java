package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects 
{
	@FindBy(id="txtUsername")
	public WebElement txtUsername;
	
	@FindBy(name="txtPassword")
	public WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin;
	
	@FindBy(xpath="//span[text()='Invalid credentials']")
	public WebElement msgErrorLogin;	
	
	@FindBy(xpath="//img[@alt='LinkedIn OrangeHRM group']")
	public WebElement lnkLinkedIn;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
