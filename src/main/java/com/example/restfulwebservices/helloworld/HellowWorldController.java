package com.example.restfulwebservices.helloworld;

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
    public long showPathVariable(@PathVariable("id")long param){
        return param;
    }

    //set path variable's required=false
    @GetMapping( value = {"/hello-world/test/{name}","/hello-world/test"})
    public HelloWorldBean helloWorldBeanPathVarReqFalse(@PathVariable(required = false) String name){
        if(name !=null){
            return new HelloWorldBean(String.format("Hello World,%s", name));
        }else{
            return new HelloWorldBean("There is no Path Var");
        }

    }


}
