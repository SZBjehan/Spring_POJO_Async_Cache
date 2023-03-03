package com.example.quantsysdemo.service;

import com.example.quantsysdemo.model.Person;
import com.example.quantsysdemo.pojo.person.PersonRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface PersonService {

    PersonRequest getById(long id);

    CompletableFuture<List<PersonRequest>> getAll();
    Person save(PersonRequest personRequest);
    String deleteById(long id);
}

