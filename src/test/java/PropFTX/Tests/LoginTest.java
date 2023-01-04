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

//	public static void main(String[] args) throws InterruptedException {
	//@Test
	public void wrongEmailPassword() throws InterruptedException {
		lp.openWebsite();
		lp.enterEmailPassword("nishu@yopmail.com", "Test@123");
		Thread.sleep(2000);
		String attribute1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/input")).getAttribute("type");
		System.out.println(attribute1);
		driver.findElement(By.cssSelector("svg[stroke='currentColor']")).click();
		String attribute2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div/div/div[2]/div/form/div[2]/div[2]/input")).getAttribute("type");
		System.out.println(attribute2);
		Assert.assertEquals(attribute2, "text");
		lp.clickOnSubmit();
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.cssSelector(".mr-2")).getText());
		//lp.getPopup();
	}

	//@Test
	public void withoutEmailPassword() {
		lp.openWebsite();
		lp.enterEmailPassword("", "");
		lp.clickOnSubmit();
	}
	
	@Test
	public void validEmailPassword() throws InterruptedException
	{
		lp.openWebsite();
		lp.enterEmailPassword("admin@admin.com", "Admin@123");
		lp.clickOnSubmit();
		lp.getPopup();
		Assert.assertEquals(lp.getPopup(), "You have successfully logged in!");	
	}
	
	//@Test
	public void InvalidEmail()
	{
		lp.openWebsite();
		lp.enterEmailPassword("admin", "Admin@123");
		//driver.findElement(By.cssSelector("svg[stroke='currentColor']")).click();
		lp.clickOnSubmit();
		//lp.getPopup();
		System.out.println(driver.findElement(By.cssSelector(".invalid-feedback")).getText());
		Assert.assertTrue(true, "Please enter a valid email id");
	}
	
	//@Test
	public void forgotPassword()
	{
		lp.openWebsite();
		lp.clickOnForgotPassword();
		lp.enterEmail("admin@admin.com");
		lp.clickOnSubmit();
		//lp.getPopup();
		Assert.assertTrue(true, "Password reset link sent on your registered email id");
		
	}
	
	//@Test
	public void forgotPasswordInvaliEmail()
	{
		lp.openWebsite();
		lp.clickOnForgotPassword();
		lp.enterEmail("admin");
		lp.clickOnSubmit();
		System.out.println(driver.findElement(By.cssSelector(".invalid-feedback")).getText());
		Assert.assertTrue(true, "Please enter a valid email id");
		
	}
	
}
