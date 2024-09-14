package com.example.loymark_test.section4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.loymark_test.section4.Exception.CustomerNotFoundException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public Double calculateTotalAmountSpentByCustomer(String customerEmail) {
        Customer customer = customerRepository.findByEmail(customerEmail)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + customerEmail));
        return orderRepository.calculateTotalAmountSpentByCustomer(customer);
    }

    public List<OrderDTO> findOrdersByCustomer(String customerEmail) {
        Customer customer = customerRepository.findByEmail(customerEmail)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + customerEmail));
        List<Orders> orders = orderRepository.findOrdersByCustomer(customer);
        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Orders order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTO.setTotalAmount(order.getTotalAmount());
            orderDTOs.add(orderDTO);
        }
        return orderDTOs;
    }
}
