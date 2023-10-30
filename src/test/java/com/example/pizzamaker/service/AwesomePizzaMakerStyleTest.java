package com.example.pizzamaker.service;

import com.example.pizzamaker.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AwesomePizzaMakerStyleTest {


    AwesomePizzaMakerStyle awesomePizzaMakerStyle;
    AwesomeSalamino salamino;
    AwesomeMargherita margherita;
    AwesomeDeliziosa deliziosa;


    @BeforeEach
    void setUp() {
        salamino = mock(AwesomeSalamino.class);
        margherita = mock(AwesomeMargherita.class);
        deliziosa = mock(AwesomeDeliziosa.class);
        awesomePizzaMakerStyle = new AwesomePizzaMakerStyle(salamino, margherita, deliziosa);
    }

    @ParameterizedTest
    @ValueSource(strings = {"SALAMINO", "MARGHERITA", "DELIZIOSA"})
    void createPizza_Success(String pizza) {
        assertDoesNotThrow(()->awesomePizzaMakerStyle.createPizza(pizza));
    }

    @Test
    void createPizza_ThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> awesomePizzaMakerStyle.createPizza("4Stagioni"));
    }
}