package com.orangeHRM.ActionDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.base.BaseClass;

public class ActionDriver {

	private WebDriver driver;
	private WebDriverWait wait;

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
		Integer.parseInt(BaseClass.getProp().getProperty("explicitWait"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void DropDown(By by, String dropDownValue)
	{
		try {
			Select s = new Select(driver.findElement(by));
			s.deselectByValue(dropDownValue);
		} catch (Exception e) {
			System.out.println("unable to find on dropdown :" + e.getMessage());
		}
	}
	
	// method to click an element
	public void click(By by) {
		try {
			waitForTheElementToBeClickable(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			System.out.println("unable to click :" + e.getMessage());
		}
	}

	// Method to enter the text into the input field
	public void enterText(By by, String value) {
		try {
			waitForvisibilityOfAllElements(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			System.out.println("unable to enter value:" + e.getMessage());
		}

	}
	

	// method to get text
	public String getText(By by) {
		try {
			waitForvisibilityOfAllElements(by);
			return driver.findElement(by).getText();
		} catch (Exception e) {
			System.out.println("Unable to get the text: " + e.getMessage());
			return "";
		}
	}

	// method to compare two text
	public void compareTwoText(By by, String expectedText) {
		try {
			waitForvisibilityOfAllElements(by);
			String actualText = driver.findElement(by).getText();
			if (actualText.equalsIgnoreCase(expectedText)) {
				System.out.println("Text are matching: " + actualText + " equals " + expectedText);
			} else {
				System.out.println("Text are matching: " + actualText + " equals " + expectedText);
			}
		} catch (Exception e) {
			System.out.println("unable to compare text: " + e.getMessage());
		}
	}

	// Method to check if the element is displyed
	public boolean isDisplayed(By by) {
		try {
			boolean isDisplayed = driver.findElement(by).isDisplayed();
			if (isDisplayed) {
				return isDisplayed;
			} else {
				return isDisplayed;
			}
		} catch (Exception e) {
			System.out.println("Element is not Displayed: " + e.getMessage());
			return false;
		}

	}

	// scroll to element
	public void scrollToElement(By by) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(by);
			js.executeScript("argument[0],scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Unable to locate the element: " + e.getMessage());
		}
	}

	// Wait for the page to load
	public void waitForThePageToLoad(int timeOutInSec) {
		try {
			wait.withTimeout(Duration.ofSeconds(timeOutInSec)).until(WebDriver -> ((JavascriptExecutor) WebDriver)
					.executeScript("Return document.readyState").equals("Complete"));
			System.out.println("Page Loaded Successfully");
		} catch (Exception e) {
			System.out.println("Page is not loaded within " + timeOutInSec + "Second.Exception: " + e.getMessage());
		}
	}

	// Wait element to be clickable
	private void waitForTheElementToBeClickable(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			System.out.println("Element is not clickable:" + e.getMessage());
		}
	}

	// wait element to be visible
	private void waitForvisibilityOfAllElements(By by) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		} catch (Exception e) {
			System.out.println("Element is not visible : " + e.getMessage());
		}
	}
	
	//navigate Back
	private void browserBackNavigation()
	{
		try {
			driver.navigate().back();
		} catch (Exception e) {
			
			System.out.println("Navigate the browser backward : " + e.getMessage());
		}
	}
}
