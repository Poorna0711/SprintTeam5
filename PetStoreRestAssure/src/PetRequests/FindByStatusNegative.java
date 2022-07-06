package PetRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FindByStatusNegative {
   
@Test
public void getStatus() {

RestAssured.baseURI ="https://petstore.swagger.io";
RequestSpecification request = RestAssured.given();
    Response response = request.get("/v2/pet/findByStatus?status=delivered");
   
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
	}
	
	
	
    JsonPath jsonPathEvaluator = response.jsonPath();
    System.out.println("The status is : " + jsonPathEvaluator.get("status"));
    
   }
}