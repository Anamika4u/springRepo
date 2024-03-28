package com.dao;

import java.util.List;
import com.entities.Course;
import com.exception.InvalidCourseException;

public interface ICourseDAO {

	public Course addCourse(Course Course);
	public Course viewCourseById(int courseId) throws InvalidCourseException;
	public List<Course> viewCoursesByCategory(String category);
	public List<Course> viewCoursesByFee( double lowerLimit, double upperLimit);
	public List<Course> viewCoursesByUniversityAndCourseDuration(String university,int courseDuration);


}
