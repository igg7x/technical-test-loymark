package com.example.loymark_test.section4;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    // SELECT * FROM orders WHERE customer_id = {customer.id};
    @Query("SELECT o FROM Orders o WHERE o.customer = :customer")
    List<Orders> findOrdersByCustomer(@Param("customer") Customer customer);

    // SELECT SUM(total_amount) FROM orders WHERE customer_id = {customer.id};
    @Query("SELECT SUM(o.totalAmount) FROM Orders o WHERE o.customer = :customer")
    Double calculateTotalAmountSpentByCustomer(@Param("customer") Customer customer);
}
