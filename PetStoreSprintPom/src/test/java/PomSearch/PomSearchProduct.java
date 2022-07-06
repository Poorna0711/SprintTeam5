package PomSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomSearchProduct {
	WebDriver driver;
	By ProductId = By.linkText("FL-DLH-02");

	public PomSearchProduct(WebDriver driver) {
		this.driver = driver;
	}

	// click on
	public void Categories() {
		driver.findElement(ProductId).click();
	}

	public void SearchProductId(String strProductId){
		//Click birds
		this.Categories();
	}
}