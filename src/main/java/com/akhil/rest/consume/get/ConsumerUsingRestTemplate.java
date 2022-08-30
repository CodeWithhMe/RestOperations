package com.akhil.rest.consume.get;

import com.akhil.rest.dto.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author akhilkanakendran
 * Consume the Rest operations using Rest Template
 */
public class ConsumerUsingRestTemplate {
    private final String resourceUrlGreeting
            = "http://localhost:8080/greeting";
    private final String resourceUrlGreetings
            = "http://localhost:8080/greetings";

    public void getProductAsJson() {
        RestTemplate restTemplate = new RestTemplate();
        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> responseAsJson
                = restTemplate.getForEntity(resourceUrlGreeting, String.class);

        String productsJson = responseAsJson.getBody();

        System.out.println("Response as JSON : " + productsJson);
    }

    public void getProductAsList() {
        RestTemplate restTemplate = new RestTemplate();
        // Fetch response as List wrapped in ResponseEntity
        ResponseEntity<List> responseAsList
                = restTemplate.getForEntity(resourceUrlGreetings, List.class);

        List<Greeting> greetings = responseAsList.getBody();

        System.out.println("Response as List : " + greetings);
    }

    public void getProductAsObject() {
        // Fetching response as Object
        RestTemplate restTemplate = new RestTemplate();
        List<?> greetingsResponseAsObject
                = restTemplate.getForObject(resourceUrlGreetings, List.class);

        System.out.println("Response as Object " + greetingsResponseAsObject);
    }

    public void createProduct() {
        RestTemplate restTemplate = new RestTemplate();

        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Greeting> request = new HttpEntity<Greeting>(
                new Greeting("Hello man !!"));

        // Send the request body in HttpEntity for HTTP POST request
        String greetingCreateResponse = restTemplate
                .postForObject(resourceUrlGreetings, request, String.class);

        System.out.println(greetingCreateResponse);
    }

    public void consumeUsingRestTemplate() {
        getProductAsJson();
        getProductAsList();
        getProductAsObject();
        createProduct();
    }
}
