package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbtn;
    @FindBy(id="news") WebElement enternews;
    @FindBy(xpath="//button[@type='submit']") WebElement save;
    
    @FindBy(xpath="//a[@href='javascript:void(0)']") WebElement search;
    @FindBy(xpath="//input[@type='text']") WebElement newstitle;
    @FindBy(xpath="//button[@type='submit']") WebElement searchbutton;
    
    @FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement reset;
    
    @FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement managenewstext;
    
    public ManageNewsPage clickOnNew() {
		newbtn.click();
		return this;
	}
	
	public ManageNewsPage enterNewsOnNewsField(String newsformat) {
		enternews.sendKeys(newsformat);
		return this;
	}
	
	public ManageNewsPage clickOnSaveButton() {
		save.click();
		return this;
	}
	
	public ManageNewsPage ClickOnSearch() {
		search.click();
		return this;
	}
	
	public ManageNewsPage enterNewsTitle(String newsformat) {
		newstitle.sendKeys(newsformat);
		return this;
	}
	
	public ManageNewsPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}
	
	public ManageNewsPage clickOnResetButton() {
		reset.click();
		return this;
	}
	public boolean isManageNewsDisplayed() {
		return managenewstext.isDisplayed();
	}
}
