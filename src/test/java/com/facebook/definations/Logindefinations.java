package com.facebook.definations;

import org.openqa.selenium.By;

import com.facebook.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logindefinations extends Basedefinations{


@Given("user should be on login page")
public void user_should_be_on_login_page() {
	init();
	lp=new LoginPage(driver);
}

@When("user enters valid username and password")
public void user_enters_valid_username_and_password() {
	
	lp.EnterUseridPwd("ajaygudalkar78@gmail.com","Ajay@9833b");
}
@When("user enters valid username and Invalid password")
public void user_enters_valid_username_and_invalid_password() {
	
	lp.EnterUseridPwd("ajaygudalkar78@gmail.com","Ajay@123");
}
@When("clicks on login button")
public void clicks_on_login_button() {
   lp.ClickLogin();
}

@Then("user should be navigated to home page")
public void user_should_be_navigated_to_home_page() throws InterruptedException {
    lp.verifyLogo();
}

@Then("user can see friends logo on home page")
public void user_can_see_logout_link_on_home_page() {
    driver.findElement(By.xpath("//span[contains(text(),'Friends')]")).isDisplayed();
}

@Then("user should be navigated to login page")
public void user_should_be_navigated_to_login_page() {
    lp.verifyloginbtn();
}
@Then("user can see error message")
public void user_can_see_error_message() {
    lp.verifyErrormsg();
}
@Then("close browser")
public void close_browser() {
    driver.close();
}


}
