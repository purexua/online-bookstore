package com.purexua.dao;

import com.purexua.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
  public List<User> queryAll();

  public User queryById(Integer id);

  void addUser(User user);

  void deleteUser(Integer id);

  void updateUser(User user);
}
