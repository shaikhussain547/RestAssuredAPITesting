package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {

    @Test
    public void getObject(){

        //specify base URL
        RestAssured.baseURI = "https://api.restful-api.dev/objects/3";

        //Get Request specifcation of the request
        RequestSpecification requestSpec = RestAssured.given();

        //Call get method
        Response response = requestSpec.get();

        //gets response code
		int statusCode = response.getStatusCode();
		
		//validate actual status code with expected
		
		Assert.assertEquals(statusCode,200,"incorrect status code received");
		String statusLine = response.getStatusLine();
        System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","incorrect status line returned");

    }

    @Test
    public void getObject2(){

        //specify base URL
        RestAssured.baseURI = "https://api.restful-api.dev/objects/3";

        //Get Request specifcation of the request
        RequestSpecification requestSpec = RestAssured.given();

        //Call get method
        Response response = requestSpec.get();

        ValidatableResponse validateRes = response.then();
        //status code 
		validateRes.statusCode(200);
		
		System.out.println("second validation");
		//status line
		validateRes.statusLine("HTTP/1.1 200 OK");
    }

    @Test
	public void GetSingleUser_BDDStyle()
	{
		RestAssured.given()
		.when()
			.get("https://api.restful-api.dev/objects/3")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
            .log().all();
	}

}
