package TestingApp;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.Base;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationTest extends Base{

	

	@Test(groups = { "demo" })	

	public void verify_registration()

	{
		
		logger.info("execution started");
		HomePage hm = new HomePage(driver);
		hm.clickMyAccount();
		hm.clickRegister();

		RegistrationPage rg = new RegistrationPage(driver);
		rg.enterFirstName(RandomStringGenerate());
		rg.enterLastName(RandomStringGenerate());
		rg.enterEmail(RandomStringGenerate() + "@gmail.com");
		rg.enterTelephone("1245");
		rg.enterPassword("kakaka");
		rg.enterConfirmPassword("kakaka");
		rg.clickSubscribe();
		rg.clickPrivatePolicy();
		rg.clickContinue();
		String msg = rg.getRegisteredMessage();

		System.out.println(msg);

		if (msg.equalsIgnoreCase("Your Account Has Been Created!"))

		{
			Assert.assertTrue(true);

		}

		else

		{
			System.out.println("Message incorrect");
			Assert.fail();
		}

	}

	

	
}
