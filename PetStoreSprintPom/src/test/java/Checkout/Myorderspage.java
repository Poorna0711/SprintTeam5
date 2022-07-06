package Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Myorderspage {
WebDriver driver;
	
	//Constructor
	public Myorderspage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Storing web elements
	By message=By.xpath("//p[contains(text(),'Thank you, your order has been submitted.')]");
	
	//Validate order placed message
	public void validateMessage() {
		Assert.assertTrue(driver.findElement(message).isDisplayed());
		System.out.println("Message : "+driver.findElement(message).getText());
	}
}