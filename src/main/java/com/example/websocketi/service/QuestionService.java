package com.example.websocketi.service;


import com.example.websocketi.model.Question;

import java.util.List;
import java.util.Optional;

import com.example.websocketi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
  @Autowired
  private QuestionRepository questionRepository;
  
  public List<Question> getAll() {
    return this.questionRepository.getAll();
  }
  
  public Optional<Question> getQuestion(int questionId) {
    return this.questionRepository.getQuestion(questionId);
  }
  
  public Question save(Question user) {
    if (user.getIdQuestion() == null)
      return this.questionRepository.save(user); 
    Optional<Question> e = this.questionRepository.getQuestion(user.getIdQuestion().intValue());
    if (!e.isPresent())
      return this.questionRepository.save(user); 
    return user;
  }
  
  public boolean deleteUser(int questionId) {
    Boolean aBoolean = getQuestion(questionId).<Boolean>map(user -> {
          this.questionRepository.delete(user);
          return Boolean.valueOf(true);
        }).orElse(Boolean.valueOf(false));
    return aBoolean.booleanValue();
  }
}
