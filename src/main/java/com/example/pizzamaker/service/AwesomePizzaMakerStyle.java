package com.example.pizzamaker.service;

import com.example.pizzamaker.model.AwesomeDeliziosa;
import com.example.pizzamaker.model.AwesomeMargherita;
import com.example.pizzamaker.model.AwesomeSalamino;
import com.example.pizzamaker.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AwesomePizzaMakerStyle extends AbstractPizzaMaker{

    private final AwesomeSalamino awesomeSalamino;
    private final AwesomeMargherita awesomeMargherita;
    private final AwesomeDeliziosa awesomeDeliziosa;

    @Override
    public Pizza createPizza(String type) {
        return switch (type){
            case "SALAMINO" -> awesomeSalamino;
            case "MARGHERITA" -> awesomeMargherita;
            case "DELIZIOSA" -> awesomeDeliziosa;
            default -> throw new RuntimeException("does not exist, next time I will throw a custom exception");
        };
    }
}
