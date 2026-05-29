package com.orangeHRM.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangeHRM.ActionDriver.ActionDriver;

public class EmployeeManagement {
	private ActionDriver actionDriver;
	
	private By PIM= By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
	private By addEmployee=By.linkText("Add Employee");
	private By firstName=By.cssSelector("input[name='firstName']");
	private By lastName = By.cssSelector("input[name='lastName']");
	private By employeeID=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By empSubmit=By.cssSelector("button[type=\"submit\"]");
	private By successPopUp=By.cssSelector("p[class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']");
	private By driverLicNum = By.xpath("(//div['data-v-957b4417']/input['data-v-1f99f73c'])[7]");
	private By licExpDate = By.xpath("//div[@class='oxd-date-wrapper']/input[@class='oxd-input oxd-input--active']");
	private By nationality = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	private By nationalityDropdown = By.cssSelector("div[role='listbox']");
	private By submitPersonalDetails = By.xpath("(//button[@type='submit'])[2]");
	//initialize the action driver object by passing webdriver instance
		public EmployeeManagement(WebDriver driver)
		{
			this.actionDriver = new ActionDriver(driver);
		}
		
	//navigate to PIM
	public void navigateToPIM()
	{
		actionDriver.click(PIM);
	}
	
	//clock on add employee
	public void clickAddEmployeeButton()
	{
		actionDriver.click(addEmployee);
	}
	
	//Add Employee details
	
	public void addEmployeeDetails(String FirstName, String LastName)
	{
		actionDriver.enterText(firstName, FirstName);
		actionDriver.enterText(lastName, LastName);
		String empID = actionDriver.getText(employeeID);
		actionDriver.click(empSubmit);
		String success = actionDriver.getText(successPopUp);		
	}
	
	public void personalDetails(int licNum, String date, String country)
	{
		actionDriver.enterText(driverLicNum, Integer.toString(licNum));
		actionDriver.enterText(licExpDate, date);
		actionDriver.click(nationality);
		actionDriver.DropDown(nationalityDropdown, country);
		actionDriver.click(submitPersonalDetails);	
		String success = actionDriver.getText(successPopUp);
	}
	

}
