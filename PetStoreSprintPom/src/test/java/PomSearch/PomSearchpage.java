package PomSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomSearchpage {
	static WebDriver driver;
	By Productname = By.xpath("//body/section[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/input[1]");
	static By SearchButton = By.xpath("//button[contains(text(),'Search')]");

	public PomSearchpage(WebDriver driver) {
		this.driver = driver;
	}

	// enter product name
	public void Productname(String strProductName) throws InterruptedException {
		driver.findElement(Productname).click();
		// Thread.sleep(2000);
	}

	// click on Search button
	public static void clickSearch() throws InterruptedException {
		driver.findElement(SearchButton).click();
		Thread.sleep(2000);
	}

	public void searchPets(String strProductName) throws InterruptedException {
		this.Productname(strProductName);
		this.clickSearch();
	}

}