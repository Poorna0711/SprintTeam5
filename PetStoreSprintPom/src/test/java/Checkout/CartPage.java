package Checkout;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
WebDriver driver;
	
	//Constructor
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Storing web elements
	By proceedToCheckout=By.xpath("//a[contains(text(),'Proceed to Checkout')]");
	
	//Click on proceed to checkout
	public void clickProceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}}