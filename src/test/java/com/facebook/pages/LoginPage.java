package com.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.comm.CommonActions;

public class LoginPage {

	private WebDriver driver;
	public CommonActions ca;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		ca=new CommonActions(driver);
	}
	@FindBy(name="email")
	WebElement username;
	@FindBy(css="#pass")
	WebElement pass;
	@FindBy(name="login")
	WebElement login;
	@FindBy(css="path[class='xe3v8dz']")
	WebElement logo;
	@FindBy(name="login")
	WebElement loginbtn;
	@FindBy(xpath="//div[contains(text(),'entered is incorrect.')]")
	WebElement errormsg;
	
	public void login(String userid,String pwd)
	{
		ca.EnterValue(username, userid);
		ca.EnterValue(pass, pwd);
		//ca.ClickElement(login);
	}
	public void EnterUseridPwd(String userid,String pwd)
	{
		ca.EnterValue(username, userid);
		ca.EnterValue(pass, pwd);
	}
	public void ClickLogin()
	{
		ca.ClickElement(login);
	}
	public void verifyLogo()
	{
		ca.ElementExist(logo);
	}
	public void verifyloginbtn()
	{
		ca.ElementExist(loginbtn);
	}
	public void verifyErrormsg()
	{
		ca.ElementExist(errormsg);
	}
}
