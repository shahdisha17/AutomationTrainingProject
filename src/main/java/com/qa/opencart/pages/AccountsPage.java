package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	//private By locators
	private By accHeader = By.cssSelector("div#content h2");
	private By header = By.cssSelector("div#logo a");
	private By accTextLink = By.xpath("//div[@class='list-group']//a[text()='My Account']");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getAccountspagetitle() {
		return elementUtil.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public String getAccountPageUrl() {
		return elementUtil.getPageUrl();
	} 
	
	public boolean isMyAccountLinkExist() {
		return elementUtil.doIsDisplayed(accTextLink);
	} 
	
	public List<String> accHeaderSection() {
		List<String> sectionListVal = new ArrayList<String>();
		List<WebElement> sectionList = elementUtil.waitForVisibilityOfElements(accHeader, 5);
		for(WebElement e:sectionList) {
			String text = e.getText();
			sectionListVal.add(text);
		}
		return sectionListVal;
	}
	

	public SearchProductPage doSearch(String productName) {
		System.out.println("Search product name is :" +productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		 
		return new SearchProductPage(driver);
		 
	}
}
