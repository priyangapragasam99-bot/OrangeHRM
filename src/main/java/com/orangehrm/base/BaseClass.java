package com.orangeHRM.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static Properties prop;
	protected static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	// load the configuration file
	public void loadConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
		prop.load(fis);
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {

		System.out.println("SettingUp WebDriver:" + this.getClass().getSimpleName());
		launchBrowser();
		configureBrowser();
		staticWait(2);

	}

	// initialize the webdriver based on browser defined in the confg.properities
	private void launchBrowser() throws IOException {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefoxx")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
	}

	// implicit wait, maximize browser, navigate to URL
	private void configureBrowser() throws IOException {
		// implicit wait
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

		// maximize the browser
		driver.manage().window().maximize();

		// navigate to URL
		try {
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to get the URL:" + e.getMessage());
		}
	}
	
	//Static wait
	public void staticWait(int seconds)
	{
		LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(seconds));
	}
	
	//getter method for prop
	public static Properties getProp()
	{
		return prop;
	}
	
	//driver getter method
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void setDriver()
	{
		this.driver = driver;
	}
	
	//navigate Back
		public void browserBackNavigation()
		{
			try {
				driver.navigate().back();
			} catch (Exception e) {
				
				System.out.println("Navigate the browser backward : " + e.getMessage());
			}
		}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("Unable to quit the browser:" + e.getMessage());
			}
		}
	}
	
	
}
