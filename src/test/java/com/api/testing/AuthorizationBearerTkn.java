package com.api.testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AuthorizationBearerTkn {

    @Test
    public void bearerAuthTest(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("email", "hussainhyder584@gmail.com");
        jsonData.put("password", "Dulqar#547");

        
        // Print JSON
        System.out.println(jsonData.toString());

        RestAssured.baseURI = "https://api.restful-api.dev/login";

		RestAssured.given().
        headers("x-api-key", "3db66f63-bfd0-4a76-80f8-bfa6fc0e28e2").
        contentType(ContentType.JSON).
        body(jsonData.toJSONString()).
        when().post().
        then().statusCode(200).log().all();
    }

    @Test
    public void bearerAuthTest2(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("email", "hussainhyder584@gmail.com");
        jsonData.put("password", "Dulqar#547");

        RequestSpecification requestSpec = RestAssured.given();

        requestSpec.baseUri("https://api.restful-api.dev/login");
        requestSpec.headers("x-api-key", "3db66f63-bfd0-4a76-80f8-bfa6fc0e28e2").
        contentType(ContentType.JSON).body(jsonData.toJSONString());
        
        //create get request
		Response response = requestSpec.post();

        //read response body
		ResponseBody responseBody =  response.getBody();
		
		String responseString = responseBody.asString();

        //get json path view of response body
		JsonPath jsonPathView  = responseBody.jsonPath();

        String token = jsonPathView.get("token");
        System.out.println("Token : "+token);

    }

    @Test
    public void createUser(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Apple MacBook Pro 17");
        // Create nested "data" object
        JSONObject data = new JSONObject();
        data.put("year", 2019);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");

        // Attach nested object
        jsonData.put("data", data);

        // Print JSON
        System.out.println(jsonData.toString());

        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.baseUri("https://api.restful-api.dev");
        requestSpec.basePath("/collections/products/objects");
        
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJodXNzYWluaHlkZXI1ODRAZ21haWwuY29tIiwibmFtZSI6Ikh1c3NhaW4gQmFzaGEgU2hhaWsiLCJleHAiOjE3NzY0NDc4OTMsImlhdCI6MTc3NjQ0NDI5M30.WgLqVJbj8vfWWLxvfswkxL4JR84JDcugbp8R5_KXL6Y";

        requestSpec.headers("x-api-key", "3db66f63-bfd0-4a76-80f8-bfa6fc0e28e2",
        "Authorization","Bearer "+token).
        contentType(ContentType.JSON).body(jsonData.toJSONString());

        //create get request
		Response response = requestSpec.post();

        //read response body
		ResponseBody responseBody =  response.getBody();
		
		String responseString = responseBody.asString();

        System.out.println("Response Body : "+responseString);



    }
}
