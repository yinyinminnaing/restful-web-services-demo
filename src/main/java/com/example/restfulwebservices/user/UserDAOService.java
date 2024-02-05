package com.example.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> userList= new ArrayList<>();
    private static Integer userCount=3;

    static {
        userList.add(new User(1, "AA",new Date()));
        userList.add(new User(2, "BB",new Date()));
        userList.add(new User(3, "CC",new Date()));
    }

    //find all users
    public List<User> findAllUsers(){
        return userList;
    }
    //save users
    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        userList.add(user);
        return user;

    }
     //find one
    public User findOne(Integer id){
       for (User user:userList){
           if(id.equals(user.getId())){
               return user;
           }
       }
       return null;
    }
}
