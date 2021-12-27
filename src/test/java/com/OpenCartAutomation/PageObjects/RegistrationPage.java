package com.OpenCartAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {


	//1. webdriver initialization

	public static WebDriver driver;


	//2. Constructor

	public RegistrationPage(WebDriver driver) {

		driver=driver;
		PageFactory.initElements(driver, this);

	}

	//3. Page Objects

	@FindBy(linkText="My Account")
	WebElement myaccount;


	@FindBy(linkText="Register")
	WebElement register;

	@FindBy(xpath="//*[@id=\"account-register\"]/ul/li[3]/a")
	WebElement registerBreadcrumb;

	@FindBy(xpath="//ul[@class='breadcrumb']//li[2]//a[contains(text(),'Account')]")
	WebElement accountBreadcrumb;

	@FindBy(id="input-firstname")
	WebElement txtFirstname;

	@FindBy(id="input-lastname")
	WebElement txtLastname;

	@FindBy(id="input-email")
	WebElement txtEmail;

	@FindBy(id="input-telephone")
	WebElement txtTelephone;

	@FindBy(id="input-password")
	WebElement txtPassword;

	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;


	@FindBy(xpath="//input[@name='agree']")
	WebElement checkboxPrivacy;

	@FindBy(xpath="//input[@Type='submit']")
	WebElement btnContinue;

	@FindBy(xpath="//input[@name='newsletter' and @value=1]")
	WebElement subscriptionYes;

	@FindBy(xpath="//div[@id='content']//p[1]")
	WebElement details1;

	@FindBy(xpath="//div[@id='content']//p[2]")
	WebElement details2;

	@FindBy(xpath="//div[@id='content']//p[3]")
	WebElement details3;

	@FindBy(xpath="//div[@id='content']//p[4]")
	WebElement details4;

	@FindBy(xpath="//div[@class='pull-right']//a[contains(text(),'Continue')]")
	WebElement btnContinue_RegisteredPage;

	////ul[@class='list-unstyled']//li//a[contains(text(),'Subscribe / unsubscribe to newsletter')]
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	WebElement sunbscribeLink;

	@FindBy(xpath="//div[@class='pull-right']//input[@type='submit']")
	WebElement continueBtn_NewsletterSub;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement titleSuccess;






	//------------------------------Action Methods------------------------------


	public boolean Validate_Details1() {

		return details1.isDisplayed();

	}


	public boolean Validate_Details2() {

		return details2.isDisplayed();
	}

	public boolean Validate_Details3() {

		return details3.isDisplayed();

	}

	public boolean Validate_Details4() {

		return details4.isDisplayed();

	}





	public void click_MyAccount() {

		myaccount.click();

	}

	public void click_Register() {

		register.click();

	}


	public void set_FirstName(String firstname) {

		txtFirstname.sendKeys(firstname);
	}

	public void set_Lastname(String lastname) {

		txtLastname.sendKeys(lastname);
	}

	public void set_Email(String email) {

		txtEmail.sendKeys(email);
	}


	public void set_Telephone(String telephone) {

		txtTelephone.sendKeys(String.valueOf(telephone));

	}


	public void set_Password(String password) {

		txtPassword.sendKeys(password);

	}

	public void set_ConfirmPassword(String confirmpassword) {

		txtConfirmPassword.sendKeys(confirmpassword);

	}


	public void click_PrivacyPolicy() {

		checkboxPrivacy.click();

	}


	public void click_ContinueBtn() {

		btnContinue.click();

	}


	public void click_SubscriptionRegisterAccount() {

		subscriptionYes.click();
	}


	public void click_btnContinueRegistrationPage() {

		btnContinue_RegisteredPage.click();
	}


	public void click_subscriptionLink() {

		sunbscribeLink.click();
	}


	public void click_continueBtn_NewsletterSub() {

		continueBtn_NewsletterSub.click();
	}


	
	public boolean Validate_SubscriptionYes() {
		
		
		return subscriptionYes.isSelected();
	}


	
	
	
	
}
