package com.api.testing;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Test_PatchMethod {

    @Test
    public void updateObject(){
        JSONObject jsonData = new JSONObject();
        jsonData.put("name", "Apple MacBook Pro 16 (Updated Name)");

        // Print JSON
        System.out.println(jsonData.toString());

        RestAssured.baseURI="https://api.restful-api.dev/objects/ff8081819d82fab6019d921a688613e7";
		RestAssured.given().
        header("contentType", "application/json").
        contentType(ContentType.JSON).
        body(jsonData.toJSONString()).
        when().patch().
        then().statusCode(200).log().all();

    }
    
}
