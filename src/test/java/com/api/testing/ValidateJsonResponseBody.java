package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {

    @Test
	public void UserListResponseBody(){
        //Get RequestSpecifction Reference
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base URI & base path
		requestSpec.baseUri("https://api.restful-api.dev");
        requestSpec.basePath("/objects/3");
		
		//create/perform get request
		Response response = requestSpec.get();
		
		//read response body
		ResponseBody responseBody =  response.getBody();
		
		String responseString = responseBody.asString();
		
		//print response body
		System.out.println("Response body:" + responseString);

        //check for presence of George in response body
		
		Assert.assertEquals(responseString.contains("Apple iPhone 12 Pro Max"),true,"Check for presence of George");
		
		//get json path view of response body
		JsonPath jsonPathView  = responseBody.jsonPath();
		
		//x.data.color
		String color = jsonPathView.get("data.color");
		
		System.out.println("name : "+ jsonPathView.get("name"));
		Assert.assertEquals(color,"Cloudy White","Check for device colour should be Cloudy White");
    }
    
}
