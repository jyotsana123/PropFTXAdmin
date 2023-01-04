package PropFTX.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PropFTX.PageObject.LandingPage;
import PropFTX.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {

	@Test(priority=1)
	public void wrongEmailPassword() throws InterruptedException {
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Invalid Email or Password");
	}

	@Test(priority=3)
	public void checkPasswordVisibility() {
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		lp.checkPasswordVisibility();
	}

	@Test(priority=0)
	public void withoutEmailPassword() {
		lp.enterEmailPassword("", "");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
		Assert.assertEquals(lp.getPasswordError(), "Please enter Password");

	}

	@Test(priority=4)
	public void validEmailPassword() throws InterruptedException {
		//lp.openWebsite();
		lp.enterEmailPassword("rahul.agarwal@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "You have successfully logged in!");
	}

	@Test(priority=2)
	public void InvalidEmail() {
		lp.enterEmailPassword("admin", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}

	@Test(priority=7)
	public void forgotPasswordEmailNotExist() {
		lp.clickOnForgotPassword();
		lp.enterEmail("admin@admin.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Email not found !");
	}

	@Test(priority=6)
	public void forgotPasswordInvaliEmail() {
		lp.clickOnForgotPassword();
		lp.enterEmail("admin");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}
	
	@Test(priority=5)
	public void forgotPasswordWithoutEmail() {
		lp.clickOnForgotPassword();
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
	}

	@Test(priority=8)
	public void forgotPasswordEmailExist() {
		lp.clickOnForgotPassword();
		lp.enterEmail("rahul.agarwal@mail.vinove.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Password reset link sent on your registered email id");
	}

}
