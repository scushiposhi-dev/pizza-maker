package com.example.pizzamaker.service;

import com.example.orderpizza.message.PizzaMakerStatus;
import com.example.orderpizza.message.PizzaOrder;
import com.example.orderpizza.message.PizzaOrderProcessed;
import com.example.pizzamaker.model.AwesomeSalamino;
import com.example.pizzamaker.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CompletableFuture;

import static com.example.pizzamaker.util.TestUtil.getPizzaOrderMessageInstance;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PizzaMakerServiceTest {
    AwesomePizzaMakerStyle awesomePizzaMakerStyleMock;
    KafkaTemplate<String, Object> kafkaTemplateMock;

    PizzaMakerService pizzaMakerService;

    @BeforeEach
    void setUp() {
        awesomePizzaMakerStyleMock=mock(AwesomePizzaMakerStyle.class);
        kafkaTemplateMock=mock(KafkaTemplate.class);
        pizzaMakerService=new PizzaMakerService(awesomePizzaMakerStyleMock,kafkaTemplateMock);
    }

    @Test
    void process() {
        when(awesomePizzaMakerStyleMock.createPizza(anyString()))
                .thenReturn(new AwesomeSalamino());

        when(kafkaTemplateMock.send(anyString(),anyString(),any(PizzaMakerStatus.class)))
                .thenReturn(mock(CompletableFuture.class));

        PizzaOrder pizzaOrder = getPizzaOrderMessageInstance();
        assertDoesNotThrow(()->pizzaMakerService.process(pizzaOrder));
    }
}