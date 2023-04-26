package com.facebook.comm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonActions {


	private WebDriver driver;
	private WebDriverWait wait;
	public CommonActions(WebDriver driver)
	{
		this.driver=driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void EnterValue(WebElement elm,String val)
	{
		try {
			
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(val);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void ClickElement(WebElement elm)
	{
		try {
			
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void ElementExist(WebElement elm)
	{
		try {
			
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
		}
		catch(Exception e){
			e.printStackTrace();

		}
	}
}
