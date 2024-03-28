package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IAssessmentDAO;
import com.entities.Assessment;
import com.exception.InvalidAssessmentException;
import com.exception.InvalidCourseException;

//Provide necessary annotation
@Service
public class AssessmentServiceImpl implements IAssessmentService {

	// Provide necessary annotation
	@Autowired
	private IAssessmentDAO assessmentDAO;

	public Assessment addAssessment(Assessment assessment, int courseId) throws InvalidCourseException {
		// fill the code
		return assessmentDAO.addAssessment(assessment, courseId);
	}

	public Assessment updateAttempts(int assessmentId, int attempts) throws InvalidAssessmentException {
		// fill the code
		return assessmentDAO.updateAttempts(assessmentId, attempts);
	}

	public List<Assessment> viewAssessmentsByAssessmentType(String assessmentType) {
		// fill the code
		return assessmentDAO.viewAssessmentsByAssessmentType(assessmentType);
	}

	public List<Assessment> viewAssessmentsByCourseName(String courseName) {
		// fill the code
		return assessmentDAO.viewAssessmentsByCourseName(courseName);
	}

	public Assessment deleteAssessment(int assessmentId) throws InvalidAssessmentException {
		// fill the code
		return assessmentDAO.deleteAssessment(assessmentId);
	}
}
