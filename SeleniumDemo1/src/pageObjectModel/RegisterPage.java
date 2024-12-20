package pageObjectModel;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RegisterPage {
	@Test
	public void register() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.automationtesting.in/Register.html");
		
		PageFactory.initElements(driver, RegisterPOM.class);
		
		RegisterPOM.firstName.sendKeys("Suba");
		RegisterPOM.phone.sendKeys("7010703738");
		WebElement radBtn = RegisterPOM.radBtn;
		if(!radBtn.isSelected())
			{ radBtn.click(); 
			}
		
		List<WebElement> checkBoxes = RegisterPOM.checkBoxes;
		for(WebElement checkBox : checkBoxes) { 
			if(!checkBox.isSelected()) {
				checkBox.click(); 
				} 
			}
		RegisterPOM.dropdownClick.click();
		
		List<WebElement> dropdownSelect = RegisterPOM.dropdownSelect;
		for(WebElement value : dropdownSelect) {
			 if(value.getText().contains("Thai")) { 
				 value.click(); 
				 } 
			 }
		
		/*
		 * RegisterPOM.firstName(driver).sendKeys("Suba");
		 * RegisterPOM.phone(driver).sendKeys("7010703738");
		 * 
		 * WebElement radioBtn = RegisterPOM.radBtn(driver); if(!radioBtn.isSelected())
		 * { radioBtn.click(); }
		 * 
		 * List<WebElement> checkBoxes = RegisterPOM.checkBoxes(driver); for(WebElement
		 * checkBox : checkBoxes) { if(!checkBox.isSelected()) { checkBox.click(); } }
		 * 
		 * RegisterPOM.dropdownClick(driver).click(); List<WebElement> dropdownSelect =
		 * RegisterPOM.dropdownSelect(driver); for(WebElement value : dropdownSelect) {
		 * if(value.getText().contains("Thai")) { value.click(); } }
		 */
	}
}
