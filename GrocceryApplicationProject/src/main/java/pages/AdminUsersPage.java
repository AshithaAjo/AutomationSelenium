package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;

	PageUtility page = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newuserbutton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement usertypedropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveuserbutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement usersearchbutton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement usernametextbox;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement usertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	WebElement searchuserbutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetuser;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement adminuserpage;

	public AdminUsersPage clickOnNewUserButton() {
		newuserbutton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameTextBox(String usernamevalue1) {
		username.sendKeys(usernamevalue1);
		return this;
	}

	public AdminUsersPage enterPasswordOnPasswordTextBox(String passwordvalue1) {
		password.sendKeys(passwordvalue1);
		return this;
	}

	public AdminUsersPage selectUserTypeDropDown() {
		page.selectDropdownWithVisibleText(usertypedropdown, Constants.DROPDOWNVALUE1);
		return this;
	}

	public AdminUsersPage ClickOnSaveUserButton() {
		saveuserbutton.click();
		return this;
	}

	public AdminUsersPage clickOnSearchButton() {
		usersearchbutton.click();
		return this;
	}

	public AdminUsersPage enterUsername(String usernamevalue1) {
		usernametextbox.sendKeys(usernamevalue1);// replace with excel read
		return this;
	}

	public AdminUsersPage selectUserType() {

		page.selectDropdownWithVisibleText(usertype, Constants.DROPDOWNVALUE1);

		return this;
	}

	public AdminUsersPage clickOnSearchUser() {
		searchuserbutton.click();
		return this;
	}

	public AdminUsersPage clickOnReserUserButton() {
		resetuser.click();
		return this;
	}

	public boolean isAdminUserPageDisplayed() {
		return adminuserpage.isDisplayed();
	}
}