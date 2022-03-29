package RSRESTAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BasicsWithJSONPATH {



	
	//validate if Add place API is working as expected
	//Add place --> Update place with new address --> Get place to validate if New address is present in response body

	//Given- all input details
	//When- submit the API== resource, http method
	//Then- validate the response
	
	public static void main(String args[]) {
		
	RestAssured.baseURI=  "https://rahulshettyacademy.com";
	
	//given belongs to restassured static package so we need to import static package from the restassured library
	//chaining
	//body method accepts string and eclipse will convert json format into string format which java accepts

	String response= given().log().all().
			queryParam("key", "qaclick123")
			.header("Content-Type","application/json")
	
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
				+ "}")
	.when().post("maps/api/place/add/json")// resource
	.then().statusCode(200)// //.then().log().all().statusCode(200);
	.body("scope", equalTo("APP"))//equalTo method is of hamcrest static package which we need to import
    .extract().response().asString();
	
	System.out.println("Response Body is : " + response);
	
	
	JsonPath js=new JsonPath(response);
	String placeid= js.getString("place_id");//
	System.out.println("Placeid is : " + placeid);
	
	
	//Update place with new address
	
	given().log().all().queryParam("key", "qaclick123")
	.header("Content-Type","application/json")
	.body("{\r\n"
			+ "     \"place_id\" : \""+placeid+"\",\r\n" //"+placeid+" this we need to concanate, that this is a variable, not the string
			+ "    \"address\" : \" 0000 Summer walk, Pune, India\",\r\n"
			+ "    \"key\" : \"qaclick123\"\r\n"
			+ "\r\n"
			+ "}"
			)
	.when()
	.put("maps/api/place/add/json")// resource
    .then().assertThat().log().all().statusCode(200);

	
	//Get place
	
	String getPlaceResponse= given().log().all().queryParam("key", "qaclick123")
	.queryParam("place_id", placeid)
	.when().get("maps/api/place/add/json")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	
	JsonPath js1=new JsonPath(getPlaceResponse);
	String actualaddress= js.getString("address");//
	System.out.println("Address is : " + placeid);
	
	
	}

}
