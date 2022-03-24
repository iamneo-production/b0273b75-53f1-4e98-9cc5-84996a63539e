package com.examly.springapp.model;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.empId;
import javax.persistence.Table;


public class EmployeeModel {
    private long empId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private String department;

    public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

    @Override
    public String toString() {
        return "EmployeeModel [empId=" + empId + ", name=" + name + ", email=" + email   + ", mobileNumber=" + mobileNumber + ", role=" + role + ", department=" + department + "]";
    }
}
