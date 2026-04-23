package com.api.testing;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {

    @Test
	public void uploadFile()
	{
		//Create file file object  "C:\Users\hussa\Downloads\Sample.txt"
		File testFileUpload = new File("C:\\Users\\hussa\\Downloads\\Sample.txt");
		File testFileUpload2 = new File("C:\\Users\\hussa\\Downloads\\Sample.txt");

		//create Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify URL
		requestSpec.baseUri("http://httpbin.org/post");
		
		requestSpec.multiPart("files",testFileUpload);
		requestSpec.multiPart("files",testFileUpload2);
		
		requestSpec.contentType("multipart/form-data");
		
		//perform post request
		Response response = requestSpec.post();
		
		//print response body
		response.prettyPrint();
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");
	
	}

}
