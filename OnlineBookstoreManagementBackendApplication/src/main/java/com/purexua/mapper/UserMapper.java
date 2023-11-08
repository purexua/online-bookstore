package com.purexua.mapper;

import com.purexua.entity.User;

public interface UserMapper {
  User selectUserByUsername(String username);
  Integer updateUserPass(Integer userId, String password);

  Integer updateUser(User user);
}
