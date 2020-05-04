package Tests;

import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.ReadExcel;

public class LoginTest extends BaseTest{
	
	@Test (dataProvider = "InputParameters")
	public void testcase1(String UserName, String PassWord)
	{
		loginpage = new LoginPage(driver);
		loginpage.login(UserName,PassWord);
		homepage = new HomePage(driver);
		
		try{
		Assert.assertTrue(homepage.isOnPage());
		Reporter.log("Valid password case verified");
		}catch(Exception e){
			Reporter.log("Logged in to facebook");
		}
		
		homepage.logout();
		Reporter.log("Logged out of facebook");
	}
	
	@DataProvider(name="InputParameters")
    public String[][] getDataFromDataprovider(){
		ReadExcel Exe = new ReadExcel();
    return new String[][] 
    	{
            { Exe.fetchCellValue(1, 0), Exe.fetchCellValue(1, 1) }
        };

    }
	

}
