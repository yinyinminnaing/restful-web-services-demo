package com.example.restfulwebservices.post;

import com.example.restfulwebservices.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts {
  private Integer id;
  private String details;


  public Posts(Integer id, String details) {
    this.id = id;
    this.details = details;
  }
}
