package pageTests;

import org.testng.annotations.Test;

import basePackage.TestBase;
import genericActions.Screenshot;
import pageActions.HomePageActions;
import pageActions.LoginPageActions;

public class HomePageTests extends TestBase
{
	LoginPageActions loginPageAction;
	HomePageActions homePageActions;
	@Test
	public void verifyAdminPage()
	{
		testInitializer();
		Screenshot.captureScreenshot(driver, "LoginPage");
		loginPageAction = new LoginPageActions(driver);
		homePageActions = new HomePageActions(driver);
		loginPageAction.login("Admin","admin123");
		Screenshot.captureScreenshot(driver, "HomePage");
		homePageActions.clickAdmin();	
		Screenshot.captureScreenshot(driver, "AdminPage");	
	}
}
