package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class POMWithoutFindElement {
	public static WebElement placeholder;
	public static WebElement radiooptions;
	
	@Test
	public void pageOpen() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Register.html");
	
	PageFactory.initElements(driver, POMWithoutFindElement.class);
	//placeholder.sendKeys("Suba");
	radiooptions.click();
	}
}
