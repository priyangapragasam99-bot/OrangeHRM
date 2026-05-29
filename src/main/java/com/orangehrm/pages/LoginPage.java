package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.ActionDriver.ActionDriver;

public class LoginPage {
	private ActionDriver actionDriver;
	
	//Define locators using By class
	
	private By userNameField = By.name("username");
	private By passwordField = By.cssSelector("input[type='password']");
	private By loginButton = By.cssSelector(".oxd-button");
	private By errorMessage = By.cssSelector("p[class*='oxd-text oxd-text--p oxd-alert-content-text']");
	private By emptyFieldRequiredError=By.cssSelector("span[class*='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
	private By forgetPassword=By.cssSelector("p[class*='oxd-text oxd-text--p orangehrm-login-forgot-header']");
	
	//initialize the action driver object by passing webdriver instance
	public LoginPage(WebDriver driver)
	{
		this.actionDriver = new ActionDriver(driver);
	}
	
	//Method to perform login
	public void login(String userName, String password)
	{
		actionDriver.enterText(userNameField, userName);
		actionDriver.enterText(passwordField, password);
		actionDriver.click(loginButton);
	}
	
	//Method to validated the required error
	public String requiredError()
	{
		return actionDriver.getText(emptyFieldRequiredError);
	}
	
	//Method to check if the error mesage is displayed	
	public boolean isErrorMessageDisplayed()
	{
		return actionDriver.isDisplayed(errorMessage);
	}
	
	//Method to get the text from error message	
	public String getErrorTextMessage()
	{
		return actionDriver.getText(errorMessage);
	}
	
	//Verify if error message is correct or not	
	public void verifyErrorMessage(String expectedError)
	{
		actionDriver.compareTwoText(errorMessage, expectedError);
	}
	
	//navigate to forget password
	public void navigateToForgetPassword()
	{
		actionDriver.click(forgetPassword);
	}
}
