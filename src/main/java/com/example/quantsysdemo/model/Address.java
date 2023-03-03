package com.example.quantsysdemo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    private long houseNo;

    private long street;

    private String city;
}
