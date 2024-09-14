package com.example.loymark_test.section2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.loymark_test.section2.Exception.EmployerNotFoundException;

@Service
public class EmployeService {

    private final EmployeeRepository employeeRepository;

    public EmployeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployerNotFoundException("Employee not found with id: " + id));

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setDesignation(employee.getDesignation());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
        return employeeDTO;

    }

    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setName(employee.getName());
            employeeDTO.setDesignation(employee.getDesignation());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTOs.add(employeeDTO);
        }
        return employeeDTOs;

    }

}
