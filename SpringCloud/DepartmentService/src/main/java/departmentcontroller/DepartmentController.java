package departmentcontroller;
 // Adjust the package declaration as per your project structure

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import department.Department; // Import the Department class

@RestController
public class DepartmentController {
    
    @GetMapping("/hello")
    public List<Department> getAllDepartments() {
        // Assuming Department class has appropriate constructor and attributes
        return Arrays.asList(
                new Department(1, "Anamika", "IT"),
                new Department(2, "Leesha", "Non.IT")
        );
    }
}

