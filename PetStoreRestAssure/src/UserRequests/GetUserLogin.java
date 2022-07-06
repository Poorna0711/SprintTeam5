package UserRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserLogin {

    @Test
    public void LoginUser() {
    	RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		    Response response = request.get("/v2/user/login?username=dammy&password=pass22");
       given().urlEncodingEnabled(true)
            .param("username", "dyno")
            .param("password", "string");
       ResponseBody body = response.getBody();
		  
	    System.out.println("Response Body is: " + body.asString());
	    // Print the status and message body of the response received from the server
	    System.out.println("Status received => " + response.getStatusLine());
	    //Response in pretty format
	    System.out.println("Response=>" + response.prettyPrint());
	   
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    System.out.println("The message is : " + jsonPathEvaluator.get("message"));
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
