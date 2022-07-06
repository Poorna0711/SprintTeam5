package PomSignup;

import org.testng.annotations.Test;

import PomLogin.Home;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestACc {
private static final String WebDriver = null;
String driverPath = "C:\\Users\\POORNAJ\\Desktop\\Selenium\\Selenium jar\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    SignUPPet objSignUPPet;
    Home objHome3;
    TestACc objAccount;

 

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
    Home objHome3 = new Home(driver);
    objHome3.clickSignUp();
   
    SignUPPet objSignUPPet = new SignUPPet();
    objAccount = new TestACc();
    FileInputStream fis = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Petstore\\CreateAccount.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
XSSFSheet ws = workbook.getSheetAt(0);

int rownum  = ws.getLastRowNum();
int colnum = ws.getRow(0).getPhysicalNumberOfCells();
System.out.println(colnum);
System.out.println(rownum);
XSSFCell username;
XSSFCell password;
XSSFCell repeatedPassword;
XSSFCell firstName;
XSSFCell lastName;
XSSFCell  email;
XSSFCell phone;
XSSFCell address1;
XSSFCell address2;
XSSFCell city;
XSSFCell state;
XSSFCell zip;
XSSFCell country;
for(int i = 0; i <= rownum ; i++) {
 
   username = ws.getRow(i).getCell(0);
   password = ws.getRow(i).getCell(1);
   repeatedPassword = ws.getRow(i).getCell(3);
   firstName = ws.getRow(i).getCell(4);
   lastName = ws.getRow(i).getCell(5);
   email = ws.getRow(i).getCell(6);
   phone = ws.getRow(i).getCell(7);
   address1 = ws.getRow(i).getCell(8);
   address2 = ws.getRow(i).getCell(9);
   city = ws.getRow(i).getCell(10);
   state = ws.getRow(i).getCell(11);
   zip = ws.getRow(i).getCell(12);
   country = ws.getRow(i).getCell(13);
   
   objSignUPPet.createAccount(username.toString(),password.toString(),repeatedPassword.toString(),firstName.toString(),
		   lastName.toString(),email.toString(),phone.toString(),address1.toString(),address2.toString(),
		   city.toString(),state.toString(),zip.toString());
driver.close();
   
    }
    }}