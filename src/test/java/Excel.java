import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// Post Request with multiple sets of data using Excel
public class Excel {
	@Test(dataProvider= "empdataprovider")
	  public void postNewEmployees(String ename, String esal, String eage) 

	  {
		  RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		  
		  RequestSpecification httpRequest= RestAssured.given();
		  
		  //Here we created data which we can send along with the post request
		  
		  JSONObject requestParams = new JSONObject();
		  
		  // Data is in Hashmap format- Key Value Pair
		  requestParams.put("name", "ename");
		  requestParams.put("salary", "esal");
		  requestParams.put("age", "eage");

		  //To specify that the above data is in JSON format
		 // Header is JSON but Data is in Hashmap format(Key-Value pair)
		  httpRequest.header("Content-Type", "application/json");
		  
		  //Add the JSON to the body of the request
		  // To get the data in JSON format string
		  httpRequest.body(requestParams.toJSONString());
		  
		  //Post request
		  Response response= httpRequest.request(Method.POST, "/create");
		  
		 
		  //Capture response body to perform validations
		  
		 String responseBody=  response.getBody().asString();
		 System.out.println("Response body is : " + responseBody);
		 
		 Assert.assertEquals(responseBody.contains("aname"), true);
		 Assert.assertEquals(responseBody.contains("esal"), true);
		 Assert.assertEquals(responseBody.contains("eage"), true);

		  
		  int statuscode= response.getStatusCode();
		  Assert.assertEquals(statuscode, 200);
		 
	  }
	
		  @DataProvider(name="empdataprovider")
		  String [] [] getEmpData() throws IOException
        {
	    
		//Read data from excel	  
	    String path= "D:\\Work\\New XLSX Worksheet.xlsx";
	    //String path= "C:\\Users\\Priyanka\\eclipse-workspace\\RestAssuredAutomation\\src\\main\\resources\\EmpData.xlsx";
	    //String path= System.setProperty(user.dir) + "/src/main/resources/EmpData.xlsx";
	    
	  
		int rownum= XLUtils.getRowCount(path,"Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
	
		
	   String empdata [] []= new String [rownum] [colcount];
	   for(int i=1; i<=rownum; i++) // i is for rows, j is for columns
		   for(int j=0; j<colcount; j++)
		   {
			   empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
		   }
	   
       // String empdata[] [] = { {"abc123", "30000", "40", "xyz123", "40000", "30", "pqr123", "80000", "50"} };
		return (empdata);
	    }


}


