package PomSignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account2 {

WebDriver driver;
By userName = By.cssSelector("body.my-account.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.nav:nth-child(2) div.container div.row nav:nth-child(1) div.header_user_info:nth-child(1) a.account > span:nth-child(1)");
By signout = By.linkText("Sign out");

public Account2(WebDriver driver) {
this.driver=driver;
}

    public String getUserName() {
        return driver.findElement(userName).getText();
    }
   
public void clickSignout() {
driver.findElement(signout).click();
}
}