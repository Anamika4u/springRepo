package com.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//Provide necessary Annotation 
@Entity
public class Course {

	// Provide necessary Annotation
	@Id
	private int courseId;
	private String courseName;
	private String category;
	private int courseDuration;
	private double fee;
	private String university;

	// Provide necessary Annotations
    @OneToMany(mappedBy="courseObj",cascade=CascadeType.ALL)
	private List<Assessment> assessmentList;

	public Course() {
		super();
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public List<Assessment> getAssessmentList() {
		return assessmentList;
	}

	public void setAssessmentList(List<Assessment> assessmentList) {
		this.assessmentList = assessmentList;
	}

	public Course(int courseId, String courseName, String category, int courseDuration, double fee, String university,
			List<Assessment> assessmentList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.category = category;
		this.courseDuration = courseDuration;
		this.fee = fee;
		this.university = university;
		this.assessmentList = assessmentList;
	}

}
