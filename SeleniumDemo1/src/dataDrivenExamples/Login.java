package dataDrivenExamples;
import java.io.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	WebDriver driver;
	String [][] data = null;
	/*
	 * String [][] data = {{"Admin", "admin123"}, {"Admin", "Invalid"}, {"Invalid",
	 * "admin123"}, {"Invalid", "Invalid"}};
	 */
	
	@DataProvider(name="LoginData")
	public String[][] loginData() throws BiffException, IOException {
		String[][] data = getExcelData();
		return data;
	}
	
	public String[][] getExcelData() throws BiffException, IOException{
		FileInputStream fis = new FileInputStream("D:\\Suba1\\login.xls");	
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sheet = wb.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();
		String[][] data= new String[rowCount-1][columnCount];
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				data[i-1][j] = sheet.getCell(j,i).getContents();
			}
		}
		return data;
				
	}
	
	@BeforeTest
	public void beforetest() {
		driver = new ChromeDriver();
		
		//maximize the web browser
		driver.manage().window().maximize();
		
		//Wait implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test(dataProvider = "LoginData")
	public void bothValid(String uname, String pword) {
		
		//open the URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//pass the username in the username section
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(uname);
		
		//pass the password in the password section
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pword);
		
		//Click the Submit buttom
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
}
