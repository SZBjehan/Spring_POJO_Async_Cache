package com.example.quantsysdemo.pojo.person;

import com.example.quantsysdemo.model.Person;
import com.example.quantsysdemo.pojo.address.AddressResponse;
import lombok.Data;

@Data
public class PersonResponse {

    private long id;

    private String name;

    private long age;

    private AddressResponse address;

    private String birthDate;

    private long securityNumber;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.address = new AddressResponse(person.getAddress());
        this.birthDate = person.getBirthDate();
        this.securityNumber = person.getSecurityNumber();
    }
}

