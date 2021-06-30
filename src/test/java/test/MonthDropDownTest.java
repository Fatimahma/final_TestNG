package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page.ToDoListPage;
import util.BrowserFactory;

public class MonthDropDownTest {
	WebDriver driver;
	@Test
	public void monthDropDownShouldHaveTwelveMonth() {
		driver = BrowserFactory.init();
		ToDoListPage tat = PageFactory.initElements(driver, ToDoListPage.class);
		tat.verifyMonthDropDown();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
