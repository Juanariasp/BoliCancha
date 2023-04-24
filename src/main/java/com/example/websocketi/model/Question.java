package com.example.websocketi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "question")
public class Question implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idQuestion;
  
  private String question;
  
  private String category;
  
  private String correctAnswer;
  
  private ArrayList<String> incorrectAnswers = new ArrayList<>();
  
  @ManyToOne
  @JoinColumn(name = "questionnaireId")
  @JsonIgnoreProperties({"questions", "admin"})
  private Questionnaire questionnaire;
  
  public Integer getIdQuestion() {
    return this.idQuestion;
  }
  
  public void setIdQuestion(Integer idQuestion) {
    this.idQuestion = idQuestion;
  }
  
  public String getQuestion() {
    return this.question;
  }
  
  public Questionnaire getQuestionnaire() {
    return this.questionnaire;
  }
  
  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
  
  public void setQuestion(String question) {
    this.question = question;
  }
  
  public String getCategory() {
    return this.category;
  }
  
  public void setCategory(String category) {
    this.category = category;
  }
  
  public String getCorrectAnswer() {
    return this.correctAnswer;
  }
  
  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }
  
  public ArrayList<String> getIncorrectAnswers() {
    return this.incorrectAnswers;
  }
  
  public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
  }
}

