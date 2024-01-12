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
  public R<Object> login(@RequestParam String email, @RequestParam String password) {
    //根据userName 查询单个用户
    LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(User::getEmail, email).last("limit 1");
    User user = userService.getOne(wrapper);
    if (user == null) {
      return R.fail("fail - user not exists");
    } else {
      if (user.getPassword().equals(password)) {
        return R.ok(user.getId());
      } else {
        return R.fail("fail - wrong password");
      }
    }
  }

  // 注册 - 根据用户名和密码注册用户
  @PostMapping("/register")
  public R<String> register(@RequestBody User user) {
    if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, user.getEmail())) != null) {
      return R.fail("fail - user already exists");
    } else {
      userService.save(user);
      return R.ok("success");
    }
  }

  // 获取用户信息 - 根据用户名获取用户信息
  @GetMapping("/user/{id}")
  public R<User> getUser(@PathVariable String id) {
    return R.ok(userService.getOne(new LambdaQueryWrapper<User>().eq(User::getId, id)));
  }
}
