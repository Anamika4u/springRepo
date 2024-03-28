package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Provide necessary Annotation
@Entity
public class Assessment {

	// Provide necessary Annotation
	@Id

	private int assessmentId;
	private int assessmentDuration;
	private String assessmentType;
	private int attempts;
	private double totalMarks;
	// Provide necessary Annotations
   @ManyToOne
   @JoinColumn(name="course_id")
	private Course courseObj;

	public Assessment() {
		super();
	}

	public Assessment(int assessmentId, int assessmentDuration, String assessmentType, int attempts, double totalMarks,
			Course courseObj) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentDuration = assessmentDuration;
		this.assessmentType = assessmentType;
		this.attempts = attempts;
		this.totalMarks = totalMarks;
		this.courseObj = courseObj;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public int getAssessmentDuration() {
		return assessmentDuration;
	}

	public void setAssessmentDuration(int assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Course getCourseObj() {
		return courseObj;
	}

	public void setCourseObj(Course courseObj) {
		this.courseObj = courseObj;
	}

}
