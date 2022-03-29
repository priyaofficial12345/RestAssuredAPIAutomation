import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	
	
    @Test
	void getweatherDetails()
	{
		//specify base URI
		//RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI="https://mausam.imd.gov.in/imd_latest/contents";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
			
		//Response Object
		//Response response=httprequest.request(Method.GET, "/Hyderabad");
		Response response=httprequest.request(Method.GET, "/districtwise-warning.php");

		
		//print response in console window
		String responseBody= response.getBody().asString();
		System.out.println("Response Body is:" + responseBody );
		
		
		//status code validation
		int statuscode= response.getStatusCode();
		System.out.println("Status Code is : " + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		String statusline= response.getStatusLine();
		System.out.println("Status line is : " + statusline);
		Assert.assertEquals(statusline,  "HTTP/1.1 200 OK");
		
        response.time();

		
		
	}
}



