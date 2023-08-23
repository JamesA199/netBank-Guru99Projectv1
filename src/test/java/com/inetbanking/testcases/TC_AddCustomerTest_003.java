package com.inetbanking.testcases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name is provided: "+username);
		lp.setPassword(password);
		Logger.info("Passsword is provided");
		System.out.println("Passsword is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		Logger.info("providing customer details....");
		Thread.sleep(3000);
		String rndName=randomestring();
		addcust.custName(rndName);
		addcust.custgender("f");
		addcust.custdob("1985","10","10");
		
		String rndAddr=randomestring();
		addcust.custaddress(rndAddr);
		addcust.custcity("YYC");
		addcust.custstate("AB");
		String rndNumb1=randomeNum();
		addcust.custpinno(rndNumb1);
		String rndNumb2=randomeNum();
		addcust.custtelephoneno(rndNumb2);
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		Logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains(customerSuccessMsg);
		
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed....");
			
		}
		else
		{
			Logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

}
