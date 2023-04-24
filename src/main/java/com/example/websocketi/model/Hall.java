package com.example.websocketi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hall")
public class Hall implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idHall;
  
  private Integer idQuestionnaire;
  
  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "hall")
  @JsonIgnoreProperties({"hall"})
  private List<User> users;
  
  @OneToOne
  @JoinColumn(name = "admin_id")
  @JsonIgnoreProperties({"hall"})
  private Admin admin;
  
  @OneToOne
  @JoinColumn(name = "questionnaire_id")
  @JsonIgnoreProperties({"hall"})
  private Questionnaire questionnaire;
  
  public List<User> getUsers() {
    return this.users;
  }
  
  public void setUsers(List<User> users) {
    this.users = users;
  }
  
  public Admin getAdmin() {
    return this.admin;
  }
  
  public void setAdmin(Admin admin) {
    this.admin = admin;
  }
  
  public Questionnaire getQuestionnaire() {
    return this.questionnaire;
  }
  
  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }
  
  public Integer getIdHall() {
    return this.idHall;
  }
  
  public void setIdHall(Integer idHall) {
    this.idHall = idHall;
  }
  
  public Integer getIdQuestionnaire() {
    return this.idQuestionnaire;
  }
  
  public void setIdQuestionnaire(Integer idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }
}
