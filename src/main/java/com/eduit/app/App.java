package com.eduit.app;


import com.eduit.app.converter.JsonConverter;
import com.eduit.app.entities.Car;

public class App {

    public static void main(String[] args) {

        Car ford = new Car("ford","fiesta");

        JsonConverter jsonConverter = new JsonConverter();

        System.out.println(jsonConverter.toJson(ford));

    }
}
