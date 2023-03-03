package com.example.quantsysdemo.pojo.address;

import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AddressRequestSerializer extends JsonSerializer<AddressRequest> {

    @Override
    public void serialize(AddressRequest address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("houseNo", address.getHouseNo());
        jsonGenerator.writeNumberField("street", address.getStreet());
        jsonGenerator.writeStringField("city", address.getCity());
        jsonGenerator.writeEndObject();
    }
}

