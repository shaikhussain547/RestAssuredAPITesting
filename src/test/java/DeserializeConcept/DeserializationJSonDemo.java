package DeserializeConcept;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationJSonDemo {

    @Test
    public void createUser(){
        //create Request Specification
        RequestSpecification requestSpec = RestAssured.given();
        //specify URL
        requestSpec.baseUri("https://api.restful-api.dev/objects");

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

        Response response = requestSpec.headers("x-api-key", "3db66f63-bfd0-4a76-80f8-bfa6fc0e28e2")
                .contentType(ContentType.JSON).body(jsonData.toJSONString()).post();


        ResponseBody responseBody = response.getBody();

        //Deserialize responseBody i.e json resoponse body to class object
        //Class<T> is a generic form of any class of type T which is also referred to as template class.

        JSONPostRequestResponse responseClass = responseBody.as(JSONPostRequestResponse.class);

        Assert.assertEquals(responseClass.name, "Apple MacBook Pro 17","check for name.");
        // 3. Validations using the POJO
        Assert.assertNotNull(responseClass.id, "ID should not be null");
        Assert.assertEquals(responseClass.name, "Apple MacBook Pro 17");
        Assert.assertEquals(responseClass.data.cpuModel, "Intel Core i9");

        System.out.println("Object created with ID: " + responseClass.id);

    }

    @Test
    public void testCreateUser() {

        //create Request Specification
        RequestSpecification requestSpec = RestAssured.given();
        //specify URL
        requestSpec.baseUri("https://api.restful-api.dev");

        // 1. Prepare Request Payload
        Data requestData = new Data();
        requestData.year = 2019;
        requestData.price = 1849.99;
        requestData.cpuModel = "Intel Core i9";
        requestData.hardDiskSize = "1 TB";

        JSONPostRequestResponse payload = new JSONPostRequestResponse();
        payload.name = "Apple MacBook Pro 17";
        payload.data = requestData;

        // 2. Send Request and Deserialize Response
        JSONPostRequestResponse response = requestSpec
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/objects")
                .then()
                .statusCode(200)
                .extract()
                .as(JSONPostRequestResponse.class); // Deserialization happens here

        // 3. Validations using the POJO
        Assert.assertNotNull(response.id, "ID should not be null");
        Assert.assertEquals(response.name, "Apple MacBook Pro 17");
        Assert.assertEquals(response.data.cpuModel, "Intel Core i9");

        System.out.println("Object created with ID: " + response.id);
    }

}
