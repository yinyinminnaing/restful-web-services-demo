package com.example.restfulwebservices.user;

import com.example.restfulwebservices.post.Posts;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Integer id;
    @Size(min = 2,message = "Name must contain at least 2 Chars")
    private String name;
    @Past
    private Date dateOfBirth;
    private Posts posts;


    public User(Integer id,String name,Date dateOfBirth){
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }
}
