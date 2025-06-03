package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountpage extends BaseComponents {

	public Accountpage(WebDriver driver)

	{

		super(driver);
	}

	// locators

	@FindBy(xpath = "//h2[text()='My Account']")

	WebElement account;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutbtn;

	// Actions

	public boolean verifyAccount() {
		try {
			return account.isDisplayed();
		}

		catch (Exception e) {

			return false;

		}
	}

	public void logout() {
		logoutbtn.click();
	}
}
