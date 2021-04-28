package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;

public class AddToCartPage {

	WebDriver driver;
	ElementUtil elementUtil;
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
	}
}
