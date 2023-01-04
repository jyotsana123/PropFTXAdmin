package PropFTX.Tests;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
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
		lp.enterEmailPassword("admin@admin.com", "Admin@123");
		lp.clickOnSubmit();
		adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul/li[2]/ul/div/li[2]/a")).click();
		//adduser.clickOnAddUserButton();
	}
	
	@Test
	public void addUser() throws InterruptedException, AWTException
	{
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/94kb.jpg");
		adduser.enterNameAddressPhoneNumber("Annu", "Jaitpur new delhi", "7827317222");
		adduser.selectCountry();
		adduser.selectState();
		adduser.selectCity();
		adduser.enterEmail("annu@yopmail.com");
		adduser.clickOnSubmitButton();
		}
	
	
	@Test
	public void clickOnSubmit()
	{
		adduser.clickOnSubmitButton();
	}
	
	@Test
	public void enterNameMoreThan50CharAddress100CharInvalidPhonenum()
	{
		adduser.enterNameAddressPhoneNumber("Lorem Ipsum is simply dummy text of the printing an", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been thati", "yrtuwttr");
		adduser.clickOnSubmitButton();
	}
	
	@Test
	public void enterInvalidEmail()
	{
		adduser.enterEmail("uueyuwuey@hhihiqiru.dhiuhiuqhewhiqhrirhqwrqwihri");
		adduser.clickOnSubmitButton();
	}
	
	@Test
	public void chooseImagelessThan100kb()
	{
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/98kb.jpg");
		adduser.getImageError();
		Assert.assertTrue(false, "file size max 100kb");
	}

	@Test
	public void chooseImageMoreThan100kb() throws InterruptedException
	{
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/103kb.jpg");
	    adduser.getImageError();
	    Assert.assertTrue(true, "file size max 100kb");
		
	}
	
	@Test
	public void chooseImage100kb()
	{
		adduser.chooseImageFile("C:/Users/Jyotsana Pandey/Pictures/100kb.jpg");
		adduser.getImageError();
		Assert.assertTrue(false, "file size max 100kb");
	}
}
