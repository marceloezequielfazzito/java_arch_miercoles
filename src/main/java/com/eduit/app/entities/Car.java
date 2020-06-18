package com.eduit.app.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;

    @JsonCreator
    public Car(@JsonProperty("brand") String brand,
               @JsonProperty("model") String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
