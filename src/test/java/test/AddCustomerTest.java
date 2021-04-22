package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;

	ExcelReader exlread = new ExcelReader("testdata\\PHP_TestData_Admin.xlsx");
	String firstName = exlread.getCellData("AddCustomerPage", "First Name", 2);
	String lastName = exlread.getCellData("AddCustomerPage", "Last Name", 2);
	String email = exlread.getCellData("AddCustomerPage", "Email", 2);
	String password = exlread.getCellData("AddCustomerPage", "Password", 2);
	String address1 = exlread.getCellData("AddCustomerPage", "Address Line 1", 2);
	String address2 = exlread.getCellData("AddCustomerPage", "Address Line 2", 2);
	String country = exlread.getCellData("AddCustomerPage", "Country", 2);

	@Test
	public void validateAddingCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.enterUserName("admin@phptravels.com");
		loginpage.enterPassword("demoadmin");
		loginpage.clickLoginButton();

		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage();
		
		AddCustomerPage addcustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomer.goToAddCustomerPage();
		addcustomer.enterFullName(firstName, lastName);
		addcustomer.loginInfo(email, password);
		addcustomer.address(address1, address2);
		addcustomer.selectCountry(country);
		addcustomer.submit();

//		BrowserFactory.tearDown();
	}

}
