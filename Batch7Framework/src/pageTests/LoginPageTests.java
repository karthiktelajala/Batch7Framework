package pageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;
import pageActions.LoginPageActions;

public class LoginPageTests extends TestBase
{
	LoginPageActions loginPageActions;
	
	@BeforeMethod
	public void inializeTest()
	{
		testInitializer();
	}
	
	@Test
	public void LoginWithValidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		loginPageActions.login("Admin", "admin123");
		String expMsg = "OrangeHRM";
		String actMsg = loginPageActions.getLoginPageTitle(driver);
		Assert.assertEquals(actMsg, expMsg);
	}
	
	@Test
	public void LoginWithInvalidCredentials()
	{
		loginPageActions = new LoginPageActions(driver);
		loginPageActions.login("Admin", "admin");
		String expError = "Invalid credentials";
		String actError = loginPageActions.getErrorLoginMessage();
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void testClosure()
	{
		closeBrowser();
	}

}
