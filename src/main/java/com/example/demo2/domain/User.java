package com.example.demo2.domain;

import java.util.List;

public class User {
  private Integer id;
  private String name;
  private String email;
  private String password;
  private List<String> hobbyList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<String> getHobbyList() {
    return hobbyList;
  }

  public void setHobbyList(List<String> hobbyList) {
    this.hobbyList = hobbyList;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", hobbyList="
        + hobbyList + "]";
  }

}
