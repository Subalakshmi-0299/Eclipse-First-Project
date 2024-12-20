package edureka;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class URLOpenWithoutgetAndnavigate {
	@Test
	public void urlopen() {
		WebDriver driver = new ChromeDriver();
		String url = "https://www.google.com";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location=\'"+ url +"\'");
		//js.executeScript("window.location=\'https://www.google.com\'");
	}
}
