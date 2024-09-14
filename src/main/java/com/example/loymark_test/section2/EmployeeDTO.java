package com.example.loymark_test.section2;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
public class EmployeeDTO {

    private String name;
    private String designation;
    private double salary;
}
