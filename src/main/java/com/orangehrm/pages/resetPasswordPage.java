package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.ActionDriver.ActionDriver;

public class resetPasswordPage {
	private ActionDriver actionDriver;
	
	private By resetTitle = By.cssSelector("h6[class*='oxd-text oxd-text--h6 orangehrm-forgot-password-title']");
	private By userName = By.cssSelector("input[name='username']");
	private By submitButton = By.cssSelector("button[type='submit']");
	private By cancelButton = By.cssSelector("button[type='button']");
	
	public resetPasswordPage(WebDriver driver)
	{
		this.actionDriver = new ActionDriver(driver);
	}
	
	public String getTitle()
	{
		return actionDriver.getText(resetTitle);
	}
	
	public void resetDetails(String user)
	{
		actionDriver.enterText(userName, user);
		actionDriver.click(cancelButton);
	}

}
