package com.purexua.dao;

import com.purexua.entity.User;

public interface UserDao {
  User selectUserByUsername(String username);
  Integer updateUserPass( Integer userId,String password);

  Integer updateUser(User user);
}
