package com.crudoperationwithexceptionhandling;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Access(AccessType.FIELD)
public class Student {
	
	@Id
	private int stuId;
	private String stuName;
	private String address;
	private long phoneNumber;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Student(int stuId, String stuName, String address, long phoneNumber) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	

}
