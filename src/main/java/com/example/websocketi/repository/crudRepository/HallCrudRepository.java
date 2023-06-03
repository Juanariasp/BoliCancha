package com.example.websocketi.repository.crudRepository;

import com.example.websocketi.model.Hall;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HallCrudRepository extends CrudRepository<Hall, Integer> {
    @Query("SELECT h FROM Hall AS h WHERE h.idQuestionnaire =:id")
    public Hall getHall(Integer id);
}
