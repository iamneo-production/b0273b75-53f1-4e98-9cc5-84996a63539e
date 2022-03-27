package com.examly.springapp.model;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class EmployeeModel {
    private String empId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private boolean department;
	private String password;

	@Id
	@GeneratedValue(strategy = GenerationTye.AUTO)
    public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mobileNumber", nullable = false)
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "role", nullable = false)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "department", nullable = false)
	public boolean getDepartment() {
		return department;
	}
	public void setDepartment(boolean department) {
		this.department = department;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
    public String toString() {
        return "EmployeeModel [empId=" + empId + ", name=" + name + ", email=" + email   + ", mobileNumber=" + mobileNumber + ", role=" + role + ", department=" + department + ", password=" + pasword + "]";
    }
}