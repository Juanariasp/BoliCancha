package com.example.websocketi.repository;

import com.example.websocketi.model.Question;
import com.example.websocketi.repository.crudRepository.QuestionCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {
    @Autowired
    private QuestionCrudRepository questionCrudRepository;

    public List<Question> getAll() {
        return (List<Question>)this.questionCrudRepository.findAll();
    }

    public Optional<Question> getQuestion(int id) {
        return this.questionCrudRepository.findById(Integer.valueOf(id));
    }

    public Question save(Question question) {
        return (Question)this.questionCrudRepository.save(question);
    }

    public void delete(Question question) {
        this.questionCrudRepository.delete(question);
    }
}
