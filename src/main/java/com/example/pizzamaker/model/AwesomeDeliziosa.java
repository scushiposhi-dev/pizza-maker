package com.example.pizzamaker.model;


import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Component
public class AwesomeDeliziosa extends Pizza{
    public AwesomeDeliziosa() {
        super.name="deliziosa";
        super.toppings= List.of("mushrooms");
    }
}
