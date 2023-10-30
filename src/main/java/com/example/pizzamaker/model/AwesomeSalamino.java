package com.example.pizzamaker.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Component
public class AwesomeSalamino extends Pizza{
    public AwesomeSalamino() {
        super.name="salamino";
        super.toppings= List.of("a lot of salamino");
    }
}
