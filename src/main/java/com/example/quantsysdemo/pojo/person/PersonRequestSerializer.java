package com.example.quantsysdemo.pojo.person;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PersonRequestSerializer extends JsonSerializer<PersonRequest> {

    @Override
    public void serialize(PersonRequest person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", person.getId());
        jsonGenerator.writeStringField("name", person.getName());
        jsonGenerator.writeNumberField("age", person.getAge());
        jsonGenerator.writeObjectField("address", person.getAddress());
        jsonGenerator.writeStringField("birthDate", person.getBirthDate());
        jsonGenerator.writeNumberField("securityNumber", person.getSecurityNumber());
        jsonGenerator.writeEndObject();
    }
}

