package com.purexua.dao;

import com.purexua.entity.User;
import com.purexua.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
 private UserMapper userMapper;

  @Override
  public User selectUserByUsername(String username) {
    return userMapper.selectUserByUsername(username);
  }
}