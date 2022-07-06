package Propertyfiles;

import java.io.File;
import java.io.FileInputStream;
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

public class SignupProperty {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		File src= new File("C:\\Sprint2\\WebDriverScript\\TestResource\\Signup.property");
		FileInputStream fis = new FileInputStream(src);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		  //Reading values from excel
	      FileInputStream fis1 = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Propertyfiles\\SignUpproperty.xlsx");   
	      //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      XSSFWorkbook workbook = new XSSFWorkbook(fis1);
	      XSSFSheet ws = workbook.getSheetAt(0);	
	     	
	        XSSFCell username= ws.getRow(1).getCell(0);
	        XSSFCell password= ws.getRow(1).getCell(1);
	        XSSFCell repeatedPassword= ws.getRow(1).getCell(2);
	        XSSFCell firstName= ws.getRow(1).getCell(3);
	        XSSFCell lastName= ws.getRow(1).getCell(4);
	        XSSFCell email= ws.getRow(1).getCell(5);
	        XSSFCell phone= ws.getRow(1).getCell(6);
	        XSSFCell address1= ws.getRow(1).getCell(7);
	        XSSFCell address2= ws.getRow(1).getCell(8);
	        XSSFCell city= ws.getRow(1).getCell(9);
	        XSSFCell state= ws.getRow(1).getCell(10);
	        XSSFCell zip= ws.getRow(1).getCell(11);
	        XSSFCell country= ws.getRow(1).getCell(12);
	        
	      driver.get(prop.getProperty("url"));
	   // Get the Title of Loginpage
	      String LoginTitle=driver.getTitle();
	      System.out.println("The title of the Loginpage is :"+LoginTitle);
	    //Printing the email and password
	      System.out.println("username  is :" +username);
	      System.out.println("password is :" +password);
	      System.out.println("repeatedPassword is :" +repeatedPassword);
	      System.out.println("firstName is :" +firstName);
	      System.out.println("lastName is :" +lastName);
	      System.out.println("email is :" +email);
	      System.out.println("phone is :" +phone);
	      System.out.println("address1 is :" +address1);
	      System.out.println("address2 is :" +address2);
	      System.out.println("city is :" +city);
	      System.out.println("state is :" +state);
	      System.out.println("zip is :" +zip);
	      System.out.println("country is :" +country);
	      
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();

		driver.findElement(By.name(prop.getProperty("username"))).sendKeys(username.toString());
		driver.findElement(By.name(prop.getProperty("password"))).sendKeys(password.toString());
		driver.findElement(By.name(prop.getProperty("repeatedPassword"))).sendKeys(repeatedPassword.toString());
		driver.findElement(By.name(prop.getProperty("firstName"))).sendKeys(firstName.toString());
		driver.findElement(By.name(prop.getProperty("lastName"))).sendKeys(lastName.toString());
		driver.findElement(By.name(prop.getProperty("email"))).sendKeys(email.toString());
		driver.findElement(By.name(prop.getProperty("phone"))).sendKeys(phone.toString());
		driver.findElement(By.name(prop.getProperty("address1"))).sendKeys(address1.toString());
		driver.findElement(By.name(prop.getProperty("address2"))).sendKeys(address2 .toString());
		driver.findElement(By.name(prop.getProperty("city"))).sendKeys(city.toString());
		driver.findElement(By.name(prop.getProperty("state"))).sendKeys(state.toString());
		driver.findElement(By.name(prop.getProperty("zip"))).sendKeys(zip.toString());
		driver.findElement(By.name(prop.getProperty("country"))).sendKeys(country.toString());
		
		driver.findElement(By.xpath("//button[contains(text(),'Save Account Information')]")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String Title=driver.getTitle();
		System.out.println("The title of the page is "+Title);
		// Displaying page title

		String url=driver.getCurrentUrl();
		System.out.println("The URL of the page is "+url);
		
		

		/*driver.findElement(By.id("AlertBox")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(2000);
		simpleAlert.accept();*/

	//Assert.assertTrue(driver.findElement(By.id(prop.getProperty("WelcomeContent"))).getText().matches("Welcome Team!"));
	//System.out.println(driver.findElement(By.id(prop.getProperty("WelcomeContent"))).getText());
			
				
		driver.close();
	}

}
