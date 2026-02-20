package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name="username")WebElement username1;
	@FindBy(name="password")WebElement password1;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboardtile;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement logintext;
	
	public LoginPage enterUsernameOnUsernameField(String usernamevalue) {
		username1.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
		password1.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage clickOnLOginButton() {
		signin.click();
		return new HomePage(driver);
	}
	public boolean isDashboardDisplayed() {
		return dashboardtile.isDisplayed();
	}
	public String dashboardText() {
		return logintext.getText();
	}

	}


