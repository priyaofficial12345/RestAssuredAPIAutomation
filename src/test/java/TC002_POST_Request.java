import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
  @Test
  void RegistrationSuccessful()
	{
		//specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
	    //RestAssured.baseURI= "https://www.india.gov.in";
	  
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
			
		
		// Request payload along with post request
		//JsonPath class takes string as input and convert that into output, it will help to pass the json
		JSONObject requestparams= new JSONObject();
		
		requestparams.put("FirstName", "JohnXYZ" );
		requestparams.put("LastName", "XYZJohn" );
		requestparams.put("UserName", "JohnXYZ" );
		requestparams.put("Password", "JohnXYZxyz" );
		requestparams.put("Email", "JohnXYZ@gmail.com" );

		httprequest.header("Content-Type", "application/json");
		
		//Attach above data to the request
		httprequest.body(requestparams.toJSONString());
		
		//Response Object
		Response response=httprequest.request(Method.POST, "/register");
		//Response response=httprequest.request(Method.POST, "/online-registration");
		
		
		//print response in console window
		String responseBody= response.getBody().asString();
		System.out.println("Response Body is:" + responseBody );
		
		
		//status code validation
		int statuscode= response.getStatusCode();
		System.out.println("Status Code is : " + statuscode);
		Assert.assertEquals(statuscode, 201);
		
		//Success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("SuccessCode is : " + successCode);
		//Assert,assertEquals(successCode, “OPERATION_SUCCESS”);
		
  }
}
