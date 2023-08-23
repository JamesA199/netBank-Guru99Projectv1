package com.inetbanking.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.AddCustomerPage;

public class TC_LoginTest_002 extends BaseClass
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
		
		AddCustomerPage addcust=new AddCustomerPage(driver);			
		addcust.clickAddNewCustomer();
		Logger.info("click Add new customer link");
		System.out.println("click Add new customer link");
		
		addcust.clickEditCustomer();
		Logger.info("click Add edit customer link");
		System.out.println("click Add edit customer link");
	}

}


