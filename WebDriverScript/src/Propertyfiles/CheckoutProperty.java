package Propertyfiles;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckoutProperty {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		File src= new File("C:\\Sprint2\\WebDriverScript\\TestResource\\Checkout.property");
		FileInputStream fis = new FileInputStream(src);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[1]/input[1]")).clear();
		driver.findElement(By.name(prop.getProperty("username"))).sendKeys("Team5");
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[2]/input[1]")).clear();
		driver.findElement(By.name(prop.getProperty("password"))).sendKeys("Team5");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*driver.findElement(By.id("AlertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(2000);
		simpleAlert.accept();*/
		
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[1]/div[4]/a[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'K9-BD-01')]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to Checkout')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		Thread.sleep(1000);
		 String checkoutTitle=driver.getTitle();
	      System.out.println("The title of the Loginpage is :"+checkoutTitle);
		driver.close();
		driver.quit();
		
			
	}
}