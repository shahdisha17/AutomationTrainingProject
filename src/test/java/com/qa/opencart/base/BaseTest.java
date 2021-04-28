package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DataFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchProductPage;
//This is base class
public class BaseTest {

	DataFactory df;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public SearchProductPage searchProductPage;
	public ProductInfoPage productInfopage;
	public RegistrationPage registerpage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		df = new DataFactory();
	    prop = df.init_prop();
	    prop.setProperty("browser", browserName);
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
