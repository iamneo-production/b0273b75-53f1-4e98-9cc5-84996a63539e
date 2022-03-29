package com.examly.springapp.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.examly.springapp.utils.JsonUtils;

@Entity
public class JobModel {
	@Id
	private long jobId;
	private String jobLocation;
	private String jobTitle;
	private String jobType;
	private String jobDesc;
	private String salary;
	private String experience;
	
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getjobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobType() {
		return jobType;
	}

	public void setEmail(String jobType) {
		this.jobType = jobType;
	}

    public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

    public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Override 
	public String toString() {
		return JsonUtils.toJson(this);
	}

	
}
