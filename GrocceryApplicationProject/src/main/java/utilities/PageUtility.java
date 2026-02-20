package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropdownWithDeselectAll(WebElement element, String value) {

		Select object = new Select(element);
		object.deselectAll();

	}
	public void selectDropdownWithGetFirstSelectedOption(WebElement element, String value) {

		Select object = new Select(element);
		object.getFirstSelectedOption();

	}
	public void selectDropdownWithGetOptions(WebElement element, String value) {

		Select object = new Select(element);
		object.getOptions();

	}
	public void selectDropdownWithVisibleText(WebElement element, String text) {

		Select object = new Select(element);
		object.selectByVisibleText(text);

	}
	
}
