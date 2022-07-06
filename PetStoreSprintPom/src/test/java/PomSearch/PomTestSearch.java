package PomSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PomTestSearch {
	String driverPath="C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;



	PomSearchpage objSearchPage;
	PomSearch objSearch;
	PomSearchProduct objSearchForProduct;
	PomSearchDetails objSearchForPetDetails;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://jpetstore.aspectran.com/catalog/");
		
	}
	 @Test(priority = 1)
	public void Search_Pet_Page() throws InterruptedException
	{
		objSearchPage = new PomSearchpage(driver);
		objSearchPage.Productname("Koi");

		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		//search for categories
		objSearch = new PomSearch(driver);
		driver.findElement(By.xpath("//a[contains(text(),'Cats')]")).click();

		//search for product id
		objSearchForProduct = new PomSearchProduct (driver);
		driver.findElement(By.linkText("FL-DLH-02")).click();

		//search for pet details
		objSearchForPetDetails = new PomSearchDetails(driver);
		driver.findElement(By.linkText("EST-16")).click();
		driver.findElement(By.xpath("//h3[contains(text(),'Persian')]")).click();
		driver.manage().window().maximize();
	}
}