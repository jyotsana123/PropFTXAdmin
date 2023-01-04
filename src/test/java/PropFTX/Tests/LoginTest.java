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

	@Test
	public void wrongEmailPassword() throws InterruptedException {
		lp.openWebsite();
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Invalid Email or Password");
	}

	@Test
	public void checkPasswordVisibility() {
		lp.openWebsite();
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		lp.checkPasswordVisibility();
	}

	@Test
	public void withoutEmailPassword() {
		lp.openWebsite();
		lp.enterEmailPassword("", "");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
		Assert.assertEquals(lp.getPasswordError(), "Please enter Password");

	}

	@Test
	public void validEmailPassword() throws InterruptedException {
		lp.openWebsite();
		lp.enterEmailPassword("rahul.agarwal@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "You have successfully logged in!");
	}

	@Test
	public void InvalidEmail() {
		lp.openWebsite();
		lp.enterEmailPassword("admin", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}

	@Test
	public void forgotPasswordEmailNotExist() {
		lp.openWebsite();
		lp.clickOnForgotPassword();
		lp.enterEmail("admin@admin.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Email not found !");
	}

	@Test
	public void forgotPasswordInvaliEmail() {
		lp.openWebsite();
		lp.clickOnForgotPassword();
		lp.enterEmail("admin");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}

	@Test
	public void forgotPasswordEmailExist() {
		lp.openWebsite();
		lp.clickOnForgotPassword();
		lp.enterEmail("rahul.agarwal@mail.vinove.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Password reset link sent on your registered email id");
	}

}
