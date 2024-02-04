package com.example.restfulwebservices;

import org.springframework.web.bind.annotation.*;

@RestController
public class HellowWorldController {

    //Get
    //URI - /hello-world
    //method - "Hello World"
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World Bean");
    }

    // /hello-world/path-variable/{name}
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World,%s", name));
    }

    @GetMapping("/hellow-world/testPathVar/{id}")
    public long showPathVariable(@PathVariable long id){
        return id;
    }

}
