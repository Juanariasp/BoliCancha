package com.example.websocketi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idUser;
  
  private String name;
  
  private Integer score;
  
  @ManyToOne
  @JoinColumn(name = "hallId")
  @JsonIgnoreProperties({"users", "admin", "questionnaire"})
  private Hall hall;
  
  public Hall getHall() {
    return this.hall;
  }
  
  public void setHall(Hall hall) {
    this.hall = hall;
  }
  
  public Integer getIdUser() {
    return this.idUser;
  }
  
  public void setIdUser(Integer idUser) {
    this.idUser = idUser;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Integer getScore() {
    return this.score;
  }
  
  public void setScore(Integer score) {
    this.score = score;
  }
}

