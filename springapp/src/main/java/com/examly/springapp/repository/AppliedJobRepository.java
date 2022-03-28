package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.AppliedJobModel;
import com.examly.springapp.model.JobModel;
import org.springframework.data.jpa.repository.Query;

public interface AppliedJobRepository extends JpaRepository<AppliedJobModel, Long>{

	List<AppliedJobModel> findByEmployeeId(String employeeId);

	@Query("SELECT j FROM AppliedJobModel j WHERE employeeId=employeeId AND jobId=jobId")
	Optional<AppliedJobModel> findAppliedJob(String employeeId, Long jobId);

	
}
