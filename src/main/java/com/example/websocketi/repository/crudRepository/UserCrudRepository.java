package com.example.websocketi.repository.crudRepository;

import com.example.websocketi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {}
