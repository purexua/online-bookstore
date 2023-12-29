package com.purexua.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.purexua.pojo.User;
import com.purexua.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String login(@RequestParam String userName, @RequestParam String password) {
    //根据userName 查询单个用户
    LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(User::getUserName, userName).last("limit 1");
    User user = userService.getOne(wrapper);
    if (user == null) {
      return "fail - user not exists";
    } else {
      if (user.getPassword().equals(password)) {
        return "success";
      } else {
        return "fail - password error";
      }
    }
  }

  @PostMapping("/register")
  public String register(@RequestBody User user) {
    if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, user.getUserName())) != null) {
      return "fail - user already exists";
    } else {
      userService.save(user);
      System.out.println("### 用户注册成功 - " + user);
      return "success";
    }
  }

  @GetMapping("/user/{userName}")
  public User getUser(@PathVariable String userName) {
    System.out.printf("### 获取用户信息 - %s\n", userName);
    return userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName));
  }
}
