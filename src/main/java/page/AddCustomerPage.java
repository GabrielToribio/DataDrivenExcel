package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/form/div[1]/div/div[1]") WebElement HEADER_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"social-sidebar-menu\"]/li[5]/a") WebElement ACCOUNTS_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ACCOUNTS\"]/li[3]/a") WebElement CUSTOMERS_BUTTON;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") WebElement ADD_CUSTOMER_BUTTON;
	@FindBy(how = How.XPATH, using = "//input[@name='fname']") WebElement FIRST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='lname']") WebElement LAST_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='email']") WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='mobile']") WebElement MOBILE_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='address1']") WebElement ADDRESS1_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='address2']") WebElement ADDRESS2_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"s2id_autogen1\"]/a") WebElement COUNTRY_DROP_DOWN;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/div/input") WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@name='newssub']") WebElement NEWS_SUB_CHECKBOX;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-block btn-lg']") WebElement SUBMIT_BUTTON;
	
	//Interactive Methods
	public void goToAddCustomerPage() throws InterruptedException {
		waitForElement(driver, 3, ACCOUNTS_BUTTON);
		ACCOUNTS_BUTTON.click();
		CUSTOMERS_BUTTON.click();
		Thread.sleep(2000);
		ADD_CUSTOMER_BUTTON.click();
	}
	
	public void enterFullName(String firstName, String lastName) {
		waitForElement(driver, 3, FIRST_NAME_FIELD);
		FIRST_NAME_FIELD.sendKeys(firstName);
		LAST_NAME_FIELD.sendKeys(lastName);
	}
	
	public void loginInfo(String email, String password) {
		EMAIL_FIELD.sendKeys(email);
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void address(String line1, String line2) {
		ADDRESS1_FIELD.sendKeys(line1);
		ADDRESS2_FIELD.sendKeys(line2);
	}
	
	public void selectCountry(String country) {
		COUNTRY_DROP_DOWN.click();
		waitForElement(driver, 3, COUNTRY_FIELD);
		COUNTRY_FIELD.sendKeys(country);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void submit() {
		waitForElement(driver, 3, SUBMIT_BUTTON);
		SUBMIT_BUTTON.click();
	}
	
}
