package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Course;
import com.exception.InvalidCourseException;
import com.repository.CourseRepository;

@Component
public class CourseDAOImpl implements ICourseDAO {

	// Provide necessary Annotation
	@Autowired
	private CourseRepository courseRepository;

	public Course addCourse(Course Course) {
		// fill code

		return courseRepository.save(Course);
	}

	public Course viewCourseById(int courseId) throws InvalidCourseException {

		// fill code
		Optional<Course> c = courseRepository.findById(courseId);
		if(c.isPresent()) {
			Course cc = c.get();
			return cc;
		}
        throw new InvalidCourseException();
		
	}

	public List<Course> viewCoursesByCategory(String category) {

		// fill code

		return courseRepository.findCoursesByCategory(category);
	}

	public List<Course> viewCoursesByFee(double lowerLimit, double upperLimit) {

		// fill code

		return courseRepository.findCoursesByFee(lowerLimit, upperLimit);
	}

	public List<Course> viewCoursesByUniversityAndCourseDuration(String university, int courseDuration) {

		// fill code

		return courseRepository.findCoursesByUniversityAndCourseDuration(university, courseDuration);
	}
}
