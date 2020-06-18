package com.eduit.app.converter;

import static org.junit.Assert.*;

import com.eduit.app.entities.Car;
import org.junit.Test;

public class JsonConverterTest {

    public static final String EXPECTED = "{\"brand\":\"ford\",\"model\":\"fiesta\"}";
    private JsonConverter jsonConverter;
    private String json;

    @Test
    public void mustCreateAJsonCar(){
        givenAJsonConverter();
        whenConvertCarToJson();
        thenShouldCreateAJsonCar();
    }

    private void thenShouldCreateAJsonCar() {
        assertEquals(EXPECTED, json);
    }

    private void whenConvertCarToJson() {
        Car ford = new Car("ford","fiesta");
        json = jsonConverter.toJson(ford);
    }

    private void givenAJsonConverter() {
        jsonConverter = new JsonConverter();
    }


}
