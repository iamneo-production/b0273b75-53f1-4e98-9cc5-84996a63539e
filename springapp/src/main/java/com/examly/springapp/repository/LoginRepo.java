package com.examly.springapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.AppliedJobModel;
import com.examly.springapp.model.login;
@Repository
public interface LoginRepo extends JpaRepository<login, Long> {
	Optional<login> findByUsername(String username);
	
}
