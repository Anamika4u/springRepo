package com.crudoperationwithexceptionhandling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	@GetMapping("/{stuId}")
	public ResponseEntity<Student> getStudentByStuId(@PathVariable int stuId){
		Student student=studentService.getStudentByStuId(stuId);
		return ResponseEntity.ok(student);				
	}
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student createdStudent = studentService.createStudent(student);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);		
	}
	@PutMapping("/{stuId}")
	public ResponseEntity<Student> updateStudent(@PathVariable int stuId,@RequestBody Student student){
		Student updatedStudent = studentService.updateStudent(stuId,student);
		return ResponseEntity.ok(updatedStudent);
	}
	@DeleteMapping("/{stuId}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int stuId){
		studentService.deleteStudent(stuId);
		return ResponseEntity.noContent().build();
	}

}
