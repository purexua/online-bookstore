package com.purexua.service;

import com.purexua.dao.UserDao;
import com.purexua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  public User login(String username) {
    return userDao.selectUserByUsername(username);
  }
}
