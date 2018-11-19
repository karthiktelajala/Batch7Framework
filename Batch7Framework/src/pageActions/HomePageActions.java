package pageActions;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObjects;

public class HomePageActions extends HomePageObjects
{
	public HomePageActions(WebDriver driver) 
	{
		super(driver);
	}

	public void clickAdmin()
	{
		menuAdmin.click();
	}
}
