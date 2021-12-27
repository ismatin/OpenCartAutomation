package com.OpenCartAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	//1. Initialise webdriver
	
	public WebDriver driver;
	
	
	//2. Constructor
	
	public LoginPage(WebDriver driver) {
		
		driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//3. Page Objects
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myaccount;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(id="input-email")
	WebElement txtEmail;

	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement btnLogin;
	
	
	//4. Action Methods
	
	
	public void clickMyAccount() {
		
		myaccount.click();
		
	}
	
	
	public void clickLogin() {
		
		login.click();
	}
	
	
	public void setEmail(String email) {
		
		txtEmail.sendKeys(email);
		
	}
	
	
	public void setPassword(String password) {
		
		txtPassword.sendKeys(password);
		
	}
	
	
	public void clickLoginBtn() {
		
		
		btnLogin.click();
	}
	
	

}
