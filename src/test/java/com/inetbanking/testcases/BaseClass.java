package com.inetbanking.testcases;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ReadConfig;

import org.testng.annotations.AfterClass;


public class BaseClass 
{
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String bankTitlePage=readconfig.getbankTitlePage();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String customerSuccessMsg=readconfig.getcustomerSuccessMsg();
	public static WebDriver driver;
	public static Logger Logger;
	

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger = org.apache.log4j.Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
			System.out.println("Running chrome browser");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			System.out.println("Running firefox browser");
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			System.out.println("Running ie browser");
		}		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		Logger.info("URL is open: " +baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
