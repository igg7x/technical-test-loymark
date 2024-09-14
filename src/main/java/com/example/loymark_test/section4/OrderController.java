package com.example.loymark_test.section4;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/customer/{customerEmail}/orders")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(@PathVariable String customerEmail) {
        return ResponseEntity.ok(orderService.findOrdersByCustomer(customerEmail));
    }

    @GetMapping("/customer/{customerEmail}/total")
    public Double getTotalAmountSpentByCustomer(@PathVariable String customerEmail) {

        return orderService.calculateTotalAmountSpentByCustomer(customerEmail);
    }
}
