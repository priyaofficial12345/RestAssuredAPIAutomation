import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Request {
  @Test
  public void AuthenticationTest() 
  {
	        //specify base URI
			RestAssured.baseURI= "http://restapi.demoqa.com/authentication/CheckForAuthentication/";
			
			
			//Basic Authentication
			PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
			authscheme.setUserName("ToolsQA");
			authscheme.setPassword("TestPassword");
			
					
			//Assign  authscheme to RestAssured.authentication type
			RestAssured.authentication= authscheme;
			
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
				
			//Response Object
			Response response=httprequest.request(Method.GET, "/");// / Representing the home page, no parameters are there

			
			//print response in console window
			String responseBody= response.getBody().asString();
			System.out.println("Response Body is:" + responseBody );
			
			
			//status code validation
			int statuscode= response.getStatusCode();
			System.out.println("Status Code is : " + statuscode);
			Assert.assertEquals(statuscode, 200);
		
	        response.time();

	  
	  
	  
  }
}
