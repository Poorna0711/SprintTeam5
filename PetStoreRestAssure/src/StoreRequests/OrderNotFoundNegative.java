package StoreRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class OrderNotFoundNegative {
	@Test
	public void getById() {
		
		RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		    Response response = request.get("/v2/store/order/7000");
		   
		  ResponseBody body = response.getBody();
		  
		    System.out.println("Response Body is: " + body.asString());
		    // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		    //Response in pretty format
		    System.out.println("Response=>" + response.prettyPrint());
		    
		   
			
			Headers allHeaders1 = response.headers(); 
			 // Iterate over all the Headers 
			 for(Header header : allHeaders1) { 
			   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
			
		    JsonPath jsonPathEvaluator = response.jsonPath();
		    System.out.println("The oderId is : " + jsonPathEvaluator.get("id"));
		    
		    
		    System.out.println("Status received => " + response.getStatusLine());
		    //Response in pretty format
		    System.out.println("Response=>" + response.prettyPrint());
		    Assert.assertEquals(404,response.getStatusCode());
		    System.out.println("The status code is:" + response.getStatusCode());
		    
		   }
	}
}