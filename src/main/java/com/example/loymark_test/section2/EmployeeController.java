package com.example.loymark_test.section2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loymark_test.section2.Exception.EmployerCreationException;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeService employeService;

    public EmployeeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeService.getAllEmployees());
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> createEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) {
        try {
            EmployeeDTO newEmployer = employeService.createEmployee(employeeDTO);
            return new ResponseEntity<>(newEmployer, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new EmployerCreationException("Error creating employee: " + e.getMessage());
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeService.getEmployeeById(id));
    }
}
