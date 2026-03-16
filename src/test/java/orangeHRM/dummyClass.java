package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;

public class dummyClass extends BaseClass{
	
	@Test
	public void dummy()
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait until the title is not an empty string or contains a specific value
		//wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
		
		String title = driver.getTitle();
		System.out.println(title);
		assert title.equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"):"Test Failed - Title is not matching";
		System.out.println("Testcase - Passed");
	}
	
	
}
