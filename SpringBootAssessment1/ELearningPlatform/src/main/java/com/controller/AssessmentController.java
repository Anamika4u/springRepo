package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Assessment;
import com.exception.InvalidAssessmentException;
import com.exception.InvalidCourseException;
import com.service.IAssessmentService;

//Provide necessary Annotation
@RestController
public class AssessmentController {

	// Provide necessary Annotation
	@Autowired
	private IAssessmentService assessmentService;

	// Provide necessary Annotation for the below methods and fill the code
    @PostMapping("/addAssessment/{courseId}")
	public Assessment addAssessment(@RequestBody Assessment assessment, @PathVariable int courseId) throws InvalidCourseException {
		return assessmentService.addAssessment(assessment, courseId);
	}
    @PutMapping("/updateAttempts/{assessmentId}/{attempts}")
	public Assessment updateAttempts(@PathVariable int assessmentId,@PathVariable int attempts) throws InvalidAssessmentException {
		return assessmentService.updateAttempts(assessmentId, attempts);
	}
    @GetMapping("/viewAssessmentsByAssessmenttype/{assessmentType}")
	public List<Assessment> viewAssessmentsByAssessmentType(@PathVariable String assessmentType) {
		return assessmentService.viewAssessmentsByAssessmentType(assessmentType);
	}
    @GetMapping("/viewAssessmentsByCourseName/{courseName}")
	public List<Assessment> viewAssessmentsByCourseName(@PathVariable String courseName) {
		return assessmentService.viewAssessmentsByCourseName(courseName);
	}
    @DeleteMapping("/deleteAssessment/{assessmentId}")
	public Assessment deleteAssessment(@PathVariable int assessmentId) throws InvalidAssessmentException {
		return assessmentService.deleteAssessment(assessmentId);
	}

}
