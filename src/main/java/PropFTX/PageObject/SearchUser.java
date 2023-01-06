package PropFTX.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PropFTX.AbstractComponent.AbstractComponent;

public class SearchUser extends AbstractComponent {
	
	WebDriver driver;
	public SearchUser(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id=("search-input"))
	WebElement SearchBox;
	
	@FindBy(xpath=("//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul/li[2]/ul/div/li[1]/a"))
	WebElement listOption;
	
	@FindBy(xpath=("//div[text()='There are no records to display']"))
	WebElement noResultText;
	
	public String getNoResultText()
	{
		return noResultText.getText();
	} 
	
	public void clickOnListOption()
	{
		listOption.click();
	}
	
	public void enterName(String name)
	{
		SearchBox.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		SearchBox.sendKeys(email);
	}
	
	public void enterPhoneNumber(String phonenumber)
	{
		SearchBox.sendKeys(phonenumber);
	}
	
	public void enterInvalidData(String invalid)
	{
		SearchBox.sendKeys(invalid);
	}

}
