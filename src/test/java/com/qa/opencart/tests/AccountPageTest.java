package com.qa.opencart.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}

	@Test(priority = 1)
	public void getAccountsPagetitleTest() {
		String accPageTitle = accountsPage.getAccountspagetitle();
		Assert.assertEquals(accPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void getAccountsPageUrlTest() {
		String accPageUrl = accountsPage.getAccountPageUrl();
		Assert.assertTrue(accPageUrl.contains(Constants.ACCOUNTS_PAGE_URL));
	}
	
	@Test(priority = 3)
	public void verifyMyAccountLinkExistTest() {
		Assert.assertTrue(accountsPage.isMyAccountLinkExist());
	}
	
	@Test(priority = 4)
	public void verifyAccHeaderSectionTest() {
		List<String> headersection = accountsPage.accHeaderSection();
		headersection.stream().forEach(e-> System.out.println(e));
		Collections.sort(headersection);
		Assert.assertEquals(headersection, Constants.EXP_ACCOUNTS_SEC_LIST);
	}
}
