package com.example.SpringBoot_RestApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //HTTP Get Request
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
