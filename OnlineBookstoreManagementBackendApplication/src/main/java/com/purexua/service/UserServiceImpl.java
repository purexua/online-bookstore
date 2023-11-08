package com.purexua.service;

import com.purexua.dao.UserDao;
import com.purexua.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserDao userDao;

  @Override
  public User login(String username) {
    return userDao.selectUserByUsername(username);
  }

  @Override
  public String updatePassword(Integer userId, String password) {
    userDao.updateUserPass(userId,password);
    System.out.println("用户 ID "+userId+" update password "+password);
    return "success";
  }

  @Override
  public String updateUser(User user) {
    userDao.updateUser(user);
    System.out.println("用户 ID "+user.getUserId()+" update user "+user);
    return "success";
  }
}
