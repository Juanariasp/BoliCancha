package com.example.websocketi.service;


import com.example.websocketi.model.Hall;
import com.example.websocketi.repository.HallRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService {
  @Autowired
  private HallRepository hallRepository;
  
  public List<Hall> getAll() {
    return this.hallRepository.getAll();
  }
  
  public Optional<Hall> getHall(int hallId) {
    return this.hallRepository.getHall(hallId);
  }
  
  public Hall save(Hall user) {
    if (user.getIdHall() == null)
      return this.hallRepository.save(user); 
    Optional<Hall> e = this.hallRepository.getHall(user.getIdHall().intValue());
    if (!e.isPresent())
      return this.hallRepository.save(user); 
    return user;
  }
  
  public boolean deleteUser(int hallId) {
    Boolean aBoolean = getHall(hallId).<Boolean>map(user -> {
          this.hallRepository.delete(user);
          return Boolean.valueOf(true);
        }).orElse(Boolean.valueOf(false));
    return aBoolean.booleanValue();
  }
}
