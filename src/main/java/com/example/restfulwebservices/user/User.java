package com.example.restfulwebservices.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private Integer id;
    private String name;
    private Date dateOfBirth;

    public User(Integer id,String name,Date dateOfBirth){
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
    }
}
