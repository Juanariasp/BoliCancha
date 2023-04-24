package com.example.websocketi.repository;


import com.example.websocketi.model.Admin;
import com.example.websocketi.repository.crudRepository.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
  @Autowired
  private AdminCrudRepository adminCrudRepository;
  
  public List<Admin> getAll() {
    return (List<Admin>)this.adminCrudRepository.findAll();
  }
  
  public Optional<Admin> getAdmin(int id) {
    return this.adminCrudRepository.findById(Integer.valueOf(id));
  }
  
  public Admin save(Admin admin) {
    return (Admin)this.adminCrudRepository.save(admin);
  }
  
  public void delete(Admin admin) {
    this.adminCrudRepository.delete(admin);
  }
  
  public Admin getUser(String admin, String password) {
    return this.adminCrudRepository.getUserAdmin(admin, password);
  }
}
