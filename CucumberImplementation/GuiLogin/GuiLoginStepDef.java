package GuiLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GuiLoginStepDef {

	WebDriver driver;
	private DataTable accountdetails;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.navigate().to("https://jpetstore.aspectran.com/catalog/");
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_Team5_and_Team5(String username,String password) throws InterruptedException {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
	}

	@When("User clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(1000);
	}

	@Then("Logged in successfully")
	public void logged_in_successfully() {
		System.out.println("Logged in successfully");
	}
}