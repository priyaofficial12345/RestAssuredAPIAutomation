package RSRESTAPI;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ReUsableMethod {
  @Test
  public static JsonPath rawToJason(String response) 
  {
	  JsonPath js1=new JsonPath(response);
	  return js1;
	  
  }
}
