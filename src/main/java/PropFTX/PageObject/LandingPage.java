package PropFTX.PageObject;

import org.openqa.selenium.By;
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
			
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//small[text()='Forgot Password?']")
	WebElement forgotpasswordlink;
	
	@FindBy(css=".invalid-feedback")
	WebElement emailError;
	
	@FindBy(xpath="//div[text()='Please enter Password']")
	WebElement passwordError;
	
	@FindBy(css="svg[stroke='currentColor']")
	WebElement eyeIcon;
	
	public void checkPasswordVisibility()
	{
		//Password field, We want to get the type attribute from password field
		String typeAttribute1 =  password.getAttribute("type");
		System.out.println(typeAttribute1);
		
		//Click on eye icon, password is visible
		eyeIcon.click();
		
		//Password field, We want to get the type attribute from password field again after displaying the password
		String typeAttribute2 =  password.getAttribute("type");
		System.out.println(typeAttribute2);
		
		if(typeAttribute2.equalsIgnoreCase("text"))
		{
			System.out.println("Password is visible");
		}
			else {
				System.out.println("Password is not visible");
			}
		
	}
	
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
	
	public String getEmailError()
	{
		System.out.println(emailError.getText());
		return emailError.getText();
	}
	
	public String getPasswordError()
	{
		System.out.println(passwordError.getText());
		return passwordError.getText();
	}
	
	

}
