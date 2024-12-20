package edureka;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NewWebPage{
	WebDriver driver;
	String getTitle = "Selenium Training";
	@BeforeTest
	public void driverOpen() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void getPage() {
		driver.get("file:///C:/Users/priya/Downloads/demo-1%20(1).html");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, getTitle);
		System.out.println("CurrrentTitle: "+actualTitle);
	}
	
	@Test(dependsOnMethods = "getPage")
	public void checkbox() {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @name ='download']"));
		for(WebElement checkBox : checkboxes) {
			checkBox.click();
		}
	}
	
	@Test (dependsOnMethods = "downloadLink")
	public void selectDropdown() {
		WebElement dropdown = driver.findElement(By.id("standard_cars"));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByValue("aud");
	}
	
	@Test(dependsOnMethods = "getPage")
	public void downloadLink() {
		String currentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//td[text()='Windows']//following-sibling::td[text()='3.140']//following-sibling::td//a")).click();
		Set<String> pages = driver.getWindowHandles();
		for(String page : pages) {
		driver.switchTo().window(page);
		String downloadTitle = driver.getTitle();
		if(!downloadTitle.equals(getTitle)) {
		System.out.println(downloadTitle);
		driver.close();
		}
		}
		driver.switchTo().window(currentWindow);
	}
	
	@Test
	public void samename() {
		List<WebElement> sameName = driver.findElements(By.name("fname"));
		for(WebElement getName : sameName) {
			getName.sendKeys("Suba");
		}
	}
	
	@Test(dependsOnMethods = "samename")
	public void webSite() {
		driver.findElement(By.xpath("//a[text()='Google']")).click();
	}
	
//	@AfterTest
//	public void driverClose() {
//		driver.close();
//	}
}

