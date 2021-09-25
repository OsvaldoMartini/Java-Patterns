//package com.training.cucumber;
//
//import org.hamcrest.Matchers;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class RestApiTests {
//
//	private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
//	private static final String USERNAME = "osvaldo.martini@gmail.com";
//	private static final String PASSWORD = "martini";
//	private static final String BASE_URL = "https://bookstore.toolsqa.com";
//
//	private static String token;
//	private static Response response;
//	private static String jsonString;
//	private static String bookId;
//
//	@Given("^I am an authorized user for Project Template$")
//	public void I_am_an_authorized_user_for_Project_Template() {
//
//		RestAssured.baseURI = BASE_URL;
//		RequestSpecification request = RestAssured.given();
//
//		request.header("Content-Type", "application/json");
//		response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
//				.post("/Account/v1/GenerateToken");
//
//		response.then().body("token", Matchers.any(String.class));
//
//		String jsonString = response.asString();
//		token = JsonPath.from(jsonString).get("token");
//	}
//
//	@When("^method GET$")
//	public void method_GET() {
//
//	}
//
//	@Then("^status 200$")
//	public void status_200() {
//
//	}
//
//}
