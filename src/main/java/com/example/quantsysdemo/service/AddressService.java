package com.example.quantsysdemo.service;

import com.example.quantsysdemo.model.Address;
import com.example.quantsysdemo.pojo.address.AddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address save(AddressRequest addressRequest);

    AddressRequest convertAddressToPojo(Address address);
}


