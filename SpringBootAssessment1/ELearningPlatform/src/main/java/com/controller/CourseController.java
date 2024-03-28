package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Course;
import com.exception.InvalidCourseException;
import com.service.ICourseService;

//Provide necessary Annotation
@RestController
public class CourseController {

	// Provide necessary Annotation
	@Autowired
	private ICourseService courseService;

	// Provide necessary Annotation for the below methods and fill the code
    @PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course Course) {
		return courseService.addCourse(Course);

	}
    @GetMapping("/viewCourseById/{courseId}")
	public Course viewCourseById(@PathVariable int courseId) throws InvalidCourseException {
		return courseService.viewCourseById(courseId);
	}
    @GetMapping("/viewCoursesByCategory/{category}")
	public List<Course> viewCoursesByCategory(@PathVariable String category) {
		return courseService.viewCoursesByCategory(category);
	}
    @GetMapping("/viewCoursesByFee/{lowerLimit}/{upperLimit}")
	public List<Course> viewCoursesByFee(@PathVariable double lowerLimit,@PathVariable  double upperLimit) {
		return courseService.viewCoursesByFee(lowerLimit, upperLimit);
	}
    @GetMapping("/viewCoursesByUniversityAndCourseDuration/{university}/{courseDuration}")
	public List<Course> viewCoursesByUniversityAndCourseDuration(@PathVariable String university, @PathVariable int courseDuration) {
		return courseService.viewCoursesByUniversityAndCourseDuration(university, courseDuration);
	}

}