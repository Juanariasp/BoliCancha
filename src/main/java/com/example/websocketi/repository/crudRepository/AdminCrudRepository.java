package com.example.websocketi.repository.crudRepository;

import com.example.websocketi.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer> {
  @Query("SELECT c FROM Admin AS c WHERE c.email =:user AND c.password =:password")
  public Admin getUserAdmin(String user, String password);

}