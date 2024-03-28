package com.crudoperationwithexceptionhandling;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
	   @Autowired
	    private MockMvc mockMvc;
		
	    @Mock
	    private StudentService stuService;
	    private Student stu;
	    private List<Student> stuList;

	    @InjectMocks
	    private StudentController stuController;
	    
	    @BeforeEach
	    public void setUp(){
	        stu = new Student(1,"FIN", "Pune",1000);
	        mockMvc= MockMvcBuilders.standaloneSetup(stuController).build();
	    }
	    
	    
	    @Test
	    public void saveStuControllerTest() throws Exception {
	        when(stuService.createStudent(any())).thenReturn(stu);
	        mockMvc.perform(post("/api/students")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(stu)))
	                .andExpect(status().isCreated());
	        verify(stuService, times(1)).createStudent(any());

	    }
	    
	    @Test
	    public void getAllStudentControllerTest() throws Exception{
	        when(stuService.getAllStudents()).thenReturn(stuList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/students")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(stu)))
	                .andDo(MockMvcResultHandlers.print());
	        verify(stuService, times(1)).getAllStudents();

	    }
	    
	    @Test
	    void testUpdateStudentController() throws Exception {
	    	Student student = new Student(1, "John","Delhi",10000);
	    	when(stuService.updateStudent(any(Integer.class), any(Student.class))).thenReturn(student);
    	    mockMvc.perform(put("/api/students/1")
    	                        .contentType(MediaType.APPLICATION_JSON)
    	                        .content(asJsonString(student)))
    	           .andExpect(status().isOk());

    	    verify(stuService, times(1)).updateStudent(any(Integer.class), any(Student.class));
	    }

	    @Test
	    void testDeleteStudentController() throws Exception {
	       
	        int stuId = 1;
	       
	        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(stuController).build();
	       
	        mockMvc.perform(delete("/api/students/{stuId}", stuId))
	                .andExpect(status().isNoContent());
	        verify(stuService, times(1)).deleteStudent(stuId);
	    }

	    
	    @Test
	    void testGetStudentByIdController() throws Exception {
	        
	        Student student = new Student(1, "John","Delhi",10000);
	        when(stuService.getStudentByStuId(1)).thenReturn(student);
	        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(stuController).build();
	        mockMvc.perform(get("/api/students/1"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.stuId").value(1))
	                .andExpect(jsonPath("$.stuName").value("John"));	      
	        verify(stuService, times(1)).getStudentByStuId(1);
	    }
	    
		public static String asJsonString(final Object obj){
	        try{
	            return new ObjectMapper().writeValueAsString(obj);
	        }catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }

}
