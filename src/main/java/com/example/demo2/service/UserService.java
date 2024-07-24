package com.example.demo2.service;
import org.springframework.stereotype.Service;
import com.example.demo2.domain.User;

@Service
public class UserService {

  public User save(User user) {
    return user;
  }

}
