package PomSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomSearch {
	WebDriver driver;
	By Petcategory = By.linkText("Cats");

	public PomSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//click on categories of pets
	public void clickCats(){
		driver.findElement(Petcategory).click();

	}
	
	//Click on Cats
	public void SearchCategories(String strCategoryName)
	{
		//Click Cats
		this.clickCats();      
	}
}