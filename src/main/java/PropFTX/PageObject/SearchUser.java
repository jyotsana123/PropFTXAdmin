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
	
	public void enterName(String name)
	{
		SearchBox.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		SearchBox.sendKeys(email);
	}
	
	public void enterInvalidData(String invalid)
	{
		SearchBox.sendKeys(invalid);
	}

}