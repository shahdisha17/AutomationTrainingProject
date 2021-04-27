package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class SearchProductPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By SearchItemResult = By.cssSelector("div.product-thumb");
	private By resultsItems = By.cssSelector("div.product-thumb h4 a");
	
	
	public SearchProductPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public int searchTotalNumberOfProducts() {
		return elementUtil.getElements(SearchItemResult).size();
	}
	
	public ProductInfoPage selectProductFromList(String productName) {
		List<WebElement> productList = elementUtil.getElements(resultsItems);
		for(WebElement e:productList) {
			if(e.getText().equals(productName)){
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}
}
