package com.example.quantsysdemo.pojo.address;

import com.example.quantsysdemo.model.Address;
import lombok.Data;

@Data
public class AddressResponse {

    private long id;
    private long houseNo;
    private long street;
    private String city;

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.houseNo = address.getHouseNo();
        this.street = address.getStreet();
        this.city = address.getCity();
    }

}

