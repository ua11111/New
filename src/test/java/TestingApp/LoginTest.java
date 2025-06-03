package TestingApp;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.Base;
import pageObjects.Accountpage;
import pageObjects.HomePage;
import pageObjects.Loginpage;

public class LoginTest extends Base {
	
	@Test(groups = { "demo" })	
	public void verify_login()
	{
	HomePage hm = new HomePage(driver);
	hm.clickMyAccount();
	hm.clickloginbtn();
	
	Loginpage lp=new Loginpage(driver);
	
	lp.SetEmail(prop.getProperty("email"));
	lp.SetPass(prop.getProperty("password"));
	lp.clicklogin();
	
	//Account page
	
	Accountpage act=new Accountpage(driver);
	
	SoftAssert sa=new SoftAssert();
	sa.assertTrue(act.verifyAccount());
	sa.assertAll();
}
}