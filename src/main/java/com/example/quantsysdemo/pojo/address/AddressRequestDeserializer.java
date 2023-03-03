package com.example.quantsysdemo.pojo.address;

import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;


public class AddressRequestDeserializer extends JsonDeserializer<AddressRequest> {

    @Override
    public AddressRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        long houseNo = node.get("houseNo").asLong();
        long street = node.get("street").asLong();
        String city = node.get("city").asText();

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setHouseNo(houseNo);
        addressRequest.setStreet(street);
        addressRequest.setCity(city);

        return addressRequest;
    }
}

