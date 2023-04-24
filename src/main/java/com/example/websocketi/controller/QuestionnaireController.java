package com.example.websocketi.controller;

import com.example.websocketi.model.Questionnaire;
import com.example.websocketi.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/Questionnaire"})
public class QuestionnaireController {
  @Autowired
  private QuestionnaireService questionnaireService;
  
  @GetMapping({"/all"})
  public List<Questionnaire> getQuestionnaire() {
    return this.questionnaireService.getAll();
  }
  
  @PostMapping({"/save"})
  @ResponseStatus(HttpStatus.CREATED)
  public Questionnaire save(@RequestBody Questionnaire questionnaire) {
    return this.questionnaireService.save(questionnaire);
  }
  
  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int questionnaireId) {
    return this.questionnaireService.deleteUser(questionnaireId);
  }
}
