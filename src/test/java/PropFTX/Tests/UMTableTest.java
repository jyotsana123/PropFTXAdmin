package PropFTX.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PropFTX.PageObject.AddUser;
import PropFTX.PageObject.Table;
import PropFTX.TestComponent.BaseTest;

public class UMTableTest extends BaseTest {

	public Table table;

	@BeforeMethod
	public void table() {
		lp.openWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		AddUser adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		table = new Table(driver);
		table.clickOnList();

	}

	//@Test
	public void getRowColoumnCount() {
		table.getRowCount();
		table.getColoumnCount();
	}

	// @Test
	public void totalNumOfPages() throws InterruptedException, IOException {
		List<WebElement> pages = driver.findElements(By.cssSelector("a[aria-label*='Page']"));
		System.out.println(pages.size());

		for (int i = 1; i <= pages.size(); i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");
			WebElement activePage = driver.findElement(By.cssSelector("li[class*='page-item'] a[rel='canonical']"));
			System.out.println("Active page is " + activePage.getText());
			// activePage.click();
			table.getRowCount();
			Thread.sleep(2000);
//			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(srcFile, new File("C:/Pictures/screenshot.png"));
			String pagenum = Integer.toString(i + 1);
			Thread.sleep(2000);

			WebElement pageno = driver
					.findElement(By.xpath("//ul[@aria-label='Pagination']//li//a[text()='" + pagenum + "']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(pageno).click().build().perform();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:/Pictures/screenshot.png"));
			// wait.until(ExpectedConditions.elementToBeClickable(pageno));
			// table.getRowCount();
		}
	}

	// @Test
	public void nextPageArrow() throws IOException, InterruptedException {

		Thread.sleep(2000);
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		for (int i = 0; i < 5; i++) {
//				Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");
			driver.findElement(By.cssSelector("a[aria-label='Next page']")).click();
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:/Pictures/screenshot.png"));
		}
	}

	//@Test
	public void getRowValues() throws InterruptedException {

		driver.findElement(By.cssSelector(".d-flex.align-items-center.active")).click();
		Thread.sleep(3000);
		List<WebElement> name = driver.findElements(By.cssSelector("#cell-2-undefined"));
		for (int i = 0; i < name.size(); i++) {
			String array = name.get(i).getText();
			System.out.println(array);
		}
		// document.getElementBycssSelector("a[aria-label='Next
		// page']").scrollIntoView();
		WebElement nextPage = driver.findElement(By.cssSelector("a[aria-label='Next page']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", nextPage);

		String nextButtonAttribute = driver.findElement(By.cssSelector("a[aria-label='Next page']"))
				.getAttribute("aria-disabled");
		while (nextButtonAttribute.contains("false")) {
			driver.findElement(By.cssSelector("a[aria-label='Next page']")).click();
		}
	}

	//@Test
	public void getTotalRecords()
	{
		table.getTotalRecords();		
	}
	
//	@Test
	public void clickOnNextPage() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
		String index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
		
		List<WebElement> name = driver.findElements(By.cssSelector("#cell-2-undefined"));
		for (int i = 0; i < name.size(); i++) {
			String array = name.get(i).getText();
			System.out.println(array);
		}
			while(index.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='next page']")).click();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
			List<WebElement> names = driver.findElements(By.cssSelector("#cell-2-undefined"));
			for (int i = 0; i < names.size(); i++) {
				String array = names.get(i).getText();
				System.out.println(array);
			}
		}
	}
	
	//@Test(dependsOnMethods="clickOnNextPage()")
	public void clickOnPreviousPage() throws InterruptedException
	{
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//     	js.executeScript("window.scrollBy(0,800)");
//		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
		String index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		while(index2.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='previous page']")).click();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		}
	}
	
	@Test
	public void previouspagearrowClick() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		String index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
		while(index.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='next page']")).click();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
		}
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		String index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		while(index2.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='previous page']")).click();
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		}
		
		
	}
	@Test
	public void previouspagearrowClick2() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		String index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
		while(index.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='next page']")).click();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index = driver.findElement(By.cssSelector("button[aria-label='next page']")).getAttribute("tabindex");
		}
		Thread.sleep(2000);
//		Actions a = new Actions(driver);
//		a.sendKeys(Keys.PAGE_UP).build().perform();
//		Thread.sleep(2000);
		String index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		while(index2.equalsIgnoreCase("0"))
		{
			driver.findElement(By.cssSelector("button[aria-label='previous page']")).click();
			Thread.sleep(2000);
			//a.sendKeys(Keys.PAGE_DOWN).build().perform();
			System.out.println(driver.findElement(By.xpath("//div/div/div/div[3]/div[2]/nav/div/p[2]")).getText());
			index2 = driver.findElement(By.cssSelector("button[aria-label='previous page']")).getAttribute("tabindex");
		}
		
		
	}
}
