package UserRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class UsernameNotFoundNegative {
	
	@Test
	public void getByusername() {
		RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		    Response response = request.get("/v2/user/prava");
		   
		  ResponseBody body = response.getBody();
		  
		    System.out.println("Response Body is: " + body.asString());
		    // Print the status and message body of the response received from the server
		    System.out.println("Status received => " + response.getStatusLine());
		    //Response in pretty format
		    System.out.println("Response=>" + response.prettyPrint());
		   
		    JsonPath jsonPathEvaluator = response.jsonPath();
		    System.out.println("The username is : " + jsonPathEvaluator.get("username"));
		    
		    
		    
		   }
		}