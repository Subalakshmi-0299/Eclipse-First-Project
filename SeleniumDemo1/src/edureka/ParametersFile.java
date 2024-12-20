package edureka;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class ParametersFile {
	@Test
	@Parameters("param")
	public void param(String param) {
		System.out.println("Name is: "+ param);
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		String window = driver.getWindowHandle();
		System.out.println(window);
		System.out.println(driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement icon = driver.findElement(By.xpath("//div[@class='nDcEnd']"));
		wait.until(ExpectedConditions.elementToBeClickable(icon));
		icon.click();
		Set<String> windows = driver.getWindowHandles();
		for(String window1 : windows){
			System.out.println(window1);
		}
	}
}
