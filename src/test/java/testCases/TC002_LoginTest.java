package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.baseClass;

public class TC002_LoginTest extends baseClass {

    @Test(groups={"Sanity","Master"})
    public void Verify_Login() {
        logger.info("*************** Starting TC002_LoginTest ******************");

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
            lp.setUsername(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();

            // MyAccount Page
            logger.info("Verifying login is successful or not");
            MyAccountPage map = new MyAccountPage(driver);
            boolean targetPage=map.isMyAccountPageExist();
            
            if(targetPage==true)
        	{
        		Assert.assertTrue(true);
        	
        	}
        	else
        	{
        		Assert.assertTrue(false);
        	}
            
        } catch (Exception e) {
            logger.error("Exception occurred during login test: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("*************** Finished TC002_LoginTest ******************");
    }
}
