package JsonIgnoreUnknownProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class DemoIgnoreProperties {

    @Test
    public void test1() throws JsonMappingException, JsonProcessingException {

        String payload = "{\n" +
                "  \"firstname\" : \"Suresh\",\n" +
                "  \"lastname\" : \"Mehra\",\n" +
                "  \"gender\" : \"Male\",\n" +
                "  \"age\" : 35,\n" +
                "  \"salary\" : 10000.0,\n" +
                "  \"married\" : true,\n" +
                "  \"fullName\" : \"Suresh Mehra\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

        //Configuration to ignore unknown properties of POJO class
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //convert JSON String (employeeJSON) to Class object (Employee)
        Employee emp2 = objectMapper.readValue(payload, Employee.class);

        System.out.println("-----------Print after JSON Object to Class Object------------");
        System.out.println("FirstName:"+ emp2.getFirstname());
        System.out.println("LastName:"+ emp2.getLastname());
        System.out.println("Gender:"+ emp2.getGender());
        System.out.println("Age:"+ emp2.getAge());
        System.out.println("Salary:"+ emp2.getSalary());
        System.out.println("Is Married:"+ emp2.isMarried());

    }

}
