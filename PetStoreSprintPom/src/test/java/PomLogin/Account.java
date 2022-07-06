package PomLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {

WebDriver driver;
By username = By.xpath("//a[contains(text(),'Sign Out')]");
By signout = By.linkText("Sign out");

public void Account1(WebDriver driver) {
this.driver=driver;
}

    public String getusername() {
        return driver.findElement(username).getText();
    }
   
public void clickSignout() {
driver.findElement(signout).click();
}
}