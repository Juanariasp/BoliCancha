package com.example.websocketi.controller;

import com.example.websocketi.model.Hall;
import com.example.websocketi.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/Hall"})
public class HallController {
  @Autowired
  private HallService hallService;
  
  @GetMapping({"/all"})
  public List<Hall> getHalls() {
    return this.hallService.getAll();
  }
  
  @PostMapping({"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  public Hall save(@RequestBody Hall hall) {
    return this.hallService.save(hall);
  }
  
  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int hallId) {
    return this.hallService.deleteUser(hallId);
  }
}

