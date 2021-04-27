package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	LoginPage loginPage;
	
	private By totalProdImages = By.className("ul.thumbnails li img");
	private By productImages = By.cssSelector("ul.thumbnails li img");
	private By productHeader = By.cssSelector("div#content h1");
	private By productMetaData = By.className("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.className("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By successMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	
	public ProductInfoPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public int totalNoProdImagesCount() {
		return elementUtil.getElements(totalProdImages).size();
	}
	
	public String getProductHeaderPageText() {
		return elementUtil.doGetText(productHeader);
	}
	
	public int getProductImagesCount() {
		return elementUtil.getElements(productImages).size();
	}
	
	public Map<String,String> getProductInformation() {
		Map<String,String> productList = new HashMap<String, String>();
		productList.put("name", getProductHeaderPageText());
		List<WebElement> metaDataList =elementUtil.getElements(productMetaData);
		System.out.println("Product list : " +metaDataList);
		for(WebElement e: metaDataList) {
			String[] meta= e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue= meta[1].trim();
			productList.put(metaKey, metaValue);
		}
		
		List<WebElement> priceDataList = elementUtil.getElements(productPriceData);
		String price =priceDataList.get(0).getText().trim();
		String Exprice =priceDataList.get(1).getText().trim();
		productList.put("price", price);
		productList.put("ExTaxprice", Exprice);
		
	return productList;	
	}
	 
	public void addQuantity(String qtyVal) {
		elementUtil.doSendKeys(quantity,qtyVal);
	}
	
	public void addProductToCart() {
		elementUtil.doClick(addToCartButton);
	}
	
	public String getSuccessMessageText() {
		return elementUtil.doGetText(successMessage);
	}
}
