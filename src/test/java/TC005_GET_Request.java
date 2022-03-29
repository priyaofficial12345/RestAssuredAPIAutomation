import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Request {
  @Test
  void ValidatingResponseBody()
	{
	//specify base URI
			RestAssured.baseURI="https://mausam.imd.gov.in/imd_latest/contents";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
				
			//Response Object
			Response response=httprequest.request(Method.GET, "/districtwise-warning.php");

			
			//print response in console window
			String responseBody= response.getBody().asString();
			System.out.println("Response Body is:" + responseBody );
			
		Assert.assertEquals(responseBody.contains("AURANGABAD"), true);
}
}