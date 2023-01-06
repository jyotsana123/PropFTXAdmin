package PropFTX.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import PropFTX.AbstractComponent.AbstractComponent;
//import PropFTX.Tests.List;

public class AddUser extends AbstractComponent{

	public Select s;
	WebDriver driver;
	public AddUser(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul/li[2]/a")
	WebElement userManagement;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul/li[2]/ul/div/li[2]/a")
	WebElement addOption;
	
	@FindBy(css=".ms-2.btn-sm.btn.btn-primary")
	WebElement addUser;
	
	@FindBy(css="button[type='submit']")
	WebElement submit;
	
	@FindBy(id="name")
	WebElement Name;
	
	@FindBy(id="address")
	WebElement Address;
	
	@FindBy(id="phoneNumber")
	WebElement PhoneNumber;
	
	@FindBy(xpath="//*[@id='dashboard-analytics']/form/div[2]/div/fieldset/div[5]/div[2]/div/div/div[2]")
	WebElement CountryDropdown;
	
	@FindBy(xpath="//*[@id='dashboard-analytics']/form/div[2]/div/fieldset/div[6]/div[2]/div/div/div[1]")
	WebElement StateDropdown;
	
	@FindBy(xpath="//*[@id='dashboard-analytics']/form/div[2]/div/fieldset/div[7]/div[2]/div/div/div[1]")
	WebElement CityDropdown;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="image")
	WebElement Image;
	
	@FindBy(xpath="//span[text()='file size max 500kb']")
	WebElement ImageError;
	
	@FindBy(css=".address-title")
	WebElement addUserPageTitle;
	
	public void waitForElement()
	{
		waitForWebElementToAppear(addUserPageTitle);
	}
	
	public void clickOnUserManagement()
	{
		userManagement.click();
	}
	
	public void clickOnAddOption()
	{
		addOption.click();
	}
	
	public void clickOnSubmitButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement submitButton = 	driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView(true)",submitButton);
		Thread.sleep(2000);
		submit.click();
	}
	
	public void enterNameAddressPhoneNumber(String name, String address, String phoneNumber)
	{
		Name.sendKeys(name);
		Address.sendKeys(address);
		PhoneNumber.sendKeys(phoneNumber);
	}
	
	public void selectCountry() throws InterruptedException, AWTException
	{
		CountryDropdown.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void selectState() throws InterruptedException, AWTException
	{
		StateDropdown.click();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void selectCity() throws InterruptedException, AWTException
	{
		CityDropdown.click();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void chooseImageFile(String image)
	{
		Image.sendKeys(image);
	}
	
	public String getImageError()
	{
		String error = ImageError.getText();
		System.out.println(error);
		return ImageError.getText();
		//return true;
	}
	
	public boolean getErrorMessage()
	{
		int i;
		List<WebElement> message =  driver.findElements(By.cssSelector(".invalid-feedback"));
		for(i=0;i<message.size();i++)
		{
			String arr = message.get(i).getText();
			System.out.println(arr);
		}
		return true;
		
		
	}
	
}
