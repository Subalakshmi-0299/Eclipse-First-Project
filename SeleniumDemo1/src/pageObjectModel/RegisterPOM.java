package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPOM {
	
	@FindBy(how=How.XPATH, using = "//input[@placeholder='First Name']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@type='tel']")
	public static WebElement phone;
	
	@FindBy(xpath = "//input[@type='radio']")
	public static WebElement radBtn;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public static List<WebElement> checkBoxes;
	
	@FindBy(id="msdd")
	public static WebElement dropdownClick;
	
	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li")
	public static List<WebElement> dropdownSelect;
	
	
	
	/*
	 * public static WebElement firstName(WebDriver driver){ return
	 * driver.findElement(By.xpath("//input[@placeholder='First Name']")); }
	 * 
	 * public static WebElement phone(WebDriver driver){ return
	 * driver.findElement(By.xpath("//input[@type='tel']")); }
	 * 
	 * public static WebElement radBtn(WebDriver driver){ return
	 * driver.findElement(By.xpath("//input[@type='radio']")); }
	 * 
	 * public static List<WebElement> checkBoxes(WebDriver driver){ return
	 * driver.findElements(By.xpath("//input[@type='checkbox']")); }
	 * 
	 * public static WebElement dropdownClick(WebDriver driver){ return
	 * driver.findElement(By.id("msdd")); }
	 * 
	 * public static List<WebElement> dropdownSelect(WebDriver driver){ return
	 * driver.findElements(By.
	 * xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li"
	 * )); }
	 */
}
