package com.examly.springapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	
	@Autowired
	private JobModelRepository jobModelRepository;
 
    public List<JobModel> getJobs(){
    	List<JobModel> jobs= new ArrayList<>();
        jobModelRepository.findAll().forEach(jobs::add);;
        return  jobs; 
    }
    
    public JobModel jobEditData(String id) {
        return jobModelRepository.findById(id).orElse(null);
    }
    
    public void jobSave(JobModel job) {
       jobModelRepository.save(job);
       
    }

    public void deleteJobs(String id) {
	    jobModelRepository.deleteById(id);
    }
}
