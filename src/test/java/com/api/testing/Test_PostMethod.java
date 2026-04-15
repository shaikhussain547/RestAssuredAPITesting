package com.api.testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Test_PostMethod {

    @Test
    public void createObject(){
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

        RestAssured.baseURI="https://api.restful-api.dev/objects";
		RestAssured.given().
        contentType(ContentType.JSON).
        body(jsonData.toJSONString()).
        when().post().
        then().statusCode(200).log().all();

    }
    
}
