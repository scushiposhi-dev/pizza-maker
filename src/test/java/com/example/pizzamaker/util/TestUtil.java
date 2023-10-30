package com.example.pizzamaker.util;

import com.example.orderpizza.message.PizzaOrder;

import static java.util.UUID.randomUUID;

public class TestUtil {
    public static final String ORDER_CREATED_TOPIC = "order.created";
    public static final String MAKER_STATUS_TOPIC = "pizza.status";


    public static PizzaOrder getPizzaOrderMessageInstance() {
        return PizzaOrder.builder()
                .orderId(randomUUID())
                .pizzaType("SALAMINO")
                .build();

    }

    private TestUtil() {}
}
