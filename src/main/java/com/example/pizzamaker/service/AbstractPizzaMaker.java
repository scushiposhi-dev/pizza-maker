package com.example.pizzamaker.service;

import com.example.pizzamaker.model.Pizza;

public abstract class AbstractPizzaMaker {
    public abstract Pizza createPizza(String type);
}
