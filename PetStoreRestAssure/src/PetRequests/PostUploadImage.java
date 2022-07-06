package PetRequests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostUploadImage {

	
	@Test
	public void UploadImage() {
		RestAssured.baseURI="https://petstore.swagger.io";
		//Response res=
		RequestSpecification httpReq=RestAssured.given();
		
		Response res=httpReq.given().multiPart("file",new File("C:\\Users\\POORNAJ\\Downloads\\Dyno.jpeg")).post("/v2/pet/3/uploadImage");;
		ResponseBody body=res.getBody();
		//System.out.println("The status recieved: "+res.getStatusLine());
		System.out.println("Status Code is : "+res.getStatusCode());
		JsonPath eval=res.jsonPath();
		System.out.println("Code : "+eval.get("code"));
		System.out.println("Status : "+eval.get("message"));
			
 }

	

	
}