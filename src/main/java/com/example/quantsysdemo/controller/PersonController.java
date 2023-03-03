package com.example.quantsysdemo.controller;

import com.example.quantsysdemo.model.Address;
import com.example.quantsysdemo.model.Person;
import com.example.quantsysdemo.pojo.person.PersonRequest;
import com.example.quantsysdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

//    @GetMapping(path = "/getAll")
//    public ResponseEntity<?> getAllPerson(){
//        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
//    }

//    @GetMapping(path = "/getAll")
//    public DeferredResult<ResponseEntity<?>> getAllPerson() {
//        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
//
//        CompletableFuture.supplyAsync(personService::getAll)
//                .whenCompleteAsync((result, throwable) -> {
//                    if (throwable != null) {
//                        deferredResult.setErrorResult(new ResponseEntity<>(throwable.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
//                    } else {
//                        deferredResult.setResult(new ResponseEntity<>(result, HttpStatus.OK));
//                    }
//                });
//
//        return deferredResult;
//    }

    /**
     * This is a get function which takes in id and return information of that id
     * The Path should be : localhost:8080/person/{id}
     */
    @GetMapping(path = "/{id}")
    public PersonRequest getPerson(@PathVariable int id){
        return personService.getById(id);
    }

    /**
     * This is a get function which returns all the information of an id
     * The Path should be : localhost:8080/person/getAll
     */
//    @GetMapping("/getAll")
//    public ResponseEntity<List<PersonRequest>> getAllPerson() {
//        List<PersonRequest> personRequests = personService.getAll();
//        return new ResponseEntity<>(personRequests, HttpStatus.OK);
//    }
    @GetMapping(path = "/getAll")
    public CompletableFuture<ResponseEntity<?>> getAllPerson() {
        return personService.getAll().thenApply(personResponses -> new ResponseEntity<>(personResponses, HttpStatus.OK));
    }

    /**
     * This is a post function which can save a information of news person
     * The Path should be : localhost:8080/person/add
     */
    @PostMapping(path = "/add")
    public ResponseEntity<?> addPerson(@RequestBody PersonRequest personRequest){
        return new ResponseEntity<>(personService.save(personRequest), HttpStatus.OK);
    }

    /**
     * This is a delete function which deletes a person by id
     * The Path should be : localhost:8080/person/{id}
     */
    @DeleteMapping(path = "/delete")
    public String deletePerson(@RequestParam int id){
        return personService.deleteById(id);
    }
}
