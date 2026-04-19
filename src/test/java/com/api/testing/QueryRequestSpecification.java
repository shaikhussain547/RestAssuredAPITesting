package com.api.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class QueryRequestSpecification {

    @Test
    public void createUser()
    {

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


        //Create request specification
        RequestSpecification reqSpec = RestAssured.given();

        //specify url
        reqSpec.baseUri("https://api.restful-api.dev/objects").
                contentType(ContentType.JSON).
                body(jsonData.toJSONString()).header("header1","header1value");


        //query details from request specification

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);

        //get base URI
        String retrieveBaseURI = queryRequest.getBaseUri();
        System.out.println("Base URI:" + retrieveBaseURI);

        //get request body
        String retrieveRequestBody = queryRequest.getBody();
        System.out.println("Body :" + retrieveRequestBody);

        //get request Headers
        Headers allHeaders = queryRequest.getHeaders();
        System.out.println("\n----------------REQUEST HEADER---------------------\n");
        for(Header h:allHeaders)
        {
            System.out.println("Header name:" + h.getName() + "\tHeader value:" + h.getValue());
        }

    }

    @Test
    public void testCreateUser()
    {

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


        //Create request specification
        RequestSpecification reqSpec = RestAssured.given();

        //specify url
        reqSpec.baseUri("https://api.restful-api.dev/objects").
                contentType(ContentType.JSON).
                body(jsonData.toJSONString()).header("header1","header1value");


        //query details from request specification

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);

        //get base URI
        String retrieveBaseURI = queryRequest.getBaseUri();
        System.out.println("Base URI:" + retrieveBaseURI);

        //get request body
        String retrieveRequestBody = queryRequest.getBody();
        System.out.println("Body :" + retrieveRequestBody);

        //get request Headers
        Headers allHeaders = queryRequest.getHeaders();
        System.out.println("\n----------------REQUEST HEADER---------------------\n");
        for(Header h:allHeaders)
        {
            System.out.println("Header name:" + h.getName() + "\tHeader value:" + h.getValue());
        }

    }
}
