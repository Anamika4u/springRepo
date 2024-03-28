package employeecontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.Employee;

@RestController

public class EmployeeController {
	@GetMapping("/leesha")
    public List<Employee> getAllEmployees() {
 
        return Arrays.asList(
                new Employee(1, "Anamika","Gorakhpur"),
                new Employee(2, "Leesha","Delhi")
        );
    }
}
