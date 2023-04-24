package com.example.websocketi.repository;
import com.example.websocketi.model.Questionnaire;

import java.util.List;
import java.util.Optional;

import com.example.websocketi.repository.crudRepository.QuestionnaireCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionnaireRepository {
  @Autowired
  private QuestionnaireCrudRepository questionnaireCrudRepository;
  
  public List<Questionnaire> getAll() {
    return (List<Questionnaire>)this.questionnaireCrudRepository.findAll();
  }
  
  public Optional<Questionnaire> getQuestionnaire(int id) {
    return this.questionnaireCrudRepository.findById(Integer.valueOf(id));
  }
  
  public Questionnaire save(Questionnaire questionnaire) {
    return (Questionnaire)this.questionnaireCrudRepository.save(questionnaire);
  }
  
  public void delete(Questionnaire questionnaire) {
    this.questionnaireCrudRepository.delete(questionnaire);
  }
}
