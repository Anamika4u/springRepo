package com.restapimongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        return employeeOptional.get();
    }

    public Employee createEmployee(Employee employee) {
        // Check if employee with the same name already exists
        if (employeeRepository.findByName(employee.getName()).isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already exists with name: " + employee.getName());
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}