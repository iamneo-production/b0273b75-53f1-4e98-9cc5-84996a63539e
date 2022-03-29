package com.examly.springapp;

public class JobModel{
    
    private String jobId;
    private String jobTitle;
    private String jobLocation;
    private String jobType;
    private String jobDesc;
    private String salary;


    public JobModel(String jobId,String jobTitle, String jobLocation, String jobType,String jobDesc,String salary){
    super();
	this.jobId = jobId;
	this.jobTitle = jobTitle;
	this.jobLocation = jobLocation;
    this.jobType = jobType;
	this.jobDesc = jobDesc;
	this.salary = salary;

    }
    public String getJobTitle() {
        return jobTitle;
    }
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getJobLocation() {
        return jobLocation;
    }
    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
    public String getJobType() {
        return jobType;
    }
    public void setJobType(String jobType) {
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
    
}