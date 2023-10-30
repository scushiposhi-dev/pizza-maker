package com.example.pizzamaker.service;

import com.example.orderpizza.message.PizzaMakerStatus;
import com.example.orderpizza.message.PizzaOrder;
import com.example.orderpizza.message.PizzaOrderProcessed;
import com.example.orderpizza.message.PizzaStatusEnum;
import com.example.pizzamaker.model.Pizza;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.orderpizza.message.PizzaStatusEnum.*;
import static com.example.pizzamaker.util.KafkaMakerUtil.MAKER_STATUS_TOPIC;
import static com.example.pizzamaker.util.KafkaMakerUtil.ORDER_PROCESSED_TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class PizzaMakerService {

    private final AwesomePizzaMakerStyle awesomePizzaMakerStyle;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void process(PizzaOrder pizzaOrder) throws Exception{

        Pizza pizza = awesomePizzaMakerStyle.createPizza(pizzaOrder.getPizzaType());

        UUID orderId = pizzaOrder.getOrderId();

        pizza.prepare();
        updateStatus(orderId.toString(),orderId,PREPARING);

        pizza.bake();
        updateStatus(String.valueOf(orderId),orderId,BAKING);

        pizza.cut();
        updateStatus(String.valueOf(orderId),orderId,CUTTING);

        pizza.box();
        updateStatus(String.valueOf(orderId),orderId,BOXING);

        kafkaTemplate.send(ORDER_PROCESSED_TOPIC, PizzaOrderProcessed.builder()
                .orderId(orderId).build());

    }

    private void updateStatus(String key,UUID orderId,PizzaStatusEnum pizzaStatusEnum) throws Exception {
        kafkaTemplate.send(MAKER_STATUS_TOPIC, key,PizzaMakerStatus.builder()
                .orderId(orderId)
                .pizzaStatusEnum(pizzaStatusEnum).build()).get();
    }
}
