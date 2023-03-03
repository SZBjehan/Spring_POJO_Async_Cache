package com.example.quantsysdemo.service;

import com.example.quantsysdemo.model.Address;
import com.example.quantsysdemo.model.Person;
import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.example.quantsysdemo.pojo.person.PersonRequest;
import com.example.quantsysdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressService addressService;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, AddressService addressService) {
        this.personRepository = personRepository;
        this.addressService = addressService;
    }

    /**
     * This service is used to get person by id
     * Using Cache for age > 2
     */
    @Cacheable(key = "#id", value = "Person", unless = "#result.age<2")
    public PersonRequest getById(long id) {
        Person person = personRepository.findById(id);
        System.out.print(" --- Triggered findById ---");
        return convertPersonToPojo(person);
    }

    /**
     * This service is used to Serialize the Object of Person
     */
    private PersonRequest convertPersonToPojo(Person person) {

        return new PersonRequest(person.getId(), person.getName(), person.getAge(),
                addressService.convertAddressToPojo(person.getAddress()), person.getBirthDate(), person.getSecurityNumber());
    }

    /**
     * This service returns all person using async
     */
    @Override
    @Async
    public CompletableFuture<List<PersonRequest>> getAll() {
        return CompletableFuture.supplyAsync(() -> {
            List<Person> persons = personRepository.findAll();
            List<PersonRequest> personRequests = new ArrayList<>();
            persons.forEach(person -> {
                personRequests.add(convertPersonToPojo(person));
            });
            return personRequests;
        });
    }

    /**
     * This service is used to deserialize the JSON
     */
    @Override
    public Person save(PersonRequest personRequest) {

        Person person = new Person();
        person.setName(personRequest.getName());
        person.setAge(personRequest.getAge());

        Address address = addressService.save(personRequest.getAddress());
        person.setAddress(address);

        person.setBirthDate(personRequest.getBirthDate());
        person.setSecurityNumber(personRequest.getSecurityNumber());

        personRepository.save(person);

        return person;
    }

    @Override
    @CacheEvict(key = "#id", value = "Person")
    public String deleteById(long id) {
        personRepository.deleteById(id);
        return "Successfully removed "+ id;
    }
}
