package com.purexua.controller;

import com.purexua.entity.User;
import com.purexua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @ResponseBody
  @GetMapping("/login")
  public User login(@RequestParam("username") String username) {
    return userService.login(username);
  }

}
