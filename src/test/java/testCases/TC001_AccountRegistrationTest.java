package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.baseClass;

public class TC001_AccountRegistrationTest extends baseClass {

	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		//logger object is created in baseclass and used here
		
		logger.info("Starting TC001_AccountRegistrationTest............");
		
		try {
		HomePage hp = new HomePage(driver);
				
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link............");
		hp.clickRegister();
		logger.info("Clicked on My Register Link............");
		
		AccountRegistrationPage arp =new AccountRegistrationPage(driver);
		logger.info("Providing customer details............");
		
		arp.setFirstname(randomAlpha());
		arp.setLastname(randomAlpha());
		arp.setEmail(randomAlpha()+"@gmail.com");
		arp.setTelephone(randomNum());
		
		String Password=randomAlnum();
		arp.setPassword(Password);
		arp.setConfirmPassword(Password);
		arp.clickAgree();
		arp.clickContinue();
		
		logger.info("Validating Expected Message............");
		Assert.assertEquals(arp.getConfirmationMsg(), "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed............");
			logger.debug("Debug Logs............");
			Assert.fail();
		}
		
		logger.info("Finished TC001_AccountRegistrationTest............");
		
		}
	}


