package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	//constructor
	public HomePage(WebDriver driver)
	{
		super (driver); //Here we are calling the constructor from the basePage class
	
	}
	
	//Locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;

	
	
	//Action Methods
	
	public void clickMyAccount() 
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister() 
	{
		lnkRegister.click();
	}
	
	public void clickLogin() 
	{
		lnkLogin.click();
	}
	
	

}
