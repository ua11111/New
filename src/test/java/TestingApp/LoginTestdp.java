package TestingApp;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.Base;
import pageObjects.Accountpage;
import pageObjects.HomePage;
import pageObjects.Loginpage;

public class LoginTestdp extends Base {
	
	@Test(dataProvider="testdata",dataProviderClass=DataPprovider.class,retryAnalyzer=Retry.class)
	public void verify_login(String username, String password, String expResult)
	{
	HomePage hm = new HomePage(driver);
	hm.clickMyAccount();
	hm.clickloginbtn();
	
	Loginpage lp=new Loginpage(driver);
	
	lp.SetEmail(username);
	lp.SetPass(password);
	lp.clicklogin();
	
	//Account page
	
	Accountpage act=new Accountpage(driver);
	boolean targetPage=	act.verifyAccount();
	
	logger.info("***validation for invalid result ***");
	if (expResult.equalsIgnoreCase("invalid")) {
		//if(targetPage==true) {
			//act.logout();
			//Assert.assertTrue(false);
		//}else {
		//	Assert.assertTrue(true);
		Assert.fail();
		}
	
	
	logger.info("***validation for valid result ***");
	if (expResult.equalsIgnoreCase("valid")) {
		if(targetPage==true) {
			act.logout();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	logger.info("***completed LoginDDTest ***");	
}



}
