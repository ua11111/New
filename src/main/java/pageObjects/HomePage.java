package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseComponents {
	
	//WebDriver driver;
	
	//Constructor
	
public HomePage(WebDriver driver)

{
	super(driver);
	
}
	
	
	//Locators

@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement myAccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement Register;

@FindBy(xpath="//a[text()='Login']")
WebElement login;
	
	
	//Actions
public void clickMyAccount()

{
	myAccount.click();
	
}
public void clickRegister()


{
	Register.click();
	
}

public void clickloginbtn()
{
	
	login.click();
}
}

