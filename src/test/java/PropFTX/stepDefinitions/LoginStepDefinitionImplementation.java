package PropFTX.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import PropFTX.PageObject.LandingPage;
import PropFTX.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitionImplementation extends BaseTest {
	
	public LandingPage lp;
	@Given ("I landed on Admin login page")
	public void I_landed_on_Admin_login_page() throws IOException
	{
		lp = launchWebsite();
	}
	
	@Given ("^Logged in with valid email (.+) and valid password (.+)$")
	public void Logged_in_with_valid_email_and_valid_password(String Email, String Password)
	{
		lp.enterEmailPassword(Email,Password);
	}
	
	@When ("Click on login button")
	public void Click_on_login_button()
	{
		lp.clickOnSubmit();
	}
	
	@Then ("Dashboard should be displayed")
	public void Dashboard_should_be_displayed()
	{
		System.out.println("Loggin Successfully");
		Assert.assertEquals(lp.getPopup(), "You have successfully logged in!");
	}

	
	@Given ("^Logged in with wrong email (.+) and wrong password (.+)$")
	public void Logged_in_with_wrong_email_and_wrong_password(String Email, String Password)
	{
		lp.enterEmailPassword(Email,Password);
	}

	@Then ("Error message should be displayed")
	public void Error_message_should_be_displayed()
	{
		System.out.println("Error message displaying");
		Assert.assertEquals(lp.getPopup(), "Invalid Email or Password");
	}
	
	
//	@Given ("^Logged in with without email (.+) and without password (.+)$")
//	public void Logged_in_with_without_email_and_without_password(String Email, String Password)
//	{
//		lp.enterEmailPassword(Email,Password);
//	}

	@Then ("Error message should be displayed for email and password")
	public void Error_message_should_be_displayed_for_email_and_password()
	{
		System.out.println("Error message displaying");
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
		Assert.assertEquals(lp.getPasswordError(), "Please enter Password");
	}
	
	
	@Given ("^Logged in with invalid email (.+) and valid password (.+)$")
	public void Logged_in_with_invalid_email_and_valid_password(String Email, String Password)
	{
		lp.enterEmailPassword(Email,Password);
	}

	@Then ("Error message should be displayed for email")
	public void Error_message_should_be_displayed_for_email()
	{
		System.out.println("Error message displaying");
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}
	
	@Given("^Enter email (.+) and password (.+)$")
    public void enter_email_and_password(String Email, String Password) 
	{
		lp.enterEmailPassword(Email,Password);
    }

    @When("^Click on password eye icon$")
    public void click_on_password_eye_icon()
    {
    	lp.checkPasswordVisibility();
    }

    @Then("^Password should be displayed (.+)$")
    public void password_should_be_displayed(String Password) 
    {
    	//lp.checkPasswordVisibility();
        System.out.println("Password is " +Password);
    }
    
    
    //Forgot Password
    @Given("^Enter email on forgot password page (.+)$")
    public void enter_email_on_forgot_password_page(String Email) 
    {
    	lp.clickOnForgotPassword();
		lp.enterEmail(Email);
    }

    @When("^Click on submit button$")
    public void click_on_submit_button()
    {
    	lp.clickOnSubmit();
    }

    @Then("^Reset link sent message should be displayed$")
    public void reset_link_sent_message_should_be_displayed()
    {
    	Assert.assertEquals(lp.getPopup(), "Password reset link sent on your registered email id");
    }
    
   
    @Given("^I am on forgot password page$")
    public void i_am_on_forgot_password_page() 
    {
    	lp.clickOnForgotPassword();
    }

    @When("^Click on submit button1$")
    public void click_on_submit_button1() 
    {
    	lp.clickOnSubmit();
    }

    @Then("^Error should be displayed for email$")
    public void error_should_be_displayed_for_email() 
    {
    	Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
    }
    
    @Given("^Enter invalid email on forgot password page (.+)$")
    public void enter_invalid_email_on_forgot_password_page(String Email) 
    {
    	lp.clickOnForgotPassword();
		lp.enterEmail(Email);
    }

    @When("^Click on submit button2$")
    public void click_on_submit_button2() 
    {
    	lp.clickOnSubmit();
    }

    @Then("^Error message should be displayed for invalid email$")
    public void error_message_should_be_displayed_for_invalid_email() 
    {
    	Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
    }
    
    @Given("^Enter non existing email on forgot password page (.+)$")
    public void enter_non_existing_email_on_forgot_password_page(String Email)
    {
    	lp.clickOnForgotPassword();
		lp.enterEmail(Email);
    }

    @When("^Click on submit button3$")
    public void click_on_submit_button3() 
    {
    	lp.clickOnSubmit(); 
    }

    @Then("^Error message should be displayed for non existing email$")
    public void error_message_should_be_displayed_for_non_existing_email() 
    {
    	Assert.assertEquals(lp.getPopup(), "Email not found");
    }
}
