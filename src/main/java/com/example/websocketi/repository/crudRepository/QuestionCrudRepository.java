package com.example.websocketi.repository.crudRepository;


import com.example.websocketi.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionCrudRepository extends CrudRepository<Question, Integer> {}
