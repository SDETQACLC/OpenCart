package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//Locators 
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_Login;
	
	
	//Action Methods
	
	public void setUsername(String Username)
	{
		txt_Username.sendKeys(Username);
	}
	
	public void setPassword(String Password)
	{
		txt_Password.sendKeys(Password);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}
	

}
