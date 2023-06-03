package com.example.websocketi.repository;

import com.example.websocketi.model.Hall;
import com.example.websocketi.repository.crudRepository.HallCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HallRepository {
  @Autowired
  private HallCrudRepository hallCrudRepository;

  public List<Hall> getAll() {
    return (List<Hall>)this.hallCrudRepository.findAll();
  }
  
  public Hall getHall(int id) {
    return this.hallCrudRepository.getHall(Integer.valueOf(id));
  }

  public Optional<Hall> getHallId(int id) {
    return this.hallCrudRepository.findById(Integer.valueOf(id));
  }
  
  public Hall save(Hall hall) {
    return (Hall)this.hallCrudRepository.save(hall);
  }
  
  public void delete(Hall hall) {
    this.hallCrudRepository.delete(hall);
  }
}

