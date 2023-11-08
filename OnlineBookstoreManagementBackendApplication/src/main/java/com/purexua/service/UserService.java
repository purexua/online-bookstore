package com.purexua.service;

import com.purexua.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  User login(String username);

  String updatePassword( Integer userId,String password);

  String updateUser(User user);
}
