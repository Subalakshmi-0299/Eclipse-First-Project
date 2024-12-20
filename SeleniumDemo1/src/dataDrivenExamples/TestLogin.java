package dataDrivenExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.CellValue;

public class TestLogin {
	WebDriver driver;
	//String [][] data = null;
	
	
	/*
	 * public String[][] getData() throws BiffException, IOException{ String[][]
	 * data =loginData(); return data;
	 * 
	 * }
	 */
	
	@DataProvider (name="login")
	public String[][] loginData() throws BiffException, IOException {
		FileInputStream file = new FileInputStream("D:\\Suba1\\Logintext.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();
		String[][] data = new String[rowCount-1][columnCount];
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<columnCount;j++) {
				data[i-1][j] = sheet.getCell(j,i).getContents();
			}
		}
		return data;
		
		
	}
	
	@BeforeTest
	public void driverOpen() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test(dataProvider = "login")
	public void login(String uname, String pword) {		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pword);
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}
