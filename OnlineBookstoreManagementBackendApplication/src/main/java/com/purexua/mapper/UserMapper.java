package com.purexua.mapper;

import com.purexua.entity.User;

public interface UserMapper {
  User selectUserByUsername(String username);
}