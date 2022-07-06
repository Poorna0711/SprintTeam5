package PomLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAccount {
String driverPath = "C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    Login objLogin;
    Home objHome;
    TestAccount objAccount;

 

    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jpetstore.aspectran.com/catalog/");
        System.out.println(driver.getTitle());
    }
   
    @SuppressWarnings("resource")
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
	XSSFCell uname;
	XSSFCell password;
	for(int i = 0; i <= rownum ; i++) {
	 
		uname = ws.getRow(i).getCell(0);
	   password = ws.getRow(i).getCell(1);
	   
	   objLogin.loginToJPetStore(uname.toString(),password.toString());
	   Thread.sleep(4000);
	   //Assert.assertTrue(objAccount.username().matches("[A-Z|a-z|\\W]+"));
	   objAccount.Signout();
	   }
	driver.close();
	   
    }

	private void Signout() {
		// TODO Auto-generated method stub
		
	}

	public String username() {
		
		// TODO Auto-generated method stub
		return null;
	}
}