package FinalPom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Checkout.AddtoCart;
import Checkout.CartPage;
import Checkout.CheckoutPage;
import Checkout.Delete;
import Checkout.Myorderspage;
import Checkout.confirmPage;
import PomLogin.Account;
import PomLogin.Home;
import PomLogin.Login;
import PomLogin.TestAccount;
import PomSearch.PomSearch;
import PomSearch.PomSearchDetails;
import PomSearch.PomSearchpage;
import PomSearch.PomSearchProduct;
import PomSearch.PomTestSearch;
import PomSignup.Account2;
import PomSignup.SignUPPet;
import PomSignup.TestACc;

public class FinalTestAccount {
	String driverPath="C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;

	//Instantiation
	 Login objLogin;
	    Home objHome;
	    TestAccount objAccount;
	    PomSearchpage objSearchPage;
		PomSearch objSearch;
		PomSearchProduct objSearchForProduct;
		PomSearchDetails objSearchForPetDetails;
		AddtoCart objAddtoCart;
		CartPage cartPage;
		CheckoutPage checkoutPage;
		confirmPage checkoutConfirmPage;
		Myorderspage myOrdersPage;
		Delete objDelete;
		

	//Launching fire fox 
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://jpetstore.aspectran.com/catalog/");
	}

	

	//Logging in & validating welcome message
	@Test(priority=0)
    public void test_Home_Page_Appear_Correct() throws InterruptedException, IOException{
   
    //Create Object Of Home page
    objHome = new Home(driver);
    objHome.clickSignIn();
   
    objLogin = new Login(driver);
    objAccount = new TestAccount();
    FileInputStream fis = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Petstore\\POMPetStoreLogin.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet ws = workbook.getSheetAt(0);

int rownum  = ws.getLastRowNum();
int colnum = ws.getRow(0).getPhysicalNumberOfCells();
System.out.println(colnum);
System.out.println(rownum);
XSSFCell username;
XSSFCell password;
for(int i = 0; i <= rownum ; i++) {
 
   username = ws.getRow(i).getCell(0);
   password = ws.getRow(i).getCell(1);
   
	objLogin.loginToJPetStore(username.toString(),password.toString());
	Thread.sleep(3000);
	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='WelcomeContent']")).isDisplayed());		
	Assert.assertEquals(Home.getHomePageUserName(),"Welcome Team!");
	System.out.println("Welcome content : "+Home.getHomePageUserName());
	
	//Assert.assertTrue(objAccount.getusername().matches("[A-Z|a-z|\\W]+"));
	//objAccount.clickSignout();
	}   
    }

	private String getusername() {
		// TODO Auto-generated method stub
		return null;
	}

	

	//Search for pets
	@Test
		public void Search_Pet_Page() throws InterruptedException
		{
			objSearchPage = new PomSearchpage(driver);
			objSearchPage.Productname("Bulldog");

			driver.manage().window().maximize();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");

			//search for categories
			objSearch = new PomSearch(driver);
			driver.findElement(By.xpath("//a[contains(text(),'Dogs')]")).click();

			//search for product id
			objSearchForProduct = new PomSearchProduct (driver);
			driver.findElement(By.linkText("K9-BD-01")).click();

			//search for pet details
			objSearchForPetDetails = new PomSearchDetails(driver);
			driver.findElement(By.linkText("EST-6")).click();
			driver.findElement(By.xpath("//h3[contains(text(),'Bulldog')]")).click();
			driver.manage().window().maximize();
		}

	//Add to cart
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
			myOrdersPage.validateMessage();}


public void Delete() {
	objDelete = new Delete(driver);
	objDelete.My_Orders();
	objDelete.Order_Id();
	objDelete.Delete_Order();
		}
}