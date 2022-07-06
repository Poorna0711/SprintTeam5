package Propertyfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FinalProperty {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;

		//Reading the property file
		File source=new File("C:\\Sprint2\\WebDriverScript\\TestResource\\Final.property");
		FileInputStream fis=new FileInputStream(source);
		Properties prop=new Properties();
		prop.load(fis);

		//Launching chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver();
		//Navigating to JPetStore home page
		driver.navigate().to(prop.getProperty("url"));

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
		//Search pet
		
		FileInputStream excelFile=new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Propertyfiles\\B59E5E20.xlsx");
		XSSFWorkbook workbook1=new XSSFWorkbook(excelFile);
		XSSFSheet sheet=workbook1.getSheetAt(0);
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Rows : "+row+"   Columns : "+col);


		//Iterating
		XSSFCell searchKey;
		for(int i=0;i<=row;i++) {
			searchKey=sheet.getRow(i).getCell(0);
			driver.findElement(By.xpath(prop.getProperty("searchInput"))).sendKeys(searchKey.toString());
			driver.findElement(By.xpath(prop.getProperty("clickSearch"))).click();
			Thread.sleep(2000);
			/*if(i==0) {
				driver.navigate().back();
				driver.findElement(By.xpath(prop.getProperty("searchInput"))).clear();
			}
		}
		workbook1.close();*/

		//Adding pet to cart
		driver.findElement(By.xpath(prop.getProperty("clickProductId"))).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
		driver.findElement(By.xpath(prop.getProperty("addToCart"))).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//Proceed to Checkout and place the order
		driver.findElement(By.xpath(prop.getProperty("proceedToCheckout"))).click();
		driver.findElement(By.xpath(prop.getProperty("continue"))).click();
		driver.findElement(By.xpath(prop.getProperty("confirm"))).click();
		try {
			//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("message"))));
		}catch(Exception e) {

		}
		Assert.assertTrue(driver.findElement(By.xpath(prop.getProperty("message"))).isDisplayed());
		System.out.println("Message : "+driver.findElement(By.xpath(prop.getProperty("message"))).getText());

		//Validating order id
		driver.findElement(By.linkText(prop.getProperty("myOrders"))).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement orderId=driver.findElement(By.xpath(prop.getProperty("orderId")));
		Assert.assertTrue(orderId.getText().matches("[0-9]+"));
		System.out.println("Order id is : "+orderId.getText());

		//close window
		driver.close();
	}
}}