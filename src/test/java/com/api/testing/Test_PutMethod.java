package com.api.testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Test_PutMethod {

    @Test
    public void updateObject(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Apple MacBook Pro 16");
        // Create nested "data" object
        JSONObject data = new JSONObject();
        data.put("year", 2019);
        data.put("price", 2049.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");
        data.put("color", "silver");

        // Attach nested object
        jsonData.put("data", data);

        // Print JSON
        System.out.println(jsonData.toString());

        RestAssured.baseURI="https://api.restful-api.dev/objects/ff8081819d82fab6019d921a688613e7";
		RestAssured.given().
        header("contentType", "application/json").
        contentType(ContentType.JSON).
        body(jsonData.toJSONString()).
        when().put().
        then().statusCode(200).log().all();

    }
    
}
