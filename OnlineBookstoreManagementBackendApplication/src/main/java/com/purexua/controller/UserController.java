package com.purexua.controller;

import com.purexua.entity.User;
import com.purexua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


  @ResponseBody
  @PutMapping("/user/password")
  public String updatePassword( @RequestParam("userId") Integer userId,@RequestParam("password") String password) {
    return userService.updatePassword(userId,password);
  }

  @ResponseBody
  @PutMapping("/user")
  public String updateUser(User user) {
    return userService.updateUser(user);
  }

  @ResponseBody
  @PutMapping("/user/recharge")
  public String updateUserBalance(@RequestParam("userId") Integer userId, @RequestParam("balance") Double balance) {
    return userService.updateUserBalance(userId, balance);
  }
}
