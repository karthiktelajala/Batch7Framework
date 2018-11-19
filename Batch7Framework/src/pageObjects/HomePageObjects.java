package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects 
{
	@FindBy(xpath="//b[text()='Admin']")
	public WebElement menuAdmin;
	
	public HomePageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
