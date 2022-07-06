package UserRequests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
@Test
public class PostCreateUser 
{
@Test
public void Update() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Petstore\\PostCreateUser.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet ws = workbook.getSheetAt(0);
        int rownum  = ws.getLastRowNum();
        int colnum = ws.getRow(0).getPhysicalNumberOfCells();
        System.out.println(colnum);
        System.out.println(rownum);
        XSSFCell id;
        XSSFCell username;
        XSSFCell firstName;
        XSSFCell lastName;
        XSSFCell email;
        XSSFCell password;
        XSSFCell phone;
        XSSFCell userStatus;
        
        for(int i = 0; i <= rownum ; i++) {
            
            id = ws.getRow(i).getCell(0);
            username = ws.getRow(i).getCell(1);
            firstName=ws.getRow(i).getCell(2);
           lastName=ws.getRow(i).getCell(3);
           email=ws.getRow(i).getCell(4);
           password=ws.getRow(i).getCell(5);
           phone=ws.getRow(i).getCell(6);
            userStatus = ws.getRow(i).getCell(7);
	
	RestAssured.baseURI = "https://petstore.swagger.io";
	
	 System.out.println(id.toString());
	 System.out.println(username.toString());
     System.out.println(firstName.toString());
     System.out.println(lastName.toString());
     System.out.println(email.toString());
     System.out.println(password.toString());
     System.out.println(phone.toString());
     System.out.println(userStatus.toString());
     
     RequestSpecification request = RestAssured.given();
     Response response = request.body("{\"id\":\""+ id +"\","
     		+ "\"username\":\""+username+"\","
			+ "\"firstName\":\""+firstName+"\","
	+ "\"lastName\":\""+lastName+"\","
			+ "\"email\":\""+email+"\","
					+ "\"password\":\""+password+"\","
					+ "\"phone\":\""+phone+"\","
							+ "\"userStatus\":\""+userStatus+"\"}").put("/v2/user");
	
     ResponseBody body = response.getBody();
     
     System.out.println("Response Body is: " +body.asString());
     System.out.println("Response=>" + response.prettyPrint());
     Response response1 = null;
     
     try {
         response = RestAssured.given()
             .contentType(ContentType.JSON)
             .body(request)
             .put("/v2/user");
     } catch (Exception e) {
         e.printStackTrace();
     }

     
 }
}
}