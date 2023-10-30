package com.example.pizzamaker.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter@Setter
public abstract class Pizza {
    String name;
    List<String> toppings =  new ArrayList<>();

    public  void prepare(){log.info("Preparing pizza:{}",name);}
    public  void bake(){log.info("Baking pizza:{}",name);}
    public  void cut(){log.info("Cutting pizza:{}",name);}
    public  void box(){log.info("Boxing pizza:{}",name);}
}
