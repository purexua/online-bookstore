package com.purexua.mapper;

import com.purexua.entity.User;

import java.util.List;

public interface UserMapper {
  List<User> queryAll();
  User queryById(Integer id);
  void insertUser(User user);
  void deleteUserById(Integer id);
  void updateUser(User user);
}
