package emp3_POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class EmpNestedJsonResp {

    @Test
    public void createUser() throws JsonProcessingException {

        Employee emp1 = new Employee();
        emp1.setFirstName("Suresh");
        emp1.setLastname("Mehra");
        emp1.setGender("Male");
        emp1.setAge(35);
        emp1.setSalary(10000.56);

        EmployeeAddress emp1Address = new EmployeeAddress();
        emp1Address.setStreet("Park Avenue");
        emp1Address.setCity("vijaywada");
        emp1Address.setState("Andhra Pradesh");
        emp1Address.setPincode(530012);

        emp1.setAddress(emp1Address);

        //convert class object to json object as string
        ObjectMapper objetMapper = new ObjectMapper();

        String josnpayload = objetMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
        System.out.println("jsonpayload : " + josnpayload);
        RequestSpecification reqSpec = RestAssured.given();

        //specify url
        reqSpec.baseUri("http://httpbin.org/post");
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(josnpayload);

        //perform post request
        Response response = reqSpec.post();
        response.prettyPrint();

    }

}
