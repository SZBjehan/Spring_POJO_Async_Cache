package com.example.quantsysdemo.pojo.address;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(using = AddressRequestSerializer.class)
@JsonDeserialize(using = AddressRequestDeserializer.class)
public class AddressRequest {

    private long houseNo;
    private long street;
    private String city;
    public AddressRequest() {
        super();
    }

    public AddressRequest(long houseNo, long street, String city) {
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
    }
}
