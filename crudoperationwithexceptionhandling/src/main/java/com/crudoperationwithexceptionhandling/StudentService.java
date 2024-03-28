package com.crudoperationwithexceptionhandling;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentByStuId(int stuId) {
		Optional<Student> studentOptional = studentRepository.findById(stuId);
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException("Student not found with stuId: "+stuId);
		}
		return studentOptional.get();
	}
	public Student createStudent(Student student) {
		if(studentRepository.findByStuName(student.getStuName()).isPresent()) {
			throw new StudentAlreadyExistsException("Student already Exists with name: "+ student.getStuName());
		}
		return studentRepository.save(student);
	}
	public Student updateStudent(int stuId, Student updatedStudent) {
		Optional<Student> studentOptional = studentRepository.findById(stuId);
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException("Student not Found With id: "+stuId);
		}
		updatedStudent.setStuId(stuId);
		return studentRepository.save(updatedStudent);
	}
	public void deleteStudent(int stuId) {
		studentRepository.deleteById(stuId);
	}

}
