package com.example.pizzamaker.handler;

import com.example.orderpizza.message.PizzaOrder;
import com.example.pizzamaker.service.PizzaMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final PizzaMakerService pizzaMakerService;

    @KafkaListener(
            id = "orderConsumerClient",
            groupId = "maker.order.created.consumer",
            topics = {"order.created"},
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listen(PizzaOrder pizzaOrder) {

        log.info("Received message:{}", pizzaOrder);

        try {
            pizzaMakerService.process(pizzaOrder);
        } catch (Exception e) {
            log.error("Processing failure");
            log.debug("next time I will provide a dedicated exception");
            throw new RuntimeException("Processing failure");
        }
    }
}
