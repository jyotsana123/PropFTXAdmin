package PropFTX.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PropFTX.PageObject.AddUser;
import PropFTX.PageObject.SearchUser;
import PropFTX.TestComponent.BaseTest;

public class SearchUserTest extends BaseTest{
	public  SearchUser searchuser;
	@BeforeMethod
	public void Search()
	{
		lp.openWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		AddUser adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		searchuser = new SearchUser(driver);
		searchuser.clickOnListOption();
}
	@Test(priority=0)
	public void searchByUserName() throws InterruptedException
	{
		searchuser.enterName("Test");
		searchuser.printName();
	}
	
	@Test(priority=1)
	public void searchByEmail()
	{	
		searchuser.enterEmail("@yopmail.com");
		searchuser.printEmail();
	}
	
	@Test(priority=2)
	public void searchByPhoneNumber()
	{	
		searchuser.enterPhoneNumber("9582402076");
		searchuser.printPhoneNumber();
	}
	
	@Test(priority=3)
	public void searchByInvalidData()
	{
		searchuser.enterInvalidData("bjbhj564455@$@$@");
		Assert.assertEquals(searchuser.getNoResultText(), "There are no records to display");
	}
	
	
}
