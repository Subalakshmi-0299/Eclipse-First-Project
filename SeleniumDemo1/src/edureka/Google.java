package edureka;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google {

	@Test
	public void google(){
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.click();
		search.sendKeys("Selenium");
		List<WebElement> suggessions = driver.findElements(By.xpath("//div[@role='presentation']"));
		for(WebElement e:suggessions) {
			String text =	e.getText();
			System.out.println(text);
			if(text.contains("webdriver")) {
				e.click();
				break;
			}
		}
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(WebElement links:allLinks) {
			
			System.out.println(links.getText());
		}
		driver.close();
	}

}
