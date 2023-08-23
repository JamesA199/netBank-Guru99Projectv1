package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("set UserName");
		lp.setPassword(password);
		Logger.info("set password");
		System.out.println("set password");
		lp.clicksubmit();
		Logger.info("submit login");
		System.out.println("submit login");
		if (driver.getTitle().equals(bankTitlePage))
		{
			Assert.assertTrue(true);
			Logger.info("Found title page: "+bankTitlePage);
			System.out.println("Found title page: "+bankTitlePage);
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Did not find title page: "+bankTitlePage);
			System.out.println("Did not find title page: "+bankTitlePage);
		}
	}

}


