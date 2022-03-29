package RSRESTAPI;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicsYT {
  @Test
  public void datadetails() 
  {
	  
	  RestAssured.baseURI= "https://rahulshettyacademy.com";
	  
	  RequestSpecification httprequest= RestAssured.given();
	  
	 /*
	  Response response=httprequest.request(Method.GET, "/maps/api/place/add/json?key= qaclick123");
	  
	  String responsebody=response.getBody().asString();
	  
	  System.out.println("Response Body is: " + responsebody);
	  
	  int statuscode=response.getStatusCode();
	  System.out.println("Status code is : " + statuscode);
	  Assert.assertEquals(statuscode, 200);
	  
	  String statusline=response.getStatusLine();
	  System.out.println("Status Line is : " + statusline);
	  Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	  
	  */
	  
	// Request payload along with post request
			JSONObject requestparams= new JSONObject();
			
			/*{
			  "location": {
				    "lat": -38.383494,
				    "lng": 33.427362
				  },
				  "accuracy": 50,
				  "name": "Frontline house",
				  "phone_number": "(+91) 983 893 3937",
				  "address": "29, side layout, cohen 09",
				  "types": [
				    "shoe park",
				    "shop"
				  ],
				  "website": "http://google.com",
				  "language": "French-IN"
				}
  */
			
			/*
			requestparams.put("lat", "-38.383494" );
			requestparams.put("lng", "33.427362" );
			requestparams.put("accuracy", "50" );
			requestparams.put("name", "Frontline house" );
			requestparams.put("phone_number", "(+91) 983 893 3937" );
			requestparams.put("address", "29, side layout, cohen 09");

			httprequest.header("Content-Type", "application/json");
			
			//Attach above data to the request
			httprequest.body(requestparams.toJSONString());
			
			//Response Object
			Response response=httprequest.request(Method.POST, "/maps/api/place/add/json?key= qaclick123");
			//Response response=httprequest.request(Method.POST, "/online-registration");
			
			
			//print response in console window
			String responseBody= response.getBody().asString();
			System.out.println("Response Body is:" + responseBody );
			
			  int statuscode=response.getStatusCode();
			  System.out.println("Status code is : " + statuscode);
			  Assert.assertEquals(statuscode, 200);
			  
			  String statusline=response.getStatusLine();
			  System.out.println("Status Line is : " + statusline);
			  Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
			  
			  */
			
			
			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body("{\n"
					+ "			  \"location\": {\n"
					+ "				    \"lat\": -38.383494,\n"
					+ "				    \"lng\": 33.427362\n"
					+ "				  },\n"
					+ "				  \"accuracy\": 50,\n"
					+ "				  \"name\": \"Frontline house\",\n"
					+ "				  \"phone_number\": \"(+91) 983 893 3937\",\n"
					+ "				  \"address\": \"29, side layout, cohen 09\",\n"
					+ "				  \"types\": [\n"
					+ "				    \"shoe park\",\n"
					+ "				    \"shop\"\n"
					+ "				  ],\n"
					+ "				  \"website\": \"http://google.com\",\n"
					+ "				  \"language\": \"French-IN\"\n"
					+ "				}").when().post("/maps/api/place/add/json?key= qaclick123")// resource
			//.then().log().all().statusCode(200);
			.then().log().all().statusCode(200);
  }
}
