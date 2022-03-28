package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.EmployeeModel;
 
@Repository
public interface EmployeeRepository
        extends JpaRepository<EmployeeModel, String> {
 
}