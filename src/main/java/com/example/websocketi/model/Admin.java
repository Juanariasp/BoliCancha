package com.example.websocketi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAdmin;
  
  private String name;
  
  private String email;
  
  private String usuario;
  
  private String password;
  
  private ArrayList<Integer> idAmigos = new ArrayList<>();
  
  @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "admin")
  @JsonIgnoreProperties({"admin", "questions", "hall"})
  private List<Questionnaire> questionnaires;
  
  @OneToOne(mappedBy = "admin")
  @JsonIgnoreProperties({"admin", "users", "questionnaire"})
  private Hall hall;
  
  public Integer getIdAdmin() {
    return this.idAdmin;
  }
  
  public void setIdAdmin(Integer idAdmin) {
    this.idAdmin = idAdmin;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getUsuario() {
    return this.usuario;
  }
  
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  
  public Hall getHall() {
    return this.hall;
  }
  
  public void setHall(Hall hall) {
    this.hall = hall;
  }
  
  public ArrayList<Integer> getIdAmigos() {
    return this.idAmigos;
  }
  
  public void setIdAmigos(ArrayList<Integer> idAmigos) {
    this.idAmigos = idAmigos;
  }
  
  public List<Questionnaire> getQuestionnaires() {
    return this.questionnaires;
  }
  
  public void setQuestionnaires(List<Questionnaire> questionnaires) {
    this.questionnaires = questionnaires;
  }
}
