package com.crudoperationwithexceptionhandling;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	@Mock
	private StudentRepository dr;
	
	@InjectMocks
	private StudentService dsi;
	

	@Test
	public void TestsaveStudent() throws StudentAlreadyExistsException{
		Student d1 = new Student(10, "Anamika", "Chennai",1000); //user Input
		when(dr.save(any())).thenReturn(d1);
		dsi.createStudent(d1);
		verify(dr,times(1)).save(any());
    }
	

	@Test
	public void testGetAllStudents() {
		Student d1 = new Student(10, "Anamika", "Chennai",1000);//user Input
		dr.save(d1);
		Student d2 = new Student(20, "Leesha", "Pune",2000); //user Input
		dr.save(d2);
		Student d3 = new Student(30, "Rahul", "Delhi",6000); //user Input
		dr.save(d3);
		
		List<Student> dList = new ArrayList<>(); // List object is created to store Array of Department
		dList.add(d1);         //retrieved from Database
		dList.add(d2);
		dList.add(d3);
		
		when(dr.findAll()).thenReturn(dList);
		List<Student> dList1 = dsi.getAllStudents();
		Assertions.assertEquals(dList,dList1);
		verify(dr,times(1)).save(d1);
		verify(dr,times(1)).findAll();
		
 }
	@Test
    public void testUpdateStudent() throws StudentNotFoundException {
		Student d1 = new Student(10, "Anamika", "Chennai",1000);
        when(dr.findById(1)).thenReturn(Optional.of(d1));
        
        // Perform the update
        String newName = "Sunnym";
        d1.setStuName(newName);
        dsi.updateStudent(1, d1);
        
        verify(dr, times(1)).save(d1);
    }

	@Test
	public void testGetStudentById() throws StudentNotFoundException {
		Student d1 = new Student(10, "Anamika", "Chennai",1000);
        when(dr.findById(1)).thenReturn(Optional.of(d1));
        
        Student retrievedStudent = dsi.getStudentByStuId(1);
        Assertions.assertEquals(d1, retrievedStudent);
    }
	
	@Test
    public void testDeleteStudent() throws StudentNotFoundException {
		Student d1 = new Student(1, "Anamika", "Chennai",1000);
       // when(dr.findById(1)).thenReturn(Optional.of(d1));
        
        dsi.deleteStudent(1);
        
        verify(dr, times(1)).deleteById(1);
    }


	
}
