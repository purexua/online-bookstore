package com.purexua.service;

import com.purexua.dao.UserDao;
import com.purexua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao userDao;

  public List<User> queryAll() {
    return userDao.queryAll();
  }

  public User queryById(Integer id) {
    User user = userDao.queryById(id);
    return user;
  }

  @Override
  public void addUser(User user) {
    userDao.addUser(user);
  }

  @Override
  public void deleteUser(Integer id) {
    userDao.deleteUser(id);
  }

  @Override
  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  public String queryPasswordByUsername(String username) {
    return userDao.queryPasswordByUsername(username);
  }
}
