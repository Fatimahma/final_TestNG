package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ToDoListPage;
import util.BrowserFactory;

public class DuplicateCategoryTest {
	WebDriver driver;
	
	
	@Test
	public void userShouldBeAbleToAddACategory() {
		driver = BrowserFactory.init();
		ToDoListPage tat = PageFactory.initElements(driver, ToDoListPage.class);
		String categoryName = "Study";
		tat.setCategoryName(categoryName);
		tat.addCategory();
		tat.addSameCategory();
	}

}