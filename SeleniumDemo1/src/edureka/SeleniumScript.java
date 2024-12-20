package edureka;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

public class SeleniumScript extends ListenersExample{
		public static void main(String[] args) throws InterruptedException {
		String actualTitle = "Automation Exercise";
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.automationexercise.com/");
		//wait.until(ExpectedConditions.titleContains("Automation"));
		
		//FluentWait
		/*Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
								.pollingEvery(Duration.ofSeconds(3))
								.ignoring(NoSuchElementException.class);
		wait1.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(""));
			}
		});*/
		
		String getTitle = driver.getTitle(); 
		System.out.println(getTitle);
		driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]")).click();
		
		WebElement search = driver.findElement(By.xpath("//input[@id='search' and @type='text']"));
		search.click();
		search.sendKeys("Selenum Testng");
		List<WebElement> suggesions = driver.findElements(By.xpath("//li[@role='presentation']"));
		
		//get the suggessions based on the text
		for(WebElement e: suggesions) {
			String text= e.getText();
			System.out.println(text);
			if(text.contains("interview")) {
				e.click();
				break;
			}
		}
		//get the suggessions based on the index
		/*int position = 0;
		for(WebElement e : suggesions) {
			String text = e.getText();
			System.out.println(text);
			position++;
			if(position == 3) {
				e.click();
				Thread.sleep(2000);
				break;
			}
		}*/
		
		//collect all links in the web page
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(WebElement links: allLinks) {
			String link= links.getText();
			System.out.println(link);
		}
		
		driver.close();
	}
}
