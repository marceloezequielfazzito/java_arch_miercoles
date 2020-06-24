package com.eduit.app.converter;

import com.eduit.app.entities.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class JsonConverter {


    private ObjectMapper objectMapper;

    public JsonConverter() {
        objectMapper = new ObjectMapper();
    }

    public Car fromJson(String json){
        try {
            //nuevo comentario
            //nuevo comentario
            Car car = objectMapper.readValue(json, Car.class);
            return car;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public String toJson(Car c){
        try {
            //comentario
            //otro comentario
            return objectMapper.writeValueAsString(c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonConverter that = (JsonConverter) o;
        return Objects.equals(objectMapper, that.objectMapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectMapper);
    }

    @Override
    public String toString() {
        return "JsonConverter{" +
                "objectMapper=" + objectMapper +
                '}';
    }
}
