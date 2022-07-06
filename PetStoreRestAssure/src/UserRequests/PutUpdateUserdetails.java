package UserRequests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
public class PutUpdateUserdetails {
 
    @Test
    public void updateUser() {
 
        RestAssured.baseURI = "https://petstore.swagger.io";
 
        String requestBody = "{\"id\":\"90\",\"username\":\"zoie\",\"firstname\":\"zoozoo\","
        		+ "\"lastname\":\"zyy\",\"email\":\"zoie11@gmail.com\",\"password\":\"zoie\",\"phone\":\"3333\"}";
        		
 
 
        Response response = null;
 
        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/v2/user/daise");
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        System.out.println("Response :" + response.asString()); 
        System.out.println("Status Code :" + response.getStatusCode()); 
        System.out.println("Does Reponse contains 'message'? :" + response.asString().contains("message")); 
        
        assertEquals(200, response.getStatusCode());
    }
}