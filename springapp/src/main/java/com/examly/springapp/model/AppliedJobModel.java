package com.examly.springapp.model;
import java.util.Date;
import javax.persistence.Id;

import com.examly.springapp.utils.JsonUtils;

import javax.persistence.Entity;


@Entity
public class AppliedJobModel {
	@Id
	private String jobId;
	private String employeeId;
	private Date appliedDate;
	
	public String getJobId() {
		return jobId;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public Date getAppliedDate() {
		return appliedDate;
	}
	
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	
	@Override 
	public String toString() {
		return JsonUtils.toJson(this);
	}
	
}
