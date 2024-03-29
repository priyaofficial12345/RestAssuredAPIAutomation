package RSRESTAPI;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class MockComplexJsonParse {
 
	/*Expected Response Body
	  { "dashboard": {

"purchaseAmount": 910,

"website": "rahulshettyacademy.com"},

"courses": [{

"title": "Selenium Python",

"price": 50,

"copies": 6},

{"title": "Cypress",

"price": 40,

"copies": 4},

{"title": "RPA",

"price": 45,

"copies": 10}]

}
  
  
Nodes:

  	
	object		{2}
		
	dashboard		{2}
		
purchaseAmount	:	910
		
website	:	rahulshettyacademy.com
		
	courses		[3]
		
	0		{3}
		
title	:	Selenium Python
		
price	:	50
		
copies	:	6
		
	1		{3}
		
title	:	Cypress
		
price	:	40
		
copies	:	4
		
	2		{3}
		
title	:	RPA
		
price	:	45
		
copies	:	10
  
	  */
	
	
	 
	public static void main(String args[])
	{
		
	  JsonPath js=new JsonPath(Payload.CoursePrice());
	  
	  //Traverse from parent to child with dot operator in it e.g. courses.size(), dashboard.purchaseAmount()
	  //1. Print No of courses returned by API
	  
	  int count=js.getInt("courses.size()");//Size method can be applied only for array
	 System.out.println(count); 
	 
	 //2.Print Purchase Amount

	 int TotalAmount=js.getInt("dashboard.purchaseAmount");
	 System.out.println(TotalAmount);
	 
	 //3. Print Title of the first course 

	 String FirstCourseTitle=js.get("courses[0].title");// Get method by default can pull up the string
     System.out.println(FirstCourseTitle);
	 
     //4. Print All course titles and their respective Prices (Dynamic Array- Many number of courses and prices will be there)
/*
     String FirstCourseTitle1=js.get("courses[0].title");// Get method by default can pull up the string
     int FirstCoursePrice= js.get("courses[0].price");
     System.out.println(FirstCourseTitle);
     System.out.println(FirstCoursePrice);

     String SecondCourseTitle=js.get("courses[1].title");// Get method by default can pull up the string
     int SecondCoursePrice= js.get("courses[1].price");
     System.out.println(FirstCourseTitle);
     System.out.println(SecondCoursePrice);

     String ThirdCourseTitle=js.get("courses[2].title");// Get method by default can pull up the string
     int ThirdCoursePrice= js.get("courses[2].price");
     System.out.println(FirstCourseTitle);
     System.out.println(ThirdCoursePrice);
*/
	 for(int i=0; i<count; i++)
	 {
		 String courseTitles= js.get("courses["+i+"].title");// Inserting variable i between the string
		 System.out.println(courseTitles);

		 // int coursePrice= js.get("courses["+i+"].price");
		 //System.out.println(coursePrice);
		System.out.println(js.get("courses["+i+"].price").toString()); 
	 }
	 
     //5. Print no of copies sold by RPA Course
System.out.println("Number of copies sold by RPA Course");

    for(int i=0; i<count; i++)
    {
    	String courseTitles=js.get("courses["+i+"].title");
    	if(courseTitles.equalsIgnoreCase("RPA"))
    	{
    		int copies=js.getInt("courses["+i+"].copies");
    		System.out.println(copies);
    		break;
    	}
    }
	
	 //6. Verify if Sum of all Course prices matches with Purchase Amount
	int sum =0;

    for(int i=0; i<count; i++)
    {
	
    		int price=js.getInt("courses["+i+"].price");
    		int copies=js.getInt("courses["+i+"].copies");
    		int amount=price * copies;
    		System.out.println(amount);
    		sum=sum + amount;
    	
    }
    System.out.println(sum);
    int purchaseamount= js.getInt("dashboard.purchaseAmount");
    
    Assert.assertEquals(sum, purchaseamount);
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
