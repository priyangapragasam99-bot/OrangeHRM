package orangeHRM;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.BaseClass;
import com.orangeHRM.pages.EmployeeManagement;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.resetPasswordPage;

public class employeeManagement extends BaseClass {
	
	private LoginPage loginPage;
	private HomePage homePage;
	private resetPasswordPage resetPassword;
	private EmployeeManagement empManagement;
	
	@BeforeMethod(alwaysRun = true)
	public void setupPages()
	{
		loginPage=new LoginPage(getDriver());
		homePage=new HomePage(getDriver());
		resetPassword=new resetPasswordPage(getDriver());
		empManagement=new EmployeeManagement(getDriver());
	}
	
	@Test(testName = "Verify by adding employee details", groups={"Smoke","Regression"})
	public void addNewEmployee()
	{
		
		loginPage.login("Admin", "admin123");
		Assert.assertTrue(homePage.isAdminTabVisible(), "Admin Tab should be visible");
		staticWait(2);
		empManagement.navigateToPIM();
		empManagement.clickAddEmployeeButton();
		
		Random rand = new Random();
		int LicNum = rand.nextInt(10);
		empManagement.addEmployeeDetails("priya","p");
		empManagement.personalDetails(LicNum, "16-06-2030", "India");
	}

}
