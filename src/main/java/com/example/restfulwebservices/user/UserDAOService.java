package com.example.restfulwebservices.user;

import com.example.restfulwebservices.post.Posts;
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

        Posts postOne=new Posts(1,"aaaaaaaaaaaaa");
        Posts postTwo=new Posts(2,"aaaaaaaaaaaaa");
        Posts post3=new Posts(3,"ccccccccccccc");
        Posts post4=new Posts(3,"eeeeeeeeeeeee");
        userList.get(0).setPosts(postOne);
        userList.get(1).setPosts(postTwo);
       // userList.get(2).setPosts(post3);
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
    //retrieve all posts for a user
    public Posts findAllPostsForAUser(Integer userId){
        for(User user:userList){
            if(userId.equals(user.getId())){
                return user.getPosts();
            }
        }
        return  null;
    }

    //create a posts for a user
    public Posts createAPostForAUser(Integer userId,Posts posts){
        User selectedUser=findOne(userId);
        Integer id=selectedUser.getId();
        posts.setId(++id);
        selectedUser.setPosts(new Posts(posts.getId(), posts.getDetails()));
        return posts;
    }
    //retrieve details of a post
    public String getDetailsOfaPost(Integer userId,Integer post_id){
        User selectedUser=findOne(userId);
        Posts posts=selectedUser.getPosts();
        return posts.getDetails();

    }
}
