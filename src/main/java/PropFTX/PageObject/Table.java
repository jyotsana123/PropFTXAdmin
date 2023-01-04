package PropFTX.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import PropFTX.AbstractComponent.AbstractComponent;

public class Table{

	WebDriver driver;
	public Table(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class*='table-bordered']")
	WebElement Table;
	
//	@FindBy(css="div[role='row']")
//	WebElement Row;
//	
//	@FindBy(css="div[role='columnheader']")
//	WebElement Coloumn;
	
	public void getRowCount()
	{
		System.out.println("Total no. of rows " +Table.findElements(By.cssSelector("div[role='row']")).size());
	}
	
	public void getColoumnCount()
	{
		System.out.println("Total no. of coloumns " +  Table.findElements(By.cssSelector("div[role='columnheader']")).size());
	}
	
}
