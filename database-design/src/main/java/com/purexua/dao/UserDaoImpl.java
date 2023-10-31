package com.purexua.dao;

import com.purexua.entity.User;
import com.purexua.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
  @Autowired
  private UserMapper userMapper;

  public List<User> queryAll() {
    return userMapper.queryAll();
  }

  @Override
  public User queryById(Integer id) {
    return userMapper.queryById(id);
  }

  @Override
  public void addUser(User user) {
    userMapper.insertUser(user);
  }

  @Override
  public void deleteUser(Integer id) {
    userMapper.deleteUserById(id);
  }

  @Override
  public void updateUser(User user) {
    userMapper.updateUser(user);
  }

  @Override
  public String queryPasswordByUsername(String username) {
    return userMapper.queryPasswordByUsername(username);
  }
}
