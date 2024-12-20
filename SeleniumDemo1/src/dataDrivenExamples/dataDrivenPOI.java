package dataDrivenExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;

public class dataDrivenPOI {
	
	static List<String> username = new ArrayList<String>();
	static List<String> password = new ArrayList<String>();
	public void getExcelData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Suba1\\login1.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		
		Iterator<Row> rowIterator = sheet.iterator();
		int i=2;
		while(rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			while(columnIterator.hasNext()) {
				if(i%2==0) {
					username.add(columnIterator.next().toString());
				}
				else {
					password.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
		}
	}
	
	public void login(String uname, String pword) {
		
		WebDriver driver = new ChromeDriver();
		
		//maximize the web browser
		driver.manage().window().maximize();
		
		//Wait implicit time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
		driver.quit();
	}
	
	public void executeTest() {
		for(int i=0;i<username.size(); i++) {
			login(username.get(i), password.get(i));
		}
	}
	
	public static void main(String[] args) throws IOException {
		dataDrivenPOI usingPOI = new dataDrivenPOI();
		usingPOI.getExcelData();
		System.out.println("User Name List: "+ username);
		System.out.println("password List:" + password);
		usingPOI.executeTest();
	}
}
