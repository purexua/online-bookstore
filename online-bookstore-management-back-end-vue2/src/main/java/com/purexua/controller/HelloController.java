package com.purexua.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//just for test
@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello() {
    return "Hello,Spring Boot 3!";
  }
}
