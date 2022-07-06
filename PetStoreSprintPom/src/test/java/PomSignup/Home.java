package PomSignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	By signUp = By.xpath("//a[contains(text(),'Sign Up')]");
	 
	public Home(WebDriver driver) {
		
		this.driver = driver;
	}
	
	

	public void clickSignUp() {
		 driver.findElement(signUp).click();
    }
		
	}