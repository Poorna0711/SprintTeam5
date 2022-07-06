package Propertyfiles;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginProperty {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		File src= new File("C:\\Sprint2\\WebDriverScript\\TestResource\\Login.property");
		FileInputStream fis = new FileInputStream(src);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		  //Reading values from excel
	      FileInputStream fis1 = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Propertyfiles\\propertylogin.xlsx");   
	      //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis1);
	      XSSFSheet ws = workbook.getSheetAt(0);	
	        XSSFCell username= ws.getRow(1).getCell(0);
	        XSSFCell password= ws.getRow(1).getCell(1);
	      driver.get(prop.getProperty("url"));
	  
	    //Printing the email and password
	      System.out.println("username  is :" +username);
	      System.out.println("password is :" +password);
	
	      driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[1]/input[1]")).clear();
		driver.findElement(By.name(prop.getProperty("username"))).sendKeys(username.toString());
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[2]/div[1]/form[1]/div[1]/label[2]/input[1]")).clear();
		 driver.findElement(By.name(prop.getProperty("password"))).sendKeys(password.toString());
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
	   //Validating the Welcome Message of HomePage
	      if(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).isEnabled()) {
	          System.out.println("Welcome Team!");
		/*driver.findElement(By.id("AlertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(2000);
		simpleAlert.accept();*/
	          
		// Get the Title of Loginpage
	      String LoginTitle=driver.getTitle();
	      System.out.println("The title of the Loginpage is :"+LoginTitle);
	      //Validating the Welcome Message of HomePage
	      if(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).isEnabled()) {
	          System.out.println("Welcome Team!");
			driver.close();
		driver.quit();
	}
	}
	}
}
