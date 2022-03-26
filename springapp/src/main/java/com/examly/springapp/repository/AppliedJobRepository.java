package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.AppliedJobModel;
import com.examly.springapp.model.JobModel;

public interface AppliedJobRepository extends JpaRepository<AppliedJobModel, Long>{

	List<AppliedJobModel> findByEmployeeId(String employeeId);

	
}
