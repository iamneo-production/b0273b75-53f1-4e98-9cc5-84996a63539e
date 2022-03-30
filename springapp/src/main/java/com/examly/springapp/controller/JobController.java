package com.examly.springapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.JobModel;
import com.examly.springapp.repository.JobRepository;
import com.examly.springapp.service.JobService;

@Controller
public class JobController {
    @Autowired
	private JobRepository jobRepository;
	@RequestMapping(path="/home")
	@ResponseBody
	public String getAllJObs() {
		return jobRepository.findAll().toString();

	}
	@Autowired
	private JobService jobService;

	@RequestMapping("/hr")
	public List<JobModel> getJobs() {
		return jobService.getJobs();
	}

	@RequestMapping("/hr/jobEdit/{id}")
	public JobModel getJob(@PathVariable String id) {
		return jobService.jobEditData(id);
	}

	@RequestMapping(method=RequestMethod.POST,value="/hr/addJob")
	public void addTopic(@RequestBody JobModel jobModel) {
		jobService.jobSave(jobModel);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/hr/delete/{id}")
	public void jobDelete(@PathVariable String id) {
		jobService.deleteJobs(id);
	}

	@PutMapping(path = "/hr/jobEdit/{jobId}")
	public void updateJob (
			@PathVariable("jobId") String jobId,
			@RequestParam(required = false) String jobTitle,
			@RequestParam(required = false) String jobLocation,
			@RequestParam(required = false) String jobType,
			@RequestParam(required = false) String jobDesc,
			@RequestParam(required = false) String salary,
			@RequestParam(required = false) String experience
	) {
		jobService.updateJob(jobId, jobTitle, jobLocation, jobType, jobDesc, salary, experience);
	}
	
	
}

