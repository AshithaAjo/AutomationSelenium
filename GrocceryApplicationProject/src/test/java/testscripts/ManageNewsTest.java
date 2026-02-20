package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
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
		@Test(priority=2, description="validating user is able to add new news")
		public void verifyWhetherUserIsAbletoAddNews() throws IOException {
			
			String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
			String newsformat=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
			
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
			homepage=login.clickOnLOginButton();
			
			
			HomePage home=new HomePage(driver);
			home.clickOnMoreInfo();
			
			ManageNewsPage newss=new ManageNewsPage(driver);
			newss.clickOnNew();
			newss.enterNewsOnNewsField(newsformat);
			newss.clickOnSaveButton();
			
			boolean managenewsdisplaypage=newss.isManageNewsDisplayed();
			 Assert.assertTrue(managenewsdisplaypage, Constants.ADDNEWNEWSERROR);
		}
		@Test(priority=1, description="validating user is able to search the added news")
		public void verifyWhetherUserIsAbletoSearchTheAddedNews() throws IOException {
			
			String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
			String newsformat=ExcelUtility.getStringData(0, 0, "ManageNewsPage");
			
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
			homepage=login.clickOnLOginButton();
			
			HomePage home=new HomePage(driver);
			home.clickOnMoreInfo();
			
			ManageNewsPage newss=new ManageNewsPage(driver);
			newss.clickOnSearchButton();
			newss.enterNewsTitle(newsformat);
			newss.ClickOnSearch();
			
			boolean managenewsdisplaypage=newss.isManageNewsDisplayed();
			 Assert.assertTrue(managenewsdisplaypage, Constants.SEARCHNEWSERROR);
			
			
		}
		@Test(priority=1, description="validating user is able to reset the news")
		public void verifyWhetherUserIsAbleToResetTheNews() throws IOException {
			
			String usernamevalue=ExcelUtility.getStringData(0, 0, "LoginPage");
			String passwordvalue=ExcelUtility.getStringData(0, 1, "LoginPage");
			
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
			homepage=login.clickOnLOginButton();
			
			HomePage home=new HomePage(driver);
			home.clickOnMoreInfo();
			
			ManageNewsPage newss=new ManageNewsPage(driver);
			newss.clickOnResetButton();
			
			boolean managenewsdisplaypage=newss.isManageNewsDisplayed();
			 Assert.assertTrue(managenewsdisplaypage, Constants.RESETNEWSERROR);
			
		}
}
