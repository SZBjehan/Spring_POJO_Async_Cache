package com.example.quantsysdemo.model;

import javax.persistence.*;

import com.example.quantsysdemo.pojo.address.AddressRequest;
import lombok.Data;

@Entity
@Data
@Table(name="Person")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private long age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String birthDate;

    private long securityNumber;
}
