package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.JobModel;


@Repository
public interface JobRepository extends JpaRepository<JobModel, String>{

}
