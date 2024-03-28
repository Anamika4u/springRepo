package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Course;

//Provide necessary annotation
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

	// Provide necessary methods to view courses by category, view courses by fee
	// between the values, view courses by university and course duration
	List<Course> findCoursesByCategory(String category);
	Course findByCourseName(String courseName);
	List<Course> findCoursesByFee(double lowerLimit,double upperLimit);
	List<Course> findCoursesByUniversityAndCourseDuration(String university,int courseDuration);

}
