package PetRequests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PutUpdateExistingPet {
	@Test
    public void UpdateUser() throws IOException {
      FileInputStream fis = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Petstore\\PutUpdateExistingPet.xlsx");
        	XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet ws = workbook.getSheetAt(0);
            int rownum  = ws.getLastRowNum();
            int colnum = ws.getRow(1).getPhysicalNumberOfCells();
            System.out.println(colnum);
            System.out.println(rownum);
            XSSFCell id;
            XSSFCell username;
            XSSFCell firstname;
            XSSFCell lastname;
            XSSFCell email;
            XSSFCell password;
            XSSFCell phone;
            for(int i = 0; i <= rownum ; i++) {
                
                id=ws.getRow(i).getCell(0);
                username=ws.getRow(i).getCell(1);
                firstname=ws.getRow(i).getCell(2);
                lastname=ws.getRow(i).getCell(3);
                email=ws.getRow(i).getCell(4);
                password=ws.getRow(i).getCell(5);
                phone=ws.getRow(i).getCell(6);
                
                RestAssured.baseURI = "https://petstore.swagger.io";
                
                System.out.println(id.toString());
                System.out.println(username.toString());
                System.out.println(firstname.toString());
                System.out.println(lastname.toString());
                System.out.println(email.toString());
                System.out.println(password.toString());
                System.out.println(phone.toString());
                
                RequestSpecification request = RestAssured.given();
                Response response = request.body("{\"id\":\""+ id +"\","
                 		+ "\"username\":\""+username+"\","
            			+ "\"firstname\":\""+firstname+"\","
            	+ "\"lastname\":\""+lastname+"\","
            			+ "\"email\":\""+email+"\","
            					+ "\"password\":\""+password+"\","
            							+ "\"phone\":\""+phone+"\"}").put("/v2/pet");
            	;

                ResponseBody body = response.getBody();
                System.out.println(body.asString());
             
}
}

	
}