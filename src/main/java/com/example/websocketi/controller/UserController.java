package com.example.websocketi.controller;

import com.example.websocketi.model.User;
import com.example.websocketi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/User"})
public class UserController {
  @Autowired
  private UserService userService;
  
  @GetMapping({"/all"})
  public List<User> getHalls() {
    return this.userService.getAll();
  }
  
  @PostMapping({"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody User user) {
    return this.userService.save(user);
  }
  
  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int userId) {
    return this.userService.deleteUser(userId);
  }
}
