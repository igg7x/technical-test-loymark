package com.example.loymark_test.section4;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDTO {

    private LocalDate orderDate;
    private Double totalAmount;
}
