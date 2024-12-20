package extendReportExample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtendReportSample {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest testCase;
	
	@BeforeSuite
	public void launchBrowser() {
		extentReports = new ExtentReports("extendReport.html");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void google() throws IOException {
		testCase = extentReports.startTest("Verify Google Title");
		testCase.log(LogStatus.INFO, "Navigating to Google");
		String actualTitle = "gogle";
		testCase.log(LogStatus.INFO, "Actual Title is: "+actualTitle);
		driver.get("https://www.google.com/");
		String getTitle = driver.getTitle();
		testCase.log(LogStatus.INFO, "Get Title is: "+getTitle);
		testCase.log(LogStatus.INFO, "Verification of Actual and ExpectedTitle");
		if(actualTitle.equals(getTitle)) {
			testCase.log(LogStatus.PASS, "Test Case Passed");
		}
		else {
			testCase.log(LogStatus.FAIL, "Test Case Failed");
			TakesScreenshot  ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("google.png");
			FileHandler.copy(srcFile, destFile);
			//testCase.addScreencast("google.png");
			testCase.addScreenCapture("google.png");
		}
	}
	
	@Test
	public void wikipedia() throws IOException {
		testCase = extentReports.startTest("Verify Wikipedia Title");
		testCase.log(LogStatus.INFO, "Navigating to wikipedia");
		String actualTitle = "Wikipedia";
		testCase.log(LogStatus.INFO, "Actual Title is: "+actualTitle);
		driver.get("https://www.wikipedia.org/");
		String getTitle = driver.getTitle();
		testCase.log(LogStatus.INFO, "Get Title is: "+getTitle);
		testCase.log(LogStatus.INFO, "Verification of Actual and ExpectedTitle");
		if(actualTitle.equals(getTitle)) {
			testCase.log(LogStatus.PASS, "Test Case Passed");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("wikipedia.png");
			FileHandler.copy(srcFile, destFile);
			testCase.addScreenCapture("wikipedia.png");
			//testCase.addScreencast("wiki.png");
		}
		else {
			testCase.log(LogStatus.FAIL, "Test Case Failed");
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("wikipedia.png");
			FileHandler.copy(srcFile, destFile);
			testCase.addScreenCapture("wikipedia.png");
			//testCase.addScreencast("wiki.png");
		}
	}
	
	@Test
	public void bing() throws IOException {
		testCase = extentReports.startTest("Verify Bing Title");
		testCase.log(LogStatus.INFO, "Navigating to Bing");
		String actualTitle = "Search - Microsoft Bing";
		testCase.log(LogStatus.INFO, "Actual Title is: "+actualTitle);
		driver.get("https://www.bing.com/");
		String getTitle = driver.getTitle();
		testCase.log(LogStatus.INFO, "Get Title is: "+getTitle);
		testCase.log(LogStatus.INFO, "Verification of Actual and ExpectedTitle");
		if(actualTitle.equals(getTitle)) {
			testCase.log(LogStatus.PASS, "Test Case Passed");
		}
		else {
			testCase.log(LogStatus.FAIL, "Test Case Failed");
			TakesScreenshot  ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File destFile = new File("bing.png");
			FileHandler.copy(srcFile, destFile);
			//testCase.addScreenCapture("bing.png");
		}
	}
	
	@AfterSuite
	public void quitBrowser() {
		driver.close();
		extentReports.flush();
	}
}
