package com.example.quantsysdemo.pojo.person;


import com.example.quantsysdemo.pojo.address.AddressRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class PersonRequestDeserializer extends JsonDeserializer<PersonRequest> {

    @Override
    public PersonRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        String name = node.get("name").asText();
        long age = node.get("age").asLong();
        String birthDate = node.get("birthDate").asText();
        long securityNumber = node.get("securityNumber").asLong();

        JsonNode addressNode = node.get("address");
        AddressRequest address = codec.treeToValue(addressNode, AddressRequest.class);

        PersonRequest personRequest = new PersonRequest();
        personRequest.setName(name);
        personRequest.setAge(age);
        personRequest.setBirthDate(birthDate);
        personRequest.setAddress(address);
        personRequest.setSecurityNumber(securityNumber);

        return personRequest;
    }
}
