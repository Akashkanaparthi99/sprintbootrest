package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GreetController {
    // this is an api
    //htto://localhost:8080/greet
    @RequestMapping("/greet")
    public String greetMessage(){
        String message = "Have a great day";
        // rest api returns the data
        return message;
    }

    //http://localhost:8080/show
//    @RequestMapping(name ="show", method = RequestMethod.GET)
    @GetMapping("/show")
    public List<String> showCourses(){
        return Arrays.asList("Java","Angular","Spring","Node");
    }
}
