package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ICourseDAO;
import com.entities.Course;
import com.exception.InvalidCourseException;

//Provide necessary annotation
@Service
public class CourseServiceImpl implements ICourseService {

	// Provide necessary annotation
	@Autowired
	private ICourseDAO courseDAO;

	public Course addCourse( Course Course) {
		// fill the code
		return courseDAO.addCourse(Course);
	}

	public Course viewCourseById( int courseId) throws InvalidCourseException {
		// fill the code
		return courseDAO.viewCourseById(courseId);
	}

	public List<Course> viewCoursesByCategory(String category) {
		// fill the code
		return courseDAO.viewCoursesByCategory(category);
	}

	public List<Course> viewCoursesByFee( double lowerLimit,double upperLimit) {
		// fill the code
		return courseDAO.viewCoursesByFee(lowerLimit, upperLimit);
	}

	public List<Course> viewCoursesByUniversityAndCourseDuration( String university, int courseDuration) {
		// fill the code
		return courseDAO.viewCoursesByUniversityAndCourseDuration(university, courseDuration);
	}

}
