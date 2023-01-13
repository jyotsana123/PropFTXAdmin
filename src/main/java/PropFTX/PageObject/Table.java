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
	
	@FindBy(xpath=("//*[@id=\"root\"]/div[1]/div[1]/div[3]/ul/li[2]/ul/div/li[1]/a"))
	WebElement listOption;
	
	public void clickOnList()
	{
		listOption.click();
	}
	
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
	
	public void getTotalRecords()
	{
	System.out.println("Total no. of recodrs are " +driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText().split(" ")[2]);
	}
}
