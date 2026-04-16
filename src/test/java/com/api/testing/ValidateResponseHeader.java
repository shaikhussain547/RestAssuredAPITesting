package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

    @Test
    public void getObject(){

        //Get Request Specification
		RequestSpecification requestSpec = RestAssured.given();

        //specify base URL
        requestSpec.baseUri("https://api.restful-api.dev");
        requestSpec.basePath("/objects/3");

        //create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.getHeader("Content-Type");
		
		//read all the response header attributes/keys and print their values
		Headers headersList = response.getHeaders();
		
		//iterate over header list 
		for (Header header:headersList)
		{
			System.out.println(header.getName() + ":" + header.getValue());
		}
		
		
		//validate header content-type , expected value : application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json;charset=UTF-8","Header content type mismatch.");
    }

}
