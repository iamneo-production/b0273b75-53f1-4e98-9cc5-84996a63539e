package com.examly.springapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(path = "/hr/allAppliedJobs")
	@ResponseBody
	public String getAllAppliedJobs() {
		return appliedJobRepository.findAll().toString();
	}

	@DeleteMapping(path="/appliedJobs/delete/{employeeId}")
	public String deleteAppliedJob(
			@PathVariable(value="employeeId") String employeeId,
			@RequestParam(required = true) String jobId) {

		AppliedJobModel appliedJobModel =appliedJobRepository.findAppliedJob(employeeId, jobId)
				.orElseThrow(() -> new IllegalStateException(
						"The job application does not exist"
				));
		appliedJobRepository.delete(appliedJobModel);
		return appliedJobModel.toString();

	}
}
