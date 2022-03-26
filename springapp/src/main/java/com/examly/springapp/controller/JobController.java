package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examly.springapp.repository.JobRepository;
@Controller
public class JobController {
    @Autowired
	private JobRepository jobRepository;
	@RequestMapping(path="/home")
	public @ResponseBody String getAllJObs() {
		return jobRepository.findAll().toString();
	}
}
