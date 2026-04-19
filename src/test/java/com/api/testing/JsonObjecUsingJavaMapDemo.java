package com.api.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonObjecUsingJavaMapDemo {

    @Test
    public void createAuthToken(){

        /*{
            "username" : "admin",
            "password" : "password123"
        }*/

        Map<String, String> authToken = new HashMap<>();
        authToken.put("username", "admin");
        authToken.put("password", "password123");

        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(authToken)  // RestAssured serializes the Map automatically
                .post();

        response.prettyPrint();

        //verify status code
        Assert.assertEquals(response.statusCode(), 200,"check for status code.");
    }

    @Test
    public void creaetJson(){
        try {
            // 1. Create the outer Map
            Map<String, Object> jsonBody = new HashMap<>();
            jsonBody.put("firstName", "Amod");
            jsonBody.put("lastName", "Mahajan");
            jsonBody.put("age", 28);
            jsonBody.put("salary", 10000.56);
            jsonBody.put("IsMarried", true);

            // 2. Create the Hobbies List
            List<String> hobbies = new ArrayList<>();
            hobbies.add("Music");
            hobbies.add("Computer");
            hobbies.add("Games");
            jsonBody.put("Hobbies", hobbies);

            // 3. Create the Nested TechSkill Map
            Map<String, String> techSkills = new HashMap<>();
            techSkills.put("Programming language", "Java");
            techSkills.put("WebAutomation", "Selenium");
            techSkills.put("API testing", "Rest Assured");
            jsonBody.put("TechSkill", techSkills);

            // 4. Convert Map to JSON String using Jackson ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // writeValueAsString converts the Map into a valid JSON String
            // writerWithDefaultPrettyPrinter() makes it formatted (indented)
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonBody);

            // 5. Print the JSON
            System.out.println(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
