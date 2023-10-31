package com.purexua.controller;

import com.purexua.entity.User;
import com.purexua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping(value = "/users")
  @ResponseBody
  public List<User> queryAll() {
    return userService.queryAll();
  }

  @GetMapping(value = "/user")
  @ResponseBody
  public User queryById(@RequestParam(value = "id") Integer id) {
  return userService.queryById(id);
  }

  @PostMapping(value = "/user")
  public String addUser(@RequestBody User user) {
    userService.addUser(user);
    return "redirect:/success.html";
  }

  @DeleteMapping(value = "/user/{id}")
  public String deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
    return "redirect:/success.html";
  }

  @PutMapping(value = "/user")
  public String updateUser(@RequestBody User user) {
    userService.updateUser(user);
    return "redirect:/success.html";
  }

  @GetMapping(value = "/user/password")
  @ResponseBody
  public String queryPasswordByUsername(@RequestParam(value = "username") String username) {
    return userService.queryPasswordByUsername(username);
  }
}
