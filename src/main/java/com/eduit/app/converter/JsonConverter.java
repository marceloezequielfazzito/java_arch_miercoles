package com.eduit.app.converter;

import com.eduit.app.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {


    private ObjectMapper objectMapper;

    public JsonConverter() {
        objectMapper = new ObjectMapper();
    }

    public Car fromJson(String json){
        try {
            Car car = objectMapper.readValue(json, Car.class);
            return car;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public String toJson(Car c){
        try {
            return objectMapper.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
