package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_GetMethod {

    @Test
    public void getObject(){
        Response resp =   RestAssured.get("https://api.restful-api.dev/objects/3");
		System.out.println("Response code:" + resp.getStatusCode());
		System.out.println("Response body:" + resp.getBody().asString());
		System.out.println("Response Time:" + resp.getTime());
		System.out.println("Response Header:" + resp.getHeader("Content-Type"));
		
		//validate status code
		int expectedStatusCode = 200;
		int ActualStatuscode = resp.getStatusCode();
		
		Assert.assertEquals(expectedStatusCode, ActualStatuscode);
    }

	@Test
	public void getObject2()
	{
		//given , when, then
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		RestAssured.given().param("id", 2)
		.when().get()
		.then().statusCode(200);
		
	}




}
