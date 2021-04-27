package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;


public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	//private By locators
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By registerLink= By.xpath("//div[@class='list-group']/a[text()='Register']");
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//Constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Function which can we used in test class
	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public RegistrationPage doRegister() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	public AccountsPage doLogin(String un, String pw) {
		System.out.println("username : " +un  + " password : " +pw);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pw);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	public boolean LoginWithWrongData(String un, String pw) {
		System.out.println("username : " +un  + " password : " +pw);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pw);
		elementUtil.doClick(loginButton);
		
		return elementUtil.doIsDisplayed(loginErrorMessg);
		
	}

}
