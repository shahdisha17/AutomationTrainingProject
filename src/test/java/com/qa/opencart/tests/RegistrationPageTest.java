package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void setUpRegister() {
		registerpage= loginPage.doRegister();
	}
	
	/*
	 * @Test public void getRegPageTitleTest() {
	 * System.out.println(registerpage.getRegisterPageTitle()); }
	 */

	@DataProvider
	public Object[][] getRegisterData() {
		Object regData [][] = ExcelUtil.getSheetData(Constants.SHEET_NAME);
		return regData;
	}
	@Test(dataProvider="getRegisterData")
	public void userRegistrationTest(String firstname, String lastname, String telephone, String password, String subscribe) { 
		  Assert.assertTrue(registerpage.registerAccount(firstname, lastname, telephone, password, subscribe)); 
	}
	 
	
}
