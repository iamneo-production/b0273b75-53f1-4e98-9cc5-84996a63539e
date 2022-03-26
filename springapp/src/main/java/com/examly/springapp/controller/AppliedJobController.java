package com.examly.springapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.examly.springapp.model.AppliedJobModel;
import com.examly.springapp.repository.AppliedJobRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AppliedJobController {
	
	private static class AppliedJobsPayload {
		public String empId;
		public Integer appliedDate;
	}
	
	 @Autowired
	private AppliedJobRepository appliedJobRepository;
	@PostMapping(path="/home/{jobId}")
	public @ResponseBody String addToAppliedJobs (@PathVariable(value="jobId") String jobId, @RequestBody String json) {
		ObjectMapper mapper = new ObjectMapper();
		AppliedJobsPayload ajp;
		try {
			ajp = mapper.readValue(json, AppliedJobsPayload.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Bad";
		}
		
		AppliedJobModel appliedJob = new AppliedJobModel();
		appliedJob.setJobId(jobId);
		appliedJob.setEmployeeId(ajp.empId);
		appliedJobRepository.save(appliedJob);
		return "Saved" ;
	}
	
	@RequestMapping(path="/home/{employeeId}")
	@ResponseBody
	public String getAppliedJobs(@PathVariable(value="employeeId") String employeeId){
		return appliedJobRepository.findByEmployeeId(employeeId).toString();
	}
}
