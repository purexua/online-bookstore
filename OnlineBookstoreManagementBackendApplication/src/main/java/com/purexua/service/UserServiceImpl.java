package com.purexua.service;

import com.purexua.dao.UserDao;
import com.purexua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public User login(String username) {
    System.out.println("用户 " + username + " login");
    return userDao.selectUserByUsername(username);
  }

  @Override
  public String updatePassword(Integer userId, String password) {
    userDao.updateUserPass(userId, password);
    System.out.println("用户 ID " + userId + " update password " + password);
    return "success";
  }

  @Override
  public String updateUser(User user) {
    userDao.updateUser(user);
    System.out.println("用户 ID " + user.getUserId() + " update user " + user);
    return "success";
  }

  @Override
  public String updateUserBalance(Integer userId, Double balance) {
    userDao.updateUserBalance(userId, balance);
    System.out.println("用户 ID " + userId + " update balance + " + balance);
    return "success";
  }

  @Override
  public String updateUserBalanceAfterPay(Integer userId, Double balance) {
    userDao.updateUserBalanceAfterPay(userId, balance);
    System.out.println("用户 ID " + userId + " update balance - " + balance);
    return "success";
  }

  @Override
  public User getUserById(Integer userId) {
    return userDao.getUserById(userId);
  }

  @Override
  public String register(User user) {
    if(userDao.selectUserByUsername(user.getUserName()) != null) {
      return "用户名已存在";
    }else {
      userDao.register(user);
      System.out.println("用户 " + user.getUserName() + " register");
      return "success";
    }
  }
}
