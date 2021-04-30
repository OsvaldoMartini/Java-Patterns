package com.training.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest_Api_Tests {
	
	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
	 private static final String USERNAME = "osvaldo.martini@gmail.com";
	 private static final String PASSWORD = "martini";
	 private static final String BASE_URL = "http://127.0.0.1:9095";
	 
	 private static String token;
	 private static Response response;
	 private static String jsonString;
	 private static String bookId;
	
  @Test
  public static void getResponseBody(){
	  
	  RestAssured.baseURI = BASE_URL;
	  RequestSpecification request = RestAssured.given();
	  
	  request.header("Content-Type", "application/json");
	  response = request.body("{ \"username\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
	  .post("/api/users/login/Project-Template");
	  
	  String jsonString = response.asString();
	  token = JsonPath.from(jsonString).get("token");
	  
	  System.out.println(token);	
	  
	  
//	  given().queryParam("CUSTOMER_ID","68195")
//	           .queryParam("PASSWORD","1234!")
//	           .queryParam("Account_No","1")
//	           .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
//	           .body();
	}
  
}
