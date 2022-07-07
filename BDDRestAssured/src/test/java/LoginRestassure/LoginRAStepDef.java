package LoginRestassure;

import java.util.List;

import org.junit.Assert;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginRAStepDef {
	private static Response response;
	
	@When("^I request for pet details$")
	public void I_request_for_pet_details() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		response = request.get("/v2/pet/findByStatus?status=available");
        System.out.println("Response=>" + response.prettyPrint());
       
		
	}
	@Then("^I get pet details$")
	public void I_get_pet_details() {
		
	Assert.assertEquals(200, response.getStatusCode());
         }
	@When("^I request for pet details by id$")
	public void I_request_for_pet_details_by_id() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		System.out.println("Response=>" + response.prettyPrint());
		
       
	      }
	@Then("^I get pet information$")
	public void I_get_pet_information() {
		RequestSpecification request = RestAssured.given();
	    response = request.get("/v2/pet/88");
	    System.out.println("Response=>" + response.prettyPrint());
		}
	
	@When("I delete a pet")
	public void I_delete_a_pet() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification request = RestAssured.given();
		response = request.delete("/v2/pet/15");
		System.out.println("Response=>" + response.prettyPrint());
}
	@Then("The pet gets deleted")
	public void the_user_gets_deleted() {
	   Assert.assertEquals(200 ,response.getStatusCode());
	}
	

	    	@When("I update a pet detail")
	    	public void i_update_a_pet_detail(DataTable dt) {
	    		
	    	List<String> list = dt.transpose().asList(String.class);
	    	
	       	  String petId = dt.cell(0,0);
	          String name = dt.cell(0,1);
	          String status = dt.cell(0,2);
	        
	        RestAssured.baseURI = "https://petstore.swagger.io";
	        RequestSpecification request = RestAssured.given();
	        response = request.body("\"petId\":\"" +petId +"\",{\"name\":\"" + name +"\","
	        		+ " \"status\":\"" + status +"\"}").post("/v2/pet/53");
	        
	        
	       
	            System.out.println("Response=>" + response.prettyPrint());
	            System.out.println("petId - " + list.get(0));
			       
	            System.out.println("name - " + list.get(1));
		        System.out.println("status - " + list.get(2));
		       
	        
	    }
	    	
	    	@Then("The pet details updated")
	        public void The_pet_details_updated() {
		
		    Assert.assertEquals(200 ,response.getStatusCode());
	}
	    	@When("place order for a pet")
	    	public void place_a_order_for_a_pet(DataTable dt) {
	    		
	    	List<String> list = dt.transpose().asList(String.class);
	    	
	       	  String id = dt.cell(0,0);
	          String petId = dt.cell(0,1);
	          String quantity = dt.cell(0,2);
	        
	        RestAssured.baseURI = "https://petstore.swagger.io";
	        RequestSpecification request = RestAssured.given();
	        response = request.body("\"id\":\"" +id +"\",{\"petId\":\"" + petId +"\","
	        		+ " \"quantity\":\"" + quantity +"\"}").post("/v2/store/order");
	        
	        
	       
	            System.out.println("Response=>" + response.prettyPrint());
	            System.out.println("id - " + list.get(0));
			       
	            System.out.println("petId - " + list.get(1));
		        System.out.println("quantity - " + list.get(2));
		       
	        
	    }
	    	
	    	@Then("order is placed")
	        public void order_is_placed() {
		
		    Assert.assertEquals(200 ,response.getStatusCode());
	}
	    	@When("^I request for order details by id$")
	    	public void I_request_for_order_details_by_id() {
	    		RestAssured.baseURI = "https://petstore.swagger.io";
	    		RequestSpecification request = RestAssured.given();
	    		System.out.println("Response=>" + response.prettyPrint());
	    		
	           
	    	      }
	    	@Then("^I get order information$")
	    	public void I_get_order_information() {
	    		RequestSpecification request = RestAssured.given();
	    	    response = request.get("/v2/store/order/6");
	    	    System.out.println("Response=>" + response.prettyPrint());
	    		}
	    	@When("I delete a order")
	    	public void I_Delete_a_order() {
	    		RestAssured.baseURI = "https://petstore.swagger.io";
	    		RequestSpecification request = RestAssured.given();
	    		response = request.delete("/v2/store/order/25");
	    		System.out.println("Response=>" + response.prettyPrint());
	    }
	    	@Then("The order gets deleted")
	    	public void the_order_gets_deleted() {
	    	   Assert.assertEquals(200 ,response.getStatusCode());
	    	}
	    	@When("get user with username")
	    	public void get_user_with_username() {
	    		RestAssured.baseURI = "https://petstore.swagger.io";
	    		RequestSpecification request = RestAssured.given();
	    		response = request.get("/v2/user/chocolate");
	    		System.out.println("Response=>" + response.prettyPrint());
	    }
	    	@Then("gets user details")
	    	public void gets_user_details() {
	    	   Assert.assertEquals(200 ,response.getStatusCode());


	    	}
	    	@When("^login user with \"([^\"])\" and \"([^\"])\"$") 
	    	public void login_user_with_username_and_password(String username,String password){
	    		RestAssured.baseURI = "https://petstore.swagger.io";
	    	    RequestSpecification request = RestAssured.given();
	    	    response=request.body("{ \"name\":\"" + username + "\"password\":\""+password+"").post("/v2/user/login?username=coco&password=string");
	            System.out.println("Response=>" + response.prettyPrint());
	    		   }
	    	
	    	@Then("user got loggedin")
	    	public void user_got_logged_in() {
	    	   Assert.assertEquals(200 ,response.getStatusCode());
	    			

}
}
