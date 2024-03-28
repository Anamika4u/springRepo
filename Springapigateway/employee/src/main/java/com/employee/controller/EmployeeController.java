package com.employee.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.Employee;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	@GetMapping("/all")
    public List<Employee> getAllEmployees() {
 
        return Arrays.asList(
                new Employee(1, "Anamika","Gorakhpur"),
                new Employee(2, "Leesha","Delhi")
        );
    }

}
