package com.example.websocketi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "questionnaire")
public class Questionnaire implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idQuestionnaire;
  
  private String name;
  
  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "questionnaire")
  @JsonIgnoreProperties({"questionnaire"})
  private List<Question> questions;
  
  @ManyToOne
  @JoinColumn(name = "adminId")
  @JsonIgnoreProperties({"questionnaires"})
  private Admin admin;
  
  @OneToOne(mappedBy = "questionnaire")
  @JsonIgnoreProperties({"questionnaire", "users", "admin"})
  private Hall hall;
  
  public Hall getHall() {
    return this.hall;
  }
  
  public void setHall(Hall hall) {
    this.hall = hall;
  }
  
  public Integer getIdQuestionnaire() {
    return this.idQuestionnaire;
  }
  
  public void setIdQuestionnaire(Integer idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public List<Question> getQuestions() {
    return this.questions;
  }
  
  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
  
  public Admin getAdmin() {
    return this.admin;
  }
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
}
