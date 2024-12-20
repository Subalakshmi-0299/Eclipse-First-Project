package edureka;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WithoutFindElement {
	static WebElement APjFqb;
	//public static void main(String[] args) {
	@Test
	public static void main() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		//driver.switchTo().activeElement().sendKeys("Selenium \n");
		PageFactory.initElements(driver, WithoutFindElement.class);
		APjFqb.sendKeys("Selenium \n");
		driver.close();
	}
}	
