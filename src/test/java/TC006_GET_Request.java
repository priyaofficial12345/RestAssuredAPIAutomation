import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Request {
  @Test
  void ValidatingEachValueInResponseBody()
	{
	//specify base URI
		//RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";

			RestAssured.baseURI="https://mausam.imd.gov.in/imd_latest/contents";
			
			//Request Object
			RequestSpecification httprequest=RestAssured.given();
				
			//Response Object
			//Response response=httprequest.request(Method.GET, "/Delhi");

			Response response=httprequest.request(Method.GET, "/districtwise-warning.php");

			
			//govt
			//Using jsonpath we can extract all the values from response
			JsonPath jsonpath= response.jsonPath();
		System.out.println(jsonpath.get("amcharts"));
		System.out.println(jsonpath.get("projection"));
		System.out.println(jsonpath.get("leftLongitude"));
		System.out.println(jsonpath.get("topLatitude"));
		System.out.println(jsonpath.get("rightLongitude"));
		System.out.println(jsonpath.get("bottomLatitude"));
		
		//Assert.assertEquals(jsonpath.get("amcharts), )
		
		/*
		// demoqa
		JsonPath jsonpath1= response.jsonPath();
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonpath.get("Temperature"), "39 Degree celsius");

		*/
		




	}
}
