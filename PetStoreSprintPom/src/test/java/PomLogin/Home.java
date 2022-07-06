package PomLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
static WebDriver driver;

//Storing web elements
By signIn=By.linkText("Sign In");
By signUp=By.linkText("Sign Up");
static By welcomeMessage=By.xpath("//div[@id='WelcomeContent']");

//Constructor
public Home(WebDriver driver) {
this.driver=driver;
}

//Click on sign in
public void clickSignIn() {
driver.findElement(signIn).click();
}

//Click on sign up
public void clickSignUp() {
driver.findElement(signUp).click();
}

//Retrieving user name
public static String getHomePageUserName() {
return driver.findElement(welcomeMessage).getText();
}
}