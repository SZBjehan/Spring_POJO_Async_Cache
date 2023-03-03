package com.example.quantsysdemo.repository;

import com.example.quantsysdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public static final String HASH_KEY = "Person";
    Person findById(long id);
}
