import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
  @Test
  void googlemaptest()
	{
		//specify base URI
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
			
		//Response Object
		//Response response=httprequest.request(Method.GET, "/Hyderabad");
		Response response=httprequest.request(Method.GET, "https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		
		//print response in console window
		String responseBody= response.getBody().asString();
		System.out.println("Response Body is : " + responseBody );
		
		
		//Validating headers
	    //Capture details of content type header
		String contentType= response.header("Content-Type");
		System.out.println("Content Type is : " + contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8" );
		
		
		 //Capture details of content encoding header
		String contentEncoding= response.header("Content-Encoding");
		System.out.println("Content Encoding is : " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip" );
		
        System.out.println("Response Time is : " + response.time());

	}

}
