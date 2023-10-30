package com.example.pizzamaker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PizzaMakerApplicationTests {

    @Test
    void contextLoads(ApplicationContext context) {
        assertNotNull(context);
    }
}
