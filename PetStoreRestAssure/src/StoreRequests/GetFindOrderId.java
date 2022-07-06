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



public class GetFindOrderId {
	@Test
	public void getById() {
		
		RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		    Response response = request.get("/v2/store/order/5");
		   
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
		    Assert.assertEquals(200,response.getStatusCode());
		    System.out.println("The status code is:" + response.getStatusCode());
		    System.out.println("Response=>" + response.prettyPrint());
		    io.restassured.http.Headers allHeaders = response.headers();
	        //Iterate over all the Headers
	        for(Header header1 : allHeaders) {
	            System.out.println("Key: " + header1.getName() + " Value: " + header1.getValue());
	        }
		    String contentType = response.header("Content-Type");
	        System.out.println("Content-Type value: " + contentType);
	        Assert.assertEquals(contentType /* actual value */, "application/json" /*expected value */);
	        //Access header with a given name.
	        String serverType = response.header("Server");
	        System.out.println("Server value: " + serverType);
	        Assert.assertEquals(serverType /* actual value */, "Jetty(9.2.9.v20150224)" /* expected value */);
		    }
	}
}