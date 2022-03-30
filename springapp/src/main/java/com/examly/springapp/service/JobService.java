package com.examly.springapp.service;
import java.util.*;

import com.examly.springapp.model.JobModel;
import com.examly.springapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobModel> getJobs(){
        List<JobModel> jobs= new ArrayList<>();
        jobs.addAll(jobRepository.findAll());
        return jobs;
    }

    public JobModel jobEditData(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    public void jobSave(JobModel job) {
        jobRepository.save(job);

    }

    public void deleteJobs(String id) {
        jobRepository.deleteById(id);
    }

    @Transactional
    public void updateJob(String jobId, String jobTitle, String jobLocation, String jobType, String jobDesc, String salary, String experience) {

        JobModel jobModel = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalStateException(
                        "Job with id " + jobId + " does not exist"
                ));

        if(jobTitle != null && jobTitle.length() > 0 && !Objects.equals(jobModel.getJobTitle(), jobTitle)) {
            jobModel.setJobTitle(jobTitle);
        }

        if(jobLocation != null && jobLocation.length() > 0 && !Objects.equals(jobModel.getJobLocation(), jobLocation)) {
            jobModel.setJobLocation(jobLocation);
        }

        if(jobType != null && jobType.length() > 0 && !Objects.equals(jobModel.getJobType(), jobType)) {
            jobModel.setJobType(jobType);
        }

        if(jobDesc != null && jobDesc.length() > 0 && !Objects.equals(jobModel.getJobDesc(), jobDesc)) {
            jobModel.setJobDesc(jobDesc);
        }

        if(salary != null && salary.length() > 0 && !Objects.equals(jobModel.getSalary(), salary)) {
            jobModel.setSalary(salary);
        }

        if(experience != null && experience.length() > 0 && !Objects.equals(jobModel.getExperience(), experience)) {
            jobModel.setExperience(experience);
        }
    }
}

