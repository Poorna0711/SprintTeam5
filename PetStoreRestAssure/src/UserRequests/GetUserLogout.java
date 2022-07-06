package UserRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class GetUserLogout {
	
	@Test
	public void getUserList() {
		RestAssured.baseURI = "https://petstore.swagger.io";
	RequestSpecification request = RestAssured.given();
    Response Response = request.get("/v2/user/logout");
    
 // Retrieve the body of the Response
    ResponseBody body = Response.getBody();
    //Response in raw format
    System.out.println("Response Body is: " + body.asString());
    // Print the status and message body of the response received from the server
    System.out.println("Status received => " + Response.getStatusLine());
    //Response in pretty format
    System.out.println("Response=>" + Response.prettyPrint());

 // Get all the headers and then iterate over allHeaders to print each header
    Headers allHeaders = Response.headers();
   // Iterate over all the Headers
    for(Header header : allHeaders) {
      System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
   
      // Assert that correct status code is returned.
      int statusCode = Response.getStatusCode();
      Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
     
      //Assert Status line
      String statusLine = Response.getStatusLine();
      Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
  
      String contentType = Response.header("Content-Type");
      System.out.println("Content-Type value: " + contentType);
      Assert.assertEquals(contentType /* actual value */, "application/json" /*expected value */);
      //Access header with a given name.
      String serverType = Response.header("Server");
      System.out.println("Server value: " + serverType);
      Assert.assertEquals(serverType /* actual value */, "Jetty(9.2.9.v20150224)" /* expected value */);
    
    
}
}}