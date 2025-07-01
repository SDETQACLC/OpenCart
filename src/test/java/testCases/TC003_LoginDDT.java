package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.baseClass;

public class TC003_LoginDDT extends baseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven") //getting data provider from different class
	public void Verify_LoginDDT(String Email, String Password,String ExpRes)
	{
		
		logger.info("***********Starting TC003_LoginTest*************");
		
		
		try {
		 // Homepage
        HomePage hp = new HomePage(driver);
        logger.info("Clicking on My Account");
        hp.clickMyAccount();

        logger.info("Clicking on Login");
        hp.clickLogin();
        
     // LoginPage
        LoginPage lp = new LoginPage(driver);
        logger.info("Entering Username and Password");
        lp.setUsername(Email);
        lp.setPassword(Password);
        lp.clickLogin();

        // MyAccount Page
        logger.info("Verifying login is successful or not");
        MyAccountPage map = new MyAccountPage(driver);
        boolean targetPage=map.isMyAccountPageExist();
        
        
        if(ExpRes.equalsIgnoreCase("valid"))
        {
        	if(targetPage==true)
        	{
        		Assert.assertTrue(true);
        		map.click_Logout();
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
        }
        
        
        
        if(ExpRes.equalsIgnoreCase("invalid"))
        {
        	if(targetPage==true)
        	{
        		map.click_Logout();
        		Assert.assertTrue(false);
        	}
        	else
        	{
        		Assert.assertTrue(true);
        	}
        }
		}
		catch(Exception e)
		{
			Assert.fail();
		}
    	logger.info("***********Executed TC003_LoginTest*************");

        
	}
}
