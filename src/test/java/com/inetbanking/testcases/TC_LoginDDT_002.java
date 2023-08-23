package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("username set");
		System.out.println("username set");
		
		lp.setPassword(pwd);
		Logger.info("password set");
		System.out.println("password set");
		
		lp.clicksubmit();
		Logger.info("click login submit");
		System.out.println("click login submit");
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close login error alert popup message
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failed");
			System.out.println("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			System.out.println("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert popup message
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() //user defined method to check if pop message login alert is present 
	{
		
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}	
		
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path="E:/My Projects/Development/automation/eclipse/inetBankingv1/src/test/java/com/inetbanking/testdata/LoginData.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j); // 1 0
			}
		}
		return loginData;
		
	}
	

}
