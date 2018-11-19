package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;




public class TestBase 
{
	public WebDriver driver;
	public Properties properties = new Properties();
	public String log4jPath = "Log4jProperties";
	public static final Logger log = Logger.getLogger(TestBase.class.getClass());
	
	public void testInitializer()
	{
		try
		{
			PropertyConfigurator.configure(log4jPath);
			FileInputStream fis = new FileInputStream("./config");
			properties.load(fis);
			String browser = properties.getProperty("browser");
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
				FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
				DesiredCapabilities desired = DesiredCapabilities.firefox();
				FirefoxOptions options = new FirefoxOptions();
				desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
				
				//Disabling Notifications
				FirefoxProfile ffprofile = new FirefoxProfile();
				ffprofile.setPreference("dom.webnotifications.enabled", false);
				
				System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
				driver = new FirefoxDriver(options);
			}
			log.info(browser+" is launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			String url = properties.getProperty("url");
			driver.get(url);
			log.info("Navigate to the url: "+url);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowser()
	{
		driver.quit();
	}

}
