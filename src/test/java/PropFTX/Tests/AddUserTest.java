package PropFTX.Tests;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PropFTX.PageObject.AddUser;
import PropFTX.TestComponent.BaseTest;

public class AddUserTest extends BaseTest{
	
	public AddUser adduser;
	
	@BeforeMethod
	public void addUserbutton()
	{
		lp.openWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
	}
	
	//@Test
	public void addUser() throws InterruptedException, AWTException
	{
		adduser.clickOnAddOption();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/94kb.jpg");
		adduser.enterNameAddressPhoneNumber("Annu", "Jaitpur new delhi", "7827317729");
		adduser.selectCountry();
		adduser.selectState();
		adduser.selectCity();
		adduser.enterEmail("annu2@yopmail.com");
		adduser.clickOnSubmitButton();
		Assert.assertEquals(lp.getPopup(), "User Created Successfully");
		}
	
	
	@Test
	public void clickOnSubmit() throws InterruptedException
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());	
	}
	
	@Test
	public void enterNameMoreThan50CharAddress100CharInvalidPhonenum() throws InterruptedException
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.enterNameAddressPhoneNumber("Lorem Ipsum is simply dummy text of the printing an", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been thati", "yrtuwttr");
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());
	}
	
	@Test
	public void enterInvalidEmail() throws InterruptedException
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.enterEmail("abc.com");
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());
	}
	
	@Test
	public void chooseImagelessThan500kb() throws InterruptedException
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/498kb.jpg");
	}

	@Test
	public void chooseImageMoreThan500kb() throws InterruptedException
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/506kb.jpg");
	    Assert.assertEquals(adduser.getImageError(), "file size max 500kb");
		
	}
	
	@Test
	public void chooseImage500kb()
	{
		adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/500kb.jpg");
	}
}
