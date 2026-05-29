package orangeHRM;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.resetPasswordPage;

public class LoginPageTest extends BaseClass {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private resetPasswordPage resetPassword;
	
	@BeforeMethod(alwaysRun = true)
	public void setupPages()
	{
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		resetPassword=new resetPasswordPage(getDriver());
	}
	@Test(testName = "Verify login with valid credentials" ,groups={"Smoke","Regression"})
	public void verifyValidLoginTest()
	{
		loginPage.login("Admin", "admin123");
		Assert.assertTrue(homePage.isAdminTabVisible(), "Admin Tab should be visible");
		homePage.logout();
		staticWait(2);
	}
	
	@Test(testName = "Verify login with invalid password" , groups={"Smoke"})
	public void invalidPassword()
	{
		loginPage.login("Admin", "password");
		Assert.assertEquals(loginPage.getErrorTextMessage(),"Invalid credentials");
		staticWait(2);
		
	}
	
	@Test(testName = "Verify login with empty user name", groups={"Smoke"})
	public void emptyUserName()
	{
		loginPage.login("", "password");
		Assert.assertEquals(loginPage.requiredError(), "Required");
	}
	
	@Test(testName = "Verify login with empty password", groups={"Smoke"})
	public void emptyPassword()
	{
		loginPage.login("admin", "");
		Assert.assertEquals(loginPage.requiredError(), "Required");
	}
	
	@Test(testName = "Verify reset password", groups={"Smoke"})
	public void resetPassword()
	{
		loginPage.navigateToForgetPassword();
		staticWait(2);
		Assert.assertEquals(resetPassword.getTitle(),"Reset Password");
		resetPassword.resetDetails("admin");
		staticWait(2);
	}
	
	@Test(testName = "Verify browser back after logout", groups={"Smoke"})
	public void browserBackAfterLogout()
	{
		loginPage.login("Admin", "admin123");
		Assert.assertTrue(homePage.isAdminTabVisible(), "Admin Tab should be visible");
		homePage.logout();
		staticWait(2);
		browserBackNavigation();
	}

}
