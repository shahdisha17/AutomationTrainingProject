package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
public class LoginPageTest extends BaseTest {
	
	@DataProvider
	public Object[][] loginNegativeData(){
		return new Object[][] {{"test@@gtyey.com","teyytety"},
									{" ","67357635"},
										{" ", " "}};
	}
	
	
	@Description("Login with negative Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0,dataProvider = "loginNegativeData")
	public void loginWithNegData(String un, String pwd) {
		loginPage.LoginWithWrongData(un, pwd);

	}
	
	@Description("Login page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void getLoginPageTitleTest() {
		String title= loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Login page URL Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void getLoginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL));
	}
	
	@Description("Forgot password link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	public void verifyForgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Description("Login page Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
}
