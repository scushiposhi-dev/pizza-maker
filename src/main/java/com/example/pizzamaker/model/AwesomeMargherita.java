package com.example.pizzamaker.model;

import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@ToString
@Component
public class AwesomeMargherita extends Pizza{
    public AwesomeMargherita() {
        super.name="margherita";
        super.toppings= List.of("mozzarella","tomatoes sauce");
    }
}
