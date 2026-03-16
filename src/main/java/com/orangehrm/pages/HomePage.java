package com.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.ActionDriver.ActionDriver;

public class HomePage {
	
private ActionDriver actionDriver;
	
	//Define locators using By class
	
	private By admin = By.xpath("//span[text()='Admin']");
	private By userIdButton = By.className("oxd-userdropdown-name"); 
	private By LogoutButton = By.xpath("//a[text()='Logout']");
	private By logo = By.cssSelector("img[alt='client brand banner']");
	
	//initialize the action driver object by passing webdriver instance
	public HomePage(WebDriver driver)
	{
		this.actionDriver = new ActionDriver(driver);
	}
	
	//method to verify if admin tab is visible
	public boolean isAdminTabVisible()
	{
		return actionDriver.isDisplayed(admin);
	}
	
	//method to verify if logo is visible
	public boolean verifyOrangeHrmLogo()
	{
		return actionDriver.isDisplayed(logo);
	}
	
	//method to perform logout operation
	public void logout()
	{
		actionDriver.click(userIdButton);
		actionDriver.click(LogoutButton);
	}
	
	
}
