package PropFTX.PageObject;

import org.openqa.selenium.By;
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
	
//	@FindBy(xpath="//*[@id=\"dashboard-analytics\"]/form/div[2]/div[2]/fieldset/div[5]/div[2]/div[1]/div")
//	WebElement CountryDropdown;
	
//	@FindBy(xpath="//form/div[2]/div[2]/fieldset/div[5]/div[2]/div/div")
//	WebElement CountryDropdown;
	
	@FindBy(css="#dashboard-analytics > form > div.row > div.ml-.col-12.col-md-8 > fieldset > div:nth-child(5) > div.col-12.col-md-8 > div")
	WebElement CountryDropdown;
	
	
	@FindBy(xpath="//*[@id='dashboard-analytics']/form/div[2]/div[2]/fieldset/div[6]/div[2]/div/div/div[1]/div[2]")
	WebElement StateDropdown;
	
	@FindBy(xpath="//*[@id=\"dashboard-analytics\"]/form/div[2]/div[2]/fieldset/div[7]/div[2]/div/div/div[1]/div[2]")
	WebElement CityDropdown;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="image")
	WebElement Image;
	
	@FindBy(xpath="//form/div[2]/div/div[2]/span")
	WebElement ImageError;
	
	public void clickOnUserManagement()
	{
		userManagement.click();
	}
	
	public void clickOnAddUserButton()
	{
		addUser.click();
	}
	
	public void clickOnSubmitButton()
	{
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
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".select__input-container.css-vwja0k")).sendKeys("ind");
		Robot r = new Robot();
		//r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyPress(0);
//		CountryDropdown.sendKeys("ind");
		Thread.sleep(2000);
		//CountryDropdown.sendKeys(Keys.ARROW_DOWN.ENTER);
//		List<WebElement> options = driver.findElements(By.cssSelector(".select__single-value div"));
//		for(WebElement option :options)
//		{
//			//4. Use getText to get text of all the options, and see if it's matched to real value
//			if (option.getText().equalsIgnoreCase("india"))
//			{
//				//5. And blindly click on matched value and then break to come out from loop
//				option.click();
//				break;
//			}
//			
//		}
//		s = new Select(CountryDropdown);
//		s.selectByValue("India");
	}
	
	public void selectState() throws InterruptedException, AWTException
	{
		StateDropdown.click();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	public void selectCity() throws InterruptedException, AWTException
	{
		CityDropdown.click();
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
	}
	
	public void enterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public void chooseImageFile(String image)
	{
		Image.sendKeys(image);
	}
	
	public void getImageError()
	{
		String error = ImageError.getText();
		System.out.println(error);
	}
}
