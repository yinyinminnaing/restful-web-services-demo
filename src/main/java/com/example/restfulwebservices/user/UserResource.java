package com.example.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService userDAOService;
    //retrieve all users
    @GetMapping("/users")
    public List<User> getUsers(){
       return userDAOService.findAllUsers();
    }

    //retrieve user by id
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        User user= userDAOService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("User Not Found");
        }else{
            return user;
        }
    }
    //save user
    @PostMapping("/user")
    public ResponseEntity saveUser(@RequestBody User user){
        User savedUser=userDAOService.saveUser(user);
        //return correct HTTP response code and URI
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
      //  ResponseEntity.created(uri).build()
        //   ResponseEntity.status(HttpStatus.CREATED).body(uri);
//        ResponseEntity<String> response = ResponseEntity
//                .status(HttpStatus.CREATED)
//                .header("Custom-Header", uri.toString())
//                .body("Response Body");
        return ResponseEntity.created(uri).build();
    }

}
