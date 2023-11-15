package com.purexua.controller;

import com.purexua.entity.User;
import com.purexua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
  public String updatePassword(@RequestParam("userId") Integer userId, @RequestParam("password") String password) {
    return userService.updatePassword(userId, password);
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

  @ResponseBody
  @PutMapping("/user/pay")
  public String updateUserBalanceAfterPay(@RequestParam("userId") Integer userId, @RequestParam("balance") Double balance) {
    return userService.updateUserBalanceAfterPay(userId, balance);
  }

  @ResponseBody
  @GetMapping("/user/id")
  public User getUserById(@RequestParam("userId") Integer userId) {
    return userService.getUserById(userId);
  }

  @ResponseBody
  @PostMapping("/register")
  public String register(User user) {
    return userService.register(user);
  }
}
