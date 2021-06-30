package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ToDoListPage;
import util.BrowserFactory;

public class AddCategoryTest {
	WebDriver driver;
	
	
	@Test
	public void userShouldBeAbleToAddACategory() {
		driver = BrowserFactory.init();
		ToDoListPage tat = PageFactory.initElements(driver, ToDoListPage.class);
		String categoryName = "chores";
		tat.setCategoryName(categoryName);
		tat.addCategory();
		tat.verifyAddedCategory(categoryName);
		
	}
	
	

}
