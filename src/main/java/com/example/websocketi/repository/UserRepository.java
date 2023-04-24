package com.example.websocketi.repository;

import com.example.websocketi.model.User;
import com.example.websocketi.repository.crudRepository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
  @Autowired
  private UserCrudRepository userCrudRepository;
  
  public List<User> getAll() {
    return (List<User>)this.userCrudRepository.findAll();
  }
  
  public Optional<User> getUser(int id) {
    return this.userCrudRepository.findById(Integer.valueOf(id));
  }
  
  public User save(User user) {
    return (User)this.userCrudRepository.save(user);
  }
  
  public void delete(User user) {
    this.userCrudRepository.delete(user);
  }
}
