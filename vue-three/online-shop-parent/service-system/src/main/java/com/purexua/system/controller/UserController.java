package com.purexua.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.purexua.model.system.User;
import com.purexua.result.R;
import com.purexua.system.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  // 登录 - 根据用户名和密码查询用户
  @GetMapping("/login")
  public R<String> login(@RequestParam String userName, @RequestParam String password) {
    //根据userName 查询单个用户
    LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(User::getUserName, userName).last("limit 1");
    User user = userService.getOne(wrapper);
    if (user == null) {
      return R.fail("fail - user not exists");
    } else {
      if (user.getPassword().equals(password)) {
        return R.ok("success");
      } else {
        return R.fail("fail - wrong password");
      }
    }
  }

  // 注册 - 根据用户名和密码注册用户
  @PostMapping("/register")
  public R<String> register(@RequestBody User user) {
    if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, user.getUserName())) != null) {
      return R.fail("fail - user already exists");
    } else {
      userService.save(user);
      return R.ok("success");
    }
  }

  // 获取用户信息 - 根据用户名获取用户信息
  @GetMapping("/user/{userName}")
  public R<User> getUser(@PathVariable String userName) {
    return R.ok(userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName)));
  }
}
