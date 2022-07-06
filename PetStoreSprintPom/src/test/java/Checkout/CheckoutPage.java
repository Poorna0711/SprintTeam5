package Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;

	//Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}


	//Storing web elements
	By Loginn=By.xpath("//button[contains(text(),'Login')]");
	By continue1=By.xpath("//button[contains(text(),'Continue')]");

	//Click on continue
	
	public void clickLoginn() {
		driver.findElement(Loginn).click();
	}
	public void clickContinue() {
		driver.findElement(continue1).click();
	}}
	