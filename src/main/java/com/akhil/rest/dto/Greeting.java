package com.akhil.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Greeting {

    private String id;
    private String content;

    public Greeting(String content) {
        super();
        id = UUID.randomUUID().toString();
        this.content = content;
    }
}