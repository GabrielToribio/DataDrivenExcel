package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	
	ExcelReader exlread = new ExcelReader("testdata\\PHP_TestData.xlsx");
	String username = exlread.getCellData("LoginPage", "Username", 2);
	String password = exlread.getCellData("LoginPage", "Password", 2);
	
	@Test
	public void loginTest() {
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboardPage();
		
		BrowserFactory.tearDown();
	}
	
}
