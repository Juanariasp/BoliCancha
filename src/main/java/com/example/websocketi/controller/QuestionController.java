package com.example.websocketi.controller;

import com.example.websocketi.model.Question;
import com.example.websocketi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/Question"})
public class QuestionController {
  @Autowired
  private QuestionService questionService;
  
  @GetMapping({"/all"})
  public List<Question> getQuesstion() {
    return this.questionService.getAll();
  }
  
  @PostMapping({"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  @CrossOrigin(origins = "http://localhost:3000")
  public Question save(@RequestBody Question question) {
    return this.questionService.save(question);
  }
  
  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int questionId) {
    return this.questionService.deleteUser(questionId);
  }
}

