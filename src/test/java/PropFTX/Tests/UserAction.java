package PropFTX.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PropFTX.PageObject.AddUser;
import PropFTX.PageObject.SearchUser;
import PropFTX.TestComponent.BaseTest;

public class UserAction extends BaseTest{

	@BeforeMethod
	public void Search()
	{
		lp.openWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		AddUser adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		SearchUser searchuser = new SearchUser(driver);
		searchuser.clickOnListOption();
}
	//@Test
	public void editParticularData()
	{
		String UserName = "khyati dixit";
		List<WebElement> name = driver.findElements(By.cssSelector("#cell-2-undefined"));
		for (int i = 0; i < name.size(); i++) {
			String array = name.get(i).getText();
			//System.out.println(array);
			if(array.contains(UserName))
			{
				System.out.println(array);
				//driver.findElement(By.cssSelector("#cell-1-undefined > div > svg:nth-child(1) > path:nth-child(1)")).click();
				driver.findElement(By.xpath("//div[@id='row-"+i+"']//div[@class='d-flex cursor-pointer']//*[name()='svg']")).click();
				break;
			}
		
		}
	}
	    //@Test
		public void deleteParticularData()
		{
			String UserName = "Suraj Prajapati";
			List<WebElement> name = driver.findElements(By.cssSelector("#cell-2-undefined"));
			
			for (int i = 0; i < name.size(); i++) {
				String array = name.get(i).getText();
				//System.out.println(array);
				if(array.contains(UserName))
				{
					System.out.println(array);	
					driver.findElement(By.xpath("//div[@id='row-"+i+"']//*[name()='svg'][2]")).click();
					driver.findElement(By.xpath("//div/button[@type='reset'][1]")).click();
					break;
				}
				System.out.println(array);
				if(!array.contains(UserName))
				{
					System.out.println("User not found in the list");
					break;
				}
			}
		}
		
	
	    @Test
		public void toggleParticularData()
		{
			String UserName = "Dablu Prasad";
			List<WebElement> name = driver.findElements(By.cssSelector("#cell-2-undefined"));
			for (int i = 0; i < name.size(); i++) {
				String array = name.get(i).getText();
				//System.out.println(array);
				if(array.contains(UserName))
				{
					System.out.println(array);
					//driver.findElement(By.cssSelector("#cell-1-undefined > div > svg:nth-child(1) > path:nth-child(1)")).click();
					driver.findElement(By.xpath("//div[@id='row-"+i+"']//input[@class='form-check-input']")).click();
					driver.findElement(By.xpath("//div/button[@type='reset'][1]")).click();
					break;
				}
			
			}
		}
	
}
