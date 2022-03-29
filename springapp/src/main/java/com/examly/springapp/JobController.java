package com.examly.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
 
	@Autowired
	private JobService jobService;
	
	@RequestMapping("/hr")
	public List<JobModel> getJobs() {
		return jobService.getJobs();
	}
	@RequestMapping("/hr/jobEdit/{id}")
	public Topic getTopic(@PathVariable String id) {
		return jobService.jobEditData(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/hr/addJob")
	public void addTopic(@RequestBody JobModel jobModel) {
		jobService.jobSave(jobModel);
	}
}
 