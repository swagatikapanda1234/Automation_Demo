package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id="userNavigationLabel")
	private WebElement logoutMenu;
	
	@FindBy(xpath="//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']/a")
	private WebElement logoutButton;
	
	@FindBy(linkText="Home")
	private WebElement Home;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 30);
	}
	
	public boolean validatePageTitle()
	{
		String title = driver.getTitle();
		System.out.println("The title text is "+title);
		return title.contains("Facebook");
	}
	
	public boolean isOnPage() {
        try {
        	wait.until(ExpectedConditions.elementToBeClickable(Home));
        	return Home.isDisplayed();
        } catch (Exception ex) {
          return false;
        }
      }
	
	public void logout()
	{
		logoutMenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
	}
}
