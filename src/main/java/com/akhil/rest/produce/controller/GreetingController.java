package com.akhil.rest.produce.controller;

import com.akhil.rest.dto.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author akhilkanakendran
 * Greetings controller class exposing Rest operations
 */
@RestController
public class GreetingController {
    private static final String templateHello = "Hello, %s!";
    private List<Greeting> greetings = new ArrayList<>(List.of(
            new Greeting("Halla"),
            new Greeting("Hey"),
            new Greeting("Jij")));

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Akhil ! Hello !") String name) {
        return new Greeting(String.format(templateHello, name));
    }

    @GetMapping("/greetings")
    public List<Greeting> greetings(@RequestParam(value = "name", defaultValue = "Akhil ! Hi ! ") String name) {
        return greetings;
    }

    @PostMapping("/greetings")
    public ResponseEntity<String> createGreeting(
            @RequestBody Greeting greeting) {

        // Create greeting with ID;
        String greetingId = UUID.randomUUID().toString();
        greeting.setId(greetingId);
        greetings.add(greeting);

        return ResponseEntity.ok().body(
                "{\"greetingID\":\"" + greetingId + "\"}");
    }
}