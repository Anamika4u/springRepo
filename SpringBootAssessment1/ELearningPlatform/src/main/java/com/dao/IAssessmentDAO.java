package com.dao;

import java.util.List;

import com.entities.Assessment;
import com.exception.InvalidCourseException;
import com.exception.InvalidAssessmentException;

public interface IAssessmentDAO {
	public Assessment addAssessment(Assessment assessment,int courseId) throws InvalidCourseException;
	public Assessment updateAttempts(int assessmentId,int attempts) throws InvalidAssessmentException;
	public List<Assessment> viewAssessmentsByAssessmentType(String assessmentType);
	public List<Assessment> viewAssessmentsByCourseName(String courseName);
	public Assessment deleteAssessment(int assessmentId) throws InvalidAssessmentException;
}
