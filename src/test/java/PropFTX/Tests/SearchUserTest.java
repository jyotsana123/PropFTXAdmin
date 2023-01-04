package PropFTX.Tests;

import org.openqa.selenium.By;
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
		lp.enterEmailPassword("admin@admin.com", "Admin@123");
		lp.clickOnSubmit();
		AddUser adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		searchuser = new SearchUser(driver);
}
	@Test
	public void searchByUserName()
	{
		
		searchuser.enterName("Test");
	}
	
	@Test
	public void searchByEmail()
	{	
		searchuser.enterEmail("@yopmail.com");
	}
	
	@Test
	public void searchByInvalidData()
	{
		searchuser.enterInvalidData("bjbhj564455@$@$@");
		//System.out.println(driver.findElement(By.cssSelector(".sc-iveFHk.gHqiHO div")).getText());
		Assert.assertTrue(true, "There are no records to display");
	}
	
	
}
