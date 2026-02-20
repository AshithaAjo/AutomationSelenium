package testscripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;


public class AdminUsersTest extends TestNGBase{
	HomePage homepage;
	
	@Test(priority=1, description="validating user is able to logout")
	public void verifyWhetherUserisAbletoLogoutSuccessfully() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnLOginButton();
		
		boolean dashboarddisplay=login.isDashboardDisplayed();
		 Assert.assertTrue(dashboarddisplay, Constants.VALIDCREDENTIALERROR);

}
	@Test(priority=2, description="validating user is able to add news")
	public void verifyWhetherUserIsAbletoAddNewUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnLOginButton();
		
		HomePage home=new HomePage(driver);
		home.adminClickOnMoreInfo();
		
		AdminUsersPage admin=new AdminUsersPage(driver);
		admin.clickOnNewUserButton();
		
		FakerUtility faker=new FakerUtility();
		String usernamevalue1=faker.createRandomUserName();
		String passwordvalue1=faker.createRandomPassword();
		
		admin.enterUsernameOnUsernameTextBox(usernamevalue1);
		admin.enterPasswordOnPasswordTextBox(passwordvalue1);
		admin.selectUserTypeDropDown();
		admin.ClickOnSaveUserButton();
		
		boolean adminuserdisplaypage=admin.isAdminUserPageDisplayed();
		 Assert.assertTrue(adminuserdisplaypage, Constants.ADDNEWUSERERROR);
	}
	@Test(priority=3, description="validating user is able to search the added user")
	public void verifyWhetherUserIsAbletoSearchAddedUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		String usernamevalue1=ExcelUtility.getStringData(0, 0, "AdminUserPage");
		
		
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnLOginButton();
		
		HomePage home=new HomePage(driver);
		home.adminClickOnMoreInfo();
		
		AdminUsersPage admin=new AdminUsersPage(driver);
		admin.clickOnSearchButton();
		admin.enterUsername(usernamevalue1);
		admin.selectUserType();
		admin.clickOnSearchUser();
		boolean adminuserdisplaypage=admin.isAdminUserPageDisplayed();
		 Assert.assertTrue(adminuserdisplaypage, Constants.SEARCHUSERERROR);
	}
	@Test(priority=4, description="validating user is able to reset")
	
	public void verifyWhetherUserIsAbletoResetUser() throws IOException {
		String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage=login.clickOnLOginButton();
		
		HomePage home=new HomePage(driver);
		home.adminClickOnMoreInfo();
		
		AdminUsersPage admin=new AdminUsersPage(driver);
		admin.clickOnReserUserButton();
		
		boolean adminuserdisplaypage=admin.isAdminUserPageDisplayed();
		 Assert.assertTrue(adminuserdisplaypage, Constants.RESETUSERERROR);
	}
	
	
}
