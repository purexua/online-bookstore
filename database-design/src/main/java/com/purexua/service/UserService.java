package com.purexua.service;

import com.purexua.entity.User;

import java.util.List;

public interface UserService {

  List<User> queryAll();
  User queryById(Integer id);

  void addUser(User user);

  void deleteUser(Integer id);

  void updateUser(User user);

  String queryPasswordByUsername(String username);
}
