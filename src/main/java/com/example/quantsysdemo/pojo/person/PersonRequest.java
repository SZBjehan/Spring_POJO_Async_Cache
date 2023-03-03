package com.example.quantsysdemo.pojo.person;

import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(using = PersonRequestSerializer.class)
@JsonDeserialize(using = PersonRequestDeserializer.class)
public class PersonRequest {

    private long id;
    private String name;
    private long age;
    private AddressRequest address;
    private String birthDate;
    private long securityNumber;

    public PersonRequest(){
        super();
    }
    public PersonRequest(long id, String name, long age, AddressRequest address, String birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthDate = birthDate;
    }

    public PersonRequest(long id, String name, long age, AddressRequest address, String birthDate, long securityNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthDate = birthDate;
        this.securityNumber = securityNumber;
    }

}

