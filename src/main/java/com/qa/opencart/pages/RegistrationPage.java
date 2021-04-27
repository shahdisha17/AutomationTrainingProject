package com.qa.opencart.pages;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telePhone = By.id("input-telephone");
	private By passWord = By.id("input-password");
	private By confPassWord = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//div[@class='col-sm-10']//label[@class='radio-inline'])[1]/input");
	private By subscribeNo = By.xpath("(//div[@class='col-sm-10']//label[@class='radio-inline'])[2]/input");
	private By agreeButton = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit']");
	private By registerAcoount = By.xpath("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	private By successMessg = By.cssSelector("div#content h1");
	
	public RegistrationPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	/*
	 * public void doSubscribeNewsletter(boolean value) { By subscribeButton = null;
	 * if(value) { subscribeButton = By.xpath(subscribe+"[1]"); } else {
	 * subscribeButton = By.xpath(subscribe+"[2]"); }
	 * elementUtil.doClick(subscribeButton); }
	 */
	
	public String getRegisterpageText() {
		return elementUtil.doGetText(registerAcoount);
	}
	
	public String getRegisterPageTitle() {
		return elementUtil.waitForTitle(5, Constants.REGISTER_PAGE_TITLE);
	}
	
	public static String getRandomEmail() {
		Random random = new Random();
		return "test"+random.nextInt(10000)+"@test.com";
	}
	
	public boolean registerAccount(String firstName, String lastName, String telePhone, String passWord, String subscribe) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, getRandomEmail());
		elementUtil.doSendKeys(this.telePhone, telePhone);
		elementUtil.doSendKeys(this.passWord, passWord);
		elementUtil.doSendKeys(this.confPassWord, passWord);
		
		if(subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		}
		else {
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(agreeButton);
		elementUtil.doClick(continueButton);
		String message = elementUtil.waitForElementVisible(successMessg, 5).getText();
		if(message.contains(Constants.REGISTER_USER_MESSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			
			return true;
		}
		return false;
	}
	
}
