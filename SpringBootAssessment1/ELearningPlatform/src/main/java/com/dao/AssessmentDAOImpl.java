package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Assessment;
import com.entities.Course;
import com.exception.InvalidAssessmentException;
import com.exception.InvalidCourseException;
import com.repository.AssessmentRepository;
import com.repository.CourseRepository;

@Component
public class AssessmentDAOImpl implements IAssessmentDAO {

	// Provide necessary Annotation
	@Autowired
	private AssessmentRepository assessmentRepository;

	// Provide necessary Annotation
	private CourseRepository courseRepository;

	public Assessment addAssessment(Assessment assessment, int courseId) throws InvalidCourseException {

		// fill code
		Course c=courseRepository.findById(courseId).orElse(null);
		if(c==null) {
			throw new InvalidCourseException();
		}
       // assessment.setAssessmentId(courseId);
		return assessmentRepository.save(assessment);
	}

	public Assessment updateAttempts(int assessmentId, int attempts) throws InvalidAssessmentException {
		// fill code
		Assessment a=assessmentRepository.findById(assessmentId).orElse(null);
		if(a==null) {
			throw new InvalidAssessmentException();
		}
        a.setAttempts(attempts);
		return assessmentRepository.save(a);
	}

	public List<Assessment> viewAssessmentsByAssessmentType(String assessmentType) {

		// fill code

		return assessmentRepository.findAssessmentsByAssessmentType(assessmentType);
	}

	public List<Assessment> viewAssessmentsByCourseName(String courseName) {

		// fill code

		Course c = courseRepository.findByCourseName(courseName);
		return assessmentRepository.findByCourseObj(c);
	}

	public Assessment deleteAssessment(int assessmentId) throws InvalidAssessmentException {

		// fill code
		Assessment a = assessmentRepository.findById(assessmentId).orElse(null);
		if(a==null) {
			throw new InvalidAssessmentException();
		}
        assessmentRepository.delete(a);
		return assessmentRepository.save(a);
	}

}
