package com.example.pizzamaker.util;

public class KafkaMakerUtil {
    public static final String MAKER_STATUS_TOPIC="pizza.status";
    public static final String ORDER_PROCESSED_TOPIC="order.processed";

    private KafkaMakerUtil() {
        // so you cannot instantiate it
    }
}
