package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class InvalidLoginTest extends BaseTest{
	
	@Test (priority = 2)
	public void testcase2()
	{
		loginpage = new LoginPage(driver);
		loginpage.login("sabyasachidasster@gmail.com", " ");
		homepage = new HomePage(driver);
		try{
		Assert.assertFalse(homepage.isOnPage());
		Reporter.log("Error page launched, Invalid Login Test");
		}catch(Exception e){
			Reporter.log("Error in Invalid Login test");
		}
	}

}
