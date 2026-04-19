package com.api.testing;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONArrayDemo {

    @Test
    public void jsonArrayUsingJsonObj()  {
        JSONObject user1 = new JSONObject();
        user1.put("firstName","Prachi");
        user1.put("lastName","Gupta");
        user1.put("age",28);
        user1.put("salary",10000.56);

        JSONObject user2 = new JSONObject();
        user2.put("firstName","Prerna");
        user2.put("lastName","Gupta");
        user2.put("age",28);
        user2.put("salary",10000.56);

        JSONObject user3 = new JSONObject();
        user3.put("firstName","Jatin");
        user3.put("lastName","Gupta");
        user3.put("age",28);
        user3.put("salary",10000.56);

        //add JSON Object to JSON Array
        JSONArray UsersPayLoad = new JSONArray();

        UsersPayLoad.add(user1);
        UsersPayLoad.add(user2);
        UsersPayLoad.add(user2);

        System.out.println(UsersPayLoad.toString());

        try {
            // Use Jackson to pretty print the json-simple array
            ObjectMapper mapper = new ObjectMapper();
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(UsersPayLoad);
            System.out.println(prettyJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createJsonArray(){
        // 1. Create the List that will act as the JSON Array
        List<Map<String, Object>> jsonArray = new ArrayList<>();

        // 2. Create the first object (Map)
        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 101);
        user1.put("name", "Alice");
        user1.put("role", "Developer");

        // 3. Create the second object (Map)
        Map<String, Object> user2 = new HashMap<>();
        user2.put("id", 102);
        user2.put("name", "Bob");
        user2.put("role", "Tester");

        // 4. Add the maps to the list
        jsonArray.add(user1);
        jsonArray.add(user2);

        // 5. Serialize to JSON string using Jackson
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);

            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
