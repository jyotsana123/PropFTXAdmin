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
		//lp.enterEmailPassword("admin@admin.com", "Admin@123");
		lp.clickOnSubmit();
		adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		adduser.clickOnAddOption();
	}
	
	
	@Test(priority=6)
	public void addUser() throws InterruptedException, AWTException
	{
		adduser.enterNameAddressPhoneNumber("Bhumica", "Noida UP", "1234567892");
		adduser.selectCountry();
		adduser.selectState();
		adduser.selectCity();
		adduser.enterEmail("Bhumica@yopmail.com");
		adduser.clickOnSubmitButton();
		Assert.assertEquals(lp.getPopup(), "User Created Successfully");
		}
	
	
	//@Test(priority=0)
	public void clickOnSubmit() throws InterruptedException
	{
		adduser.waitForElement();
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());	
	}
	
	//@Test(priority=1)
	public void enterNameMoreThan50CharAddress100CharInvalidPhonenum() throws InterruptedException
	{
		adduser.waitForElement();
		adduser.enterNameAddressPhoneNumber("Lorem Ipsum is simply dummy text of the printing an", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been thati", "yrtuwttr");
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());
	}
	
	//@Test(priority=2)
	public void enterInvalidEmail() throws InterruptedException
	{
		adduser.waitForElement();
		adduser.enterEmail("abc.com");
		adduser.clickOnSubmitButton();
		Assert.assertTrue(adduser.getErrorMessage());
	}
	
	//@Test(priority=4)
	public void chooseImagelessThan500kb() throws InterruptedException
	{
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/498kb.jpg");
	}

	//@Test(priority=3)
	public void chooseImageMoreThan500kb() throws InterruptedException
	{
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/506kb.jpg");
	    Assert.assertEquals(adduser.getImageError(), "file size max 500kb");
		
	}
	
	//@Test(priority=5)
	public void chooseImage500kb()
	{
		//adduser.clickOnAddOption();
		adduser.waitForElement();
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/500kb.png");
	}
}
