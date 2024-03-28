package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Assessment;
import com.entities.Course;

//Provide necessary annotation
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment,Integer> {

	// Provide necessary methods to view assessments based on assessmentType and
	// view assessments based on courseName
	List<Assessment> findAssessmentsByAssessmentType(String assessmentType);
	List<Assessment> findByCourseObj(Course courseName);

}
