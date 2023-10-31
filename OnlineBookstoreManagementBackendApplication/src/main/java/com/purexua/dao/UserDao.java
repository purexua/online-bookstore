package com.purexua.dao;

import com.purexua.entity.User;

public interface UserDao {
  User selectUserByUsername(String username);
}
