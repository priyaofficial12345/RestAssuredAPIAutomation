package RSRESTAPI;

public class Basics12 {

	package RSRESTAPI;

	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.equalTo;

	import Files.Payload;
	import io.restassured.RestAssured;

	public class BasicsWithPayloadClass {

		
	public static void main(String[] args) {

			
			//validate if Add place API is working as expected
			

			//Given- all input details
			//When- submit the API== resource, http method
			//Then- validate the response
			
			RestAssured.baseURI=  "https://rahulshettyacademy.com";
			
			//given belongs to restassured static package so we need to import static package from the restassured library
			//chaining
			//body method accepts string and eclipse will convert json format into string format which java accepts

			String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(Payload.Addplace()).when().post("maps/api/place/add/json")// resource
			//.then().log().all().statusCode(200);
			.then().statusCode(200)
			.body("scope", equalTo("APP"))//equalTo method is of hamcrest static package which we need to import
	        .extract().response().asString();
	
	
			System.out.println("Resonse Body is : " + response);
	}
	}


	