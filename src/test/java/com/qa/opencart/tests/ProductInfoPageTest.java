package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class ProductInfoPageTest extends BaseTest{
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void productPageSetUp() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] searchData(){
		return new Object[][] {{"Macbook"},{"iMac"},{"iPhone"}};
	}
	
	@Test(dataProvider ="searchData")
	public void searchProductAndCountTest(String productName) {
		searchProductPage = accountsPage.doSearch(productName);
		Assert.assertTrue(searchProductPage.searchTotalNumberOfProducts()>0);
	}

	@Test
	public void getProductInfoTest() {
		searchProductPage = accountsPage.doSearch("Macbook");
		productInfopage = searchProductPage.selectProductFromList("MacBook Pro");
		Map<String, String> actProductMetaData = productInfopage.getProductInformation();
		actProductMetaData.forEach((k, v) -> System.out.println(k + " : " + v));

		softAssert.assertEquals(actProductMetaData.get("name"), "MacBook Pro");
		softAssert.assertEquals(actProductMetaData.get("Brand"), "Apple");
		softAssert.assertEquals(actProductMetaData.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(actProductMetaData.get("price"), "$2,000.00");

		softAssert.assertAll();
	}

}
