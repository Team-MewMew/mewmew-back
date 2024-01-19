package com.mewmew.mewmewback.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

  @GetMapping("/")
  public String test() {
    return "Hello World";
  }
}
