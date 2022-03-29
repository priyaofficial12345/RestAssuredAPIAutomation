package RSRESTAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class Basics1 {

	
public static void main(String[] args) {

		
		//validate if Add place API is working as expected
		

		//Given- all input details
		//When- submit the API== resource, http method
		//Then- validate the response
		
		RestAssured.baseURI=  "https://rahulshettyacademy.com";
		
		//given belongs to restassured static package so we need to import static package from the restassured library
		//chaining
		//body method accepts string and eclipse will convert json format into string format which java accepts

		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}").when().post("maps/api/place/add/json")// resource
		//.then().log().all().statusCode(200);
		.then().log().all().statusCode(200)
		.body("scope", equalTo("APP"));//equalTo method is of hamcrest static package which we need to import
       // .header("Server", "Apache/2.4.18 (Ubuntu)");//for output validation
        
        
        
        
        
}
}
