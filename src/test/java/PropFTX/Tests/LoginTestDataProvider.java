package PropFTX.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PropFTX.PageObject.LandingPage;
import PropFTX.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestDataProvider extends BaseTest {

	@Test(priority=1, dataProvider="getData")
	public void wrongEmailPassword(String email, String password) throws InterruptedException {
		lp.enterEmailPassword(email, password);
		lp.clickOnSubmit();
//		Assert.assertEquals(lp.getPopup(), "Invalid Email or Password");
//		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
//		Assert.assertEquals(lp.getPasswordError(), "Please enter Password");

	}

	//@Test(priority=3)
	public void checkPasswordVisibility() {
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		lp.checkPasswordVisibility();
	}

	//@Test(priority=0)
	public void withoutEmailPassword() {
		lp.enterEmailPassword("", "");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
		Assert.assertEquals(lp.getPasswordError(), "Please enter Password");

	}

	//@Test(priority=4)
	public void validEmailPassword() throws InterruptedException {
		//lp.openWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "You have successfully logged in!");
	}

	//@Test(priority=2)
	public void InvalidEmail() {
		lp.enterEmailPassword("admin", "Admin@123");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}

	//@Test(priority=7)
	public void forgotPasswordEmailNotExist() {
		lp.clickOnForgotPassword();
		lp.enterEmail("admin@admin.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Email not found !");
	}

	//@Test(priority=6)
	public void forgotPasswordInvaliEmail() {
		lp.clickOnForgotPassword();
		lp.enterEmail("admin");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter a valid email id");
	}
	
	//@Test(priority=5)
	public void forgotPasswordWithoutEmail() {
		lp.clickOnForgotPassword();
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getEmailError(), "Please enter Email id");
	}

	//@Test(priority=8)
	public void forgotPasswordEmailExist() {
		lp.clickOnForgotPassword();
		lp.enterEmail("jyotsana.pandey@mail.vinove.com");
		lp.clickOnSubmit();
		Assert.assertEquals(lp.getPopup(), "Password reset link sent on your registered email id");
	}
	
	//Section: 20: Framework Part 4 - Test Strategy- Control Tests Execution- Run Parallel Tests
	//Video: 172. How to Create Screenshot Utility in Base Test class for catching Failed tests
	public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File Source = ss.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//report"+ testCaseName + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") + "//report"+ testCaseName + ".png";
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"nishu@yopmail.com","Test@123"},{"jyotsana.pandey@mail.vinove.com","Admin@123"},{"",""}};
	}

}
