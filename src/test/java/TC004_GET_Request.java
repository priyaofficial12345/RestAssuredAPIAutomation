import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request {
  @Test
  void PrintingAllHeaders()
 	{
 		//specify base URI
 		RestAssured.baseURI= "https://maps.googleapis.com";
 		
 		//Request Object
 		RequestSpecification httprequest=RestAssured.given();
 			
 		//Response Object
 		Response response=httprequest.request(Method.GET, "https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

 		
 		//print response in console window
 		String responseBody= response.getBody().asString();
 		System.out.println("Response Body is : " + responseBody );
 		
 		//Printing all headers
 	    
 		Headers allheaders= response.headers(); // Capture all the headers from response
 		
 		for(Header header: allheaders)
 		{
 			System.out.println(header.getName() + "           " + header.getValue());
 			
 		}
 		
 	}

}
