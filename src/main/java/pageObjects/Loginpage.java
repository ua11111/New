package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BaseComponents {
	
	public Loginpage(WebDriver driver)
	{
		
		super(driver);
	}

	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']")
	
	WebElement email;// storing email
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	//Actions
	
	public void SetEmail(String emailid)
	{
		email.sendKeys(emailid);
		
	}
	
	public void SetPass(String password1)
	{
		password.sendKeys(password1);
		
	}
	
	public void clicklogin()
	{
		loginbtn.click();
		
	}
}
