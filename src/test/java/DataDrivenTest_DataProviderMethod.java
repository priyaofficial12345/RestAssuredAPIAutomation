import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//Post request with multiple sets of hard core data

public class DataDrivenTest_DataProviderMethod {
	
	@Test(dataProvider= "empdataprovider")
	  public void postNewEmployees(String ename, String esal, String eage) 

	  {
		  RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		  
		  RequestSpecification httpRequest= RestAssured.given();
		  
		  //Here we created data which we can send along with the post request
		  
		  JSONObject requestParams = new JSONObject();
		  
		  // Data is in Hashmap format- Key Value Pair
		  requestParams.put("name", "ename");
		  requestParams.put("salary", "esal");
		  requestParams.put("age", "eage");

		  //To specify that the above data is in JSON format
		 // Header is JSON but Data is in Hashmap format(Key-Value pair)
		  httpRequest.header("Content-Type", "application/json");
		  
		  //Add the JSON to the body of the request
		  // To get the data in JSON format string
		  httpRequest.body(requestParams.toJSONString());
		  
		  //Post request
		  Response response= httpRequest.request(Method.POST, "/create");
		  
		 
		  //Capture response body to perform validations
		  
		 String responseBody=  response.getBody().asString();
		 System.out.println("Response body is : " + responseBody);
		 
		 Assert.assertEquals(responseBody.contains("aname"), true);
		 Assert.assertEquals(responseBody.contains("esal"), true);
		 Assert.assertEquals(responseBody.contains("eage"), true);

		  
		  int statuscode= response.getStatusCode();
		  Assert.assertEquals(statuscode, 200);
		 
	  }
	
		  @DataProvider(name="empdataprovider")
		  String [] [] getEmpData()
          {
          String empdata[] [] = { {"abc123", "30000", "40", "xyz123", "40000", "30", "pqr123", "80000", "50"} };
		  
		  return (empdata);
	      }


}
