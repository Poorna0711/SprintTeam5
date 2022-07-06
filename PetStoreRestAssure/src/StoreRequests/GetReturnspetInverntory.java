package StoreRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetReturnspetInverntory {
   
@Test
public void getReturn() {

RestAssured.baseURI ="https://petstore.swagger.io";
RequestSpecification request = RestAssured.given();
    Response response = request.get("/v2/store/inventory");
   
  ResponseBody body = response.getBody();
  
    System.out.println("Response Body is: " + body.asString());
    // Print the status and message body of the response received from the server
    System.out.println("Status received => " + response.getStatusLine());
    //Response in pretty format
    System.out.println("Response=>" + response.prettyPrint());
   
    JsonPath jsonPathEvaluator = response.jsonPath();
    System.out.println("The status is : " + jsonPathEvaluator.get("status"));
    System.out.println("Response=>" + response.prettyPrint());
    io.restassured.http.Headers allHeaders = response.headers();
    //Iterate over all the Headers
    for(Header header : allHeaders) {
        System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
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