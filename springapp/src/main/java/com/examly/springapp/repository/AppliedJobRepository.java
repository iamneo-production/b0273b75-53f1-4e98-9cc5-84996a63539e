package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.AppliedJobModel;

public interface AppliedJobRepository extends JpaRepository<AppliedJobModel, Long>{

	
}
