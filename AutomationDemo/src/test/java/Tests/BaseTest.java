package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.HomePage;
import Pages.LoginPage;
import Constants.Constants;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	
	@BeforeClass
	@Parameters("browserName")
	public void setUp(@Optional("Chrome")String browserName)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",Constants.CC_DRIVER_PATH);
			driver=new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("Firefox")){
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			System.setProperty("webdriver.gecko.driver", Constants.FF_DRIVER_PATH);
			driver = new FirefoxDriver();
		}
	}
	
	@BeforeMethod
	public void LaunchURL()
	{
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
