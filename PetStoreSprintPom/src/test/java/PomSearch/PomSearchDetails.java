package PomSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomSearchDetails {
	WebDriver driver;
	By ItemId = By.linkText("EST-16");

	public PomSearchDetails(WebDriver driver)
	{
		this.driver = driver;
	}

	//click on item id
	public void Item_Id() 
	{
		driver.findElement(ItemId).click();
	}

	public void Pet_Details()
	{
		driver.findElement(By.className("Persian"));
	}

	public void SearchPetDetails(String strItemId){
		//Click Cats
		this.Item_Id();
		this.Pet_Details();
	}
}