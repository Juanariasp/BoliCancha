package com.example.websocketi.service;


import com.example.websocketi.model.Questionnaire;
import com.example.websocketi.repository.QuestionnaireRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public List<Questionnaire> getAll() {
        return this.questionnaireRepository.getAll();
    }

    public Optional<Questionnaire> getQuestionnaire(int questionnaireId) {
        return this.questionnaireRepository.getQuestionnaire(questionnaireId);
    }

    public Questionnaire save(Questionnaire user) {
        if (user.getIdQuestionnaire() == null)
            return this.questionnaireRepository.save(user);
        Optional<Questionnaire> e = this.questionnaireRepository.getQuestionnaire(user.getIdQuestionnaire().intValue());
        if (!e.isPresent())
            return this.questionnaireRepository.save(user);
        return user;
    }

    public boolean deleteUser(int questionnaireId) {
        Boolean aBoolean = getQuestionnaire(questionnaireId).<Boolean>map(user -> {
            this.questionnaireRepository.delete(user);
            return Boolean.valueOf(true);
        }).orElse(Boolean.valueOf(false));
        return aBoolean.booleanValue();
    }
}

