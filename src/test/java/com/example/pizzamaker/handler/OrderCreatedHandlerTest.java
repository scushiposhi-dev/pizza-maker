package com.example.pizzamaker.handler;

import com.example.orderpizza.message.PizzaOrder;
import com.example.pizzamaker.service.PizzaMakerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.pizzamaker.util.TestUtil.getPizzaOrderMessageInstance;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderCreatedHandlerTest {
    PizzaMakerService pizzaMakerService;
    OrderCreatedHandler orderCreatedHandler;
    @BeforeEach
    void setUp() {
        pizzaMakerService=mock(PizzaMakerService.class);
        orderCreatedHandler=new OrderCreatedHandler(pizzaMakerService);
    }

    @Test
    void listen_Success() throws Exception{
        PizzaOrder pizzaOrderMessageInstance = getPizzaOrderMessageInstance();
        orderCreatedHandler.listen(pizzaOrderMessageInstance);

        verify(pizzaMakerService, times(1)).process(pizzaOrderMessageInstance);
    }

    @Test
    void listen_ServiceThrowsException() throws Exception {
        PizzaOrder pizzaOrderMessageInstance = getPizzaOrderMessageInstance();
        doThrow(new RuntimeException("Processing failure")).when(pizzaMakerService).process(pizzaOrderMessageInstance);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> orderCreatedHandler.listen(pizzaOrderMessageInstance));

        verify(pizzaMakerService, times(1)).process(pizzaOrderMessageInstance);

        assertEquals("Processing failure",runtimeException.getMessage());
    }
}