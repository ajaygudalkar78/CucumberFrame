package com.facebook.definations;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.facebook.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basedefinations {
	public WebDriver driver;
	public Properties prop;
	public SoftAssert sa;
	public static LoginPage lp;

	public void init()
	{
		prop=GetProperties();
		if(driver==null)
		{
		launchApp();
		}
	}
	
	public void launchApp()
	{
		if(prop.getProperty("Browser").equals("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equals("edge"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new EdgeDriver();
		}
		else if(prop.getProperty("Browser").equals("headless"))
		{
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--headless=chrome");
			driver = new ChromeDriver(options);
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		sa=new SoftAssert();
	}
	public Properties GetProperties()
	{
		Properties prop=null;
		try
		{
		prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/Settings.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	public void closeApp()
	{
		sa.assertAll();
		driver.quit();
	}
	
}
