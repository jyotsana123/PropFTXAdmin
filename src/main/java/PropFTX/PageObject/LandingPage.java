package PropFTX.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PropFTX.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='loginEmail']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement forgotpageEmail;
			
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//small[text()='Forgot Password?']\"")
	WebElement forgotpasswordlink;
	
	public void openWebsite()
	{
		driver.get("https://propftxdevadmin.iworklab.com/login");
	}
	
	public void enterEmailPassword(String Email, String Password)
	{
		email.sendKeys(Email);
		password.sendKeys(Password);
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	
	public void enterEmail(String Email)
	{
		forgotpageEmail.sendKeys(Email);
	}
	
	public void clickOnForgotPassword()
	{
		forgotpasswordlink.click();
	}
	
	

}
