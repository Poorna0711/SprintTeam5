package PetRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class InvalidIdNegative {
	
	@Test
	public void getById() {
		RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		    Response response = request.get("/v2/pet/129");
		   
		  ResponseBody body = response.getBody();
		  
		    System.out.println("Response Body is: " + body.asString());
		    // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		    //Response in pretty format
		    System.out.println("Response=>" + response.prettyPrint());
		    
		    System.out.println("All Headers of response are :- ");
			Headers allHeaders = response.getHeaders();
			for(Header header : allHeaders)
			{
				System.out.print(header.getName() +" : ");
				System.out.println(header.getValue());
				
				Assert.assertEquals(404,response.getStatusCode());
			    System.out.println("The status code is:" + response.getStatusCode());
	
			    
			   
			}
			
			JsonPath jsonPathEvaluator = response.jsonPath();
		    System.out.println("The petId is : " + jsonPathEvaluator.get("id"));
		    
		   }
		}