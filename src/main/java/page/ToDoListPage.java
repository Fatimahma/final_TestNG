package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ToDoListPage extends BasePage {

	WebDriver driver;
	String categoryName;

	public ToDoListPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_INPUT;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement ADD_CATEGORY_BUTTON;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),categoryName)]")
	WebElement CATEGORY_ADDED_TEXT;
	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement DUPLICAT_MESSAGE;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement MONTH_DROP_DOWN;
	@FindAll(@FindBy(how = How.CSS, using = "select[name = 'due_month']>option"))
	List<WebElement> MONTH_OPTIONS;

	public void setCategoryName(String name) {
		categoryName = name;
	}

	public void addCategory() {
		CATEGORY_INPUT.sendKeys(categoryName);
		ADD_CATEGORY_BUTTON.click();
	}

	public void verifyAddedCategory(String Name) {
		categoryName = Name;
		CATEGORY_ADDED_TEXT.isDisplayed();
	}

	public void addSameCategory() {
		CATEGORY_INPUT.sendKeys(categoryName);
		ADD_CATEGORY_BUTTON.click();
		Assert.assertTrue(DUPLICAT_MESSAGE.getText().contains("The category you want to add already exists"),
				"failed to give duplicate message");

	}

	public void verifyMonthDropDown() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(MONTH_OPTIONS.size() == 13,"wrong total month number");
		softAssert.assertTrue(MONTH_OPTIONS.get(0).getText().contains("None"));
		softAssert.assertTrue(MONTH_OPTIONS.get(1).getText().contains("Jan"));
		softAssert.assertTrue(MONTH_OPTIONS.get(2).getText().contains("Feb"));
		softAssert.assertTrue(MONTH_OPTIONS.get(3).getText().contains("Mar"));
		softAssert.assertTrue(MONTH_OPTIONS.get(4).getText().contains("Apr"));
		softAssert.assertTrue(MONTH_OPTIONS.get(5).getText().contains("May"));
		softAssert.assertTrue(MONTH_OPTIONS.get(6).getText().contains("Jun"));
		softAssert.assertTrue(MONTH_OPTIONS.get(7).getText().contains("Jul"));
		softAssert.assertTrue(MONTH_OPTIONS.get(8).getText().contains("Aug"));
		softAssert.assertTrue(MONTH_OPTIONS.get(9).getText().contains("Sep"));
		softAssert.assertTrue(MONTH_OPTIONS.get(10).getText().contains("Oct"));
		softAssert.assertTrue(MONTH_OPTIONS.get(11).getText().contains("Nov"));
		softAssert.assertTrue(MONTH_OPTIONS.get(12).getText().contains("Dec"));
		softAssert.assertAll();
		
	}
}
