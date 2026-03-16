package orangeHRM;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setupPages()
	{
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
	}
	@Test
	public void verifyValidLoginTest()
	{
		loginPage.login("Admin", "admin123");
		Assert.assertTrue(homePage.isAdminTabVisible(), "Admin Tab should be visible");
		homePage.logout();
		staticWait(2);
	}

}
