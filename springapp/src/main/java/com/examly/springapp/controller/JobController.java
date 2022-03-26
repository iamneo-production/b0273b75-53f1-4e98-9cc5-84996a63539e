package com.examly.springapp.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examly.springapp.model.JobModel;
import com.examly.springapp.repository.JobRepository;
@Controller
public class JobController {
    @Autowired
	private JobRepository jobRepository;
	@RequestMapping(path="/home")
	@ResponseBody
	public String getAllJObs() {
		return jobRepository.findAll().toString();

	}
	
	
}

