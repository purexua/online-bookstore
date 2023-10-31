package com.purexua.service;

import com.purexua.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  public User login(String username);
}
