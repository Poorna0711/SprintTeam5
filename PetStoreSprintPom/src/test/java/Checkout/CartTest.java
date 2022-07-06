package Checkout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 public class CartTest {
	 String driverPath="C:\\Users\\SAINANDI\\OneDrive - Capgemini\\Desktop\\selinium\\chromedriver_win32\\chromedriver.exe";
		WebDriver driver;


		CartPage cartPage;
		CheckoutPage checkoutPage;
		confirmPage checkoutConfirmPage;
		Myorderspage myOrdersPage;
		AddtoCart objAddtoCart;
		Delete objDelete;
		
		@BeforeTest
		public void setup() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.navigate().to("https://jpetstore.aspectran.com/catalog/");
			
			
		}
	 @Test
	public void Cart() {
		objAddtoCart = new AddtoCart(driver);
		objAddtoCart .AddToCart("bulldog");
		objAddtoCart .Update_Quantity("4");
		objAddtoCart .Click_on_Update();
		objAddtoCart .Remove_All();
	}

	//Checkout
	@Test
	public void addPetToCart() {
		
		
		driver.findElement(By.xpath("//body/section[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/input[1]")).sendKeys("Angelfish");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'FI-SW-01')]")).click();
		driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]")).click();
	}

	//Validating order placed successfully
	@Test
	public void testOrderPlacedSuccessfully() {
		
		cartPage= new CartPage(driver);
		cartPage.clickProceedToCheckout();

		checkoutPage= new CheckoutPage(driver);
		checkoutPage.clickContinue();

		checkoutPage= new CheckoutPage(driver);
		checkoutConfirmPage.clickConfirm();

		myOrdersPage= new Myorderspage(driver);
		myOrdersPage.validateMessage();


	}
	
 }