package com.crudoperationwithexceptionhandling;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {
	@Autowired
	private StudentRepository stuRepo;
	
	@Test
	public void givenStudentshouldReturnStudentObject() {
		
		Student d1 = new Student(10,"Anamika", "Chennai",1000); //User input
		stuRepo.save(d1); //Data is saved into Database
		Student d2 = stuRepo.findById(d1.getStuId()).get(); // Data is retrieved from Database
		Assertions.assertNotNull(d2);
		Assertions.assertEquals(d1.getStuName(), d2.getStuName());
			
	}
	@Test
	public void getAllmustReturnAllStudents() {
		Student d1 = new Student(10,"Anamika", "Chennai",1000);		
		stuRepo.save(d1); // save the Data in Database
		List <Student> stuList = (List<Student>) stuRepo.findAll();
		Assertions.assertEquals("Anamika",stuList.get(0).getStuName());
			
	}
	@Test
    void testFindById_ExistingId() {
        // Given
		Student d1 = new Student(10,"Anamika", "Chennai",1000);		
      
        Optional<Student> result = stuRepo.findById(1);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Anamika", result.get().getStuName());
    }
	@Test
	 public void testDeleteStudent() {
		    Student d1 = new Student(10,"Anamika", "Chennai",1000);		
	        stuRepo.save(d1);

	        stuRepo.deleteById(d1.getStuId());

	        Optional<Student> deletedStudent = stuRepo.findById(d1.getStuId());
	        Assertions.assertTrue(deletedStudent.isEmpty());
	    }
	@Test
	 public void testUpdateStudent() {
		    Student d1 = new Student(10,"Anamika", "Chennai",1000);		
	        stuRepo.save(d1);
	        Optional<Student> retrieveStudent = stuRepo.findById(d1.getStuId());
	        Assertions.assertTrue(retrieveStudent.isPresent());
	        Assertions.assertEquals("Anamika", retrieveStudent.get().getStuName());
	        
	        retrieveStudent.get().setStuName("A");
	        stuRepo.save(retrieveStudent.get());
	        Optional<Student> updateStudent = stuRepo.findById(d1.getStuId());
	        
	        Assertions.assertTrue(updateStudent.isPresent());
	        Assertions.assertEquals("A", updateStudent.get().getStuName());
	    }



	
}
