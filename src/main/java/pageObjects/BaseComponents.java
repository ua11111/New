package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseComponents {
	
	WebDriver driver;

	// Constructor

	public BaseComponents(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
