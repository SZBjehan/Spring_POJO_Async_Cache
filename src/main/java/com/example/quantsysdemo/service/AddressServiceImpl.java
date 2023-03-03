package com.example.quantsysdemo.service;

import com.example.quantsysdemo.model.Address;
import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.example.quantsysdemo.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(AddressRequest addressRequest) {

        Address address = new Address();
        address.setHouseNo(addressRequest.getHouseNo());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());

        return address;
    }

    /**
     * This service is used to Serialize the Object of Person
     */
    @Override
    public AddressRequest convertAddressToPojo(Address address) {
        return new AddressRequest(address.getHouseNo(), address.getStreet(), address.getCity());
    }

}

