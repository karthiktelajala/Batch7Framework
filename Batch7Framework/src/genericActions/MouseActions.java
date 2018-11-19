package genericActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public static Actions act;
	public static void mouseHover(WebDriver driver, WebElement ele)
	{
		act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement dragSrc,WebElement dropSrc)
	{
		act = new Actions(driver);
		act.dragAndDrop(dragSrc, dropSrc).build().perform();
	}
	
	public static void rightMouseClick(WebDriver driver, WebElement ele)
	{
		act = new Actions(driver);
		act.contextClick(ele).build().perform();
	}
	
	public static void doubleClick(WebDriver driver, WebElement ele)
	{
		act = new Actions(driver);
		act.doubleClick(ele).build().perform();
	}

}
