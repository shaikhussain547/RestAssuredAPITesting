package com.api.testing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {

    @Test
	public void getObjects() {
		
		//https://restful-api.dev/
		
		Response resp =   RestAssured.get("https://api.restful-api.dev/objects");
		System.out.println(resp.asString());
		System.out.println("Status Code : "+resp.getStatusCode());
		
	}

	@Test
	public void getUsers() {
		
		//https://httpbin.org/
		
		Response resp =   RestAssured.get("https://httpbin.org/get");
		System.out.println(resp.asString());
		System.out.println("Status Code : "+resp.getStatusCode());
		
	}

}
