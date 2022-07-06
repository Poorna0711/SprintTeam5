package StoreRequests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeletePurchase
{

	@Test
	public void delPurch() {
		RestAssured.baseURI ="https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		Response response=request.delete("/v2/store/order/3");
		ResponseBody body = response.getBody();
		    //Response in raw format
		    System.out.println("Response Body is: " + body.asString());
		    Assert.assertEquals(200,response.getStatusCode());
		    System.out.println("The status code is:" + response.getStatusCode());
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