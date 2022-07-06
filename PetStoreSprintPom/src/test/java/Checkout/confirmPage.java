package Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class confirmPage {
WebDriver driver;
	
	//Constructor
	public confirmPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Storing web elements
	By confirm=By.xpath("//button[contains(text(),'Confirm')]");
	
	//Click on confirm
	public void clickConfirm() {
		driver.findElement(confirm).click();
	}
}