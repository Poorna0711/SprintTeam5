package Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete {
	WebDriver driver;
	By MyOrders = By.xpath("//a[contains(text(),'My Orders')]");
	By OrderID = By.xpath("//a[contains(text(),'1003')]");
	By DeleteOrder = By.xpath("//button[contains(text(),'Delete Order')]");

	public Delete(WebDriver driver) {
		this.driver=driver;	
	}

	//click on my orders
	public void My_Orders() {
		driver.findElement(MyOrders).click();
	}

	//click on order id
	public void Order_Id() {
		driver.findElement(OrderID).click();
	}

	//click on delete all button
	public void Delete_Order() {
		driver.findElement(DeleteOrder).click();	
	}
	
}