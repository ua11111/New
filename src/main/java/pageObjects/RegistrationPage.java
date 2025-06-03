package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseComponents{

	

	// Constructor

	public RegistrationPage(WebDriver driver)

	{
		super(driver);
	

	}

//locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")

	WebElement LastName;

	@FindBy(xpath = "//input[@id='input-email']")

	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")

	WebElement Telephone;

	@FindBy(xpath = "//input[@id='input-password']")

	WebElement Password;

	@FindBy(xpath = "//input[@id='input-confirm']")

	WebElement ResetPassword;

	@FindBy(css = "input[value='1'][name='newsletter']")
	WebElement Subscribe;

	@FindBy(css = "input[value='1'][name='agree']")
	WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")

	WebElement Continue;

	@FindBy(css = "div[id='content'] h1")
	WebElement RegisterAccount;

//Actions
	public void enterFirstName(String name) {
		FirstName.sendKeys(name);
	}

	public void enterLastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void enterEmail(String email1) {
		email.sendKeys(email1);
	}

	public void enterPassword(String Password1) {
		Password.sendKeys(Password1);
	}

	public void enterConfirmPassword(String confirmPassword) {
		ResetPassword.sendKeys(confirmPassword);
	}

	public void enterTelephone(String telephone) {
		Telephone.sendKeys(telephone);
	}

	public void clickSubscribe() {
		Subscribe.click();
	}

	public void clickPrivatePolicy() {
		privacyPolicy.click();
	}

	public void clickContinue() {
		Continue.click();
	}

	public String getRegisteredMessage()

	{
		try {

			return RegisterAccount.getText();
		}

		catch (Exception e) {
			return e.getMessage();

		}
	}
}
