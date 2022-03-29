import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Post request with single set of hard core data
public class DataDrivenTest_AddNewEmployees {
  @Test
  public void postNewEmployees() 

  {
	  RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
	  
	  RequestSpecification httpRequest= RestAssured.given();
	  
	  //Here we created data which we can send along with the post request
	  
	  JSONObject requestParams = new JSONObject();
	  
	  // Data is in Hashmap format- Key Value Pair
	  requestParams.put("name", "SMITHXYZ");
	  requestParams.put("salary", "700");
	  requestParams.put("age", "40");

	  //To specify that the above data is in JSON format
	 // Header is JSON but Data is in Hashmap format(Key-Value pair)
	  httpRequest.header("Conetnt-Type", "application/json");
	  
	  //Add the JSON to the body of the request
	  // To get the data in JSON format string
	  httpRequest.body(requestParams.toJSONString());
	  
	  //Post request
	  Response response= httpRequest.request(Method.POST, "/create");
	  
	 
	  //Capture response body to perform validations
	  
	 String responseBody=  response.getBody().asString();
	 Assert.assertEquals(responseBody.contains("SMITHXYZ"), true);
	 Assert.assertEquals(responseBody.contains("700"), true);
	 Assert.assertEquals(responseBody.contains("40"), true);

	  
	  int statuscode= response.getStatusCode();
	  Assert.assertEquals(statuscode, 200);
	  

	  
	  
  }





}
