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

  @Override
  public Integer updateUserPass(Integer userId, String password) {
    return userMapper.updateUserPass(userId, password);
  }

  @Override
  public Integer updateUser(User user) {
    return userMapper.updateUser(user);
  }

  @Override
  public Integer updateUserBalance(Integer userId, Double balance) {
    return userMapper.updateUserBalance(userId, balance);
  }
}
