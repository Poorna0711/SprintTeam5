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

public class PostAddPet {
	@Test
    public void UpdateUser() throws IOException {
      FileInputStream fis = new FileInputStream("C:\\Users\\POORNAJ\\Desktop\\Petstore\\PostAddPet.xlsx");
        	XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet ws = workbook.getSheetAt(0);
            int rownum  = ws.getLastRowNum();
            int colnum = ws.getRow(1).getPhysicalNumberOfCells();
            System.out.println(colnum);
            System.out.println(rownum);
            XSSFCell id;
            XSSFCell name;
            XSSFCell status;
            
            for(int i = 1; i <= rownum ; i++) {
                
                id=ws.getRow(i).getCell(0);
                name=ws.getRow(i).getCell(1);
                status=ws.getRow(i).getCell(2);
                
                
                RestAssured.baseURI = "https://petstore.swagger.io";
                
                System.out.println(id.toString());
                System.out.println(name.toString());
                System.out.println(status.toString());
               
                
                RequestSpecification request = RestAssured.given();
                Response response = request.body("{\"id\":\""+ id +"\","
                 		+ "\"name\":\""+name+"\","
            			+ "\"status\":\""+status+"\"}").post("/v2/pet");
                ResponseBody body = response.getBody();
                System.out.println(body.asString());
             
}
}

	
}