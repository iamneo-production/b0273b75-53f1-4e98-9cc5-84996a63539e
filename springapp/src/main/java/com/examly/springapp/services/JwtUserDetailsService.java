package com.examly.springapp.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.JwtPayload;
import com.examly.springapp.model.login;
import com.examly.springapp.repository.AppliedJobRepository;
import com.examly.springapp.repository.LoginRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	public static class LoginPayLoad{
		String username;
		String password;
	}
	 @Autowired
	private LoginRepo loginRepo;
	public UserDetails loadUserByUsername(JwtPayload ajp) throws UsernameNotFoundException {
		System.out.print("fuck you");
		
		 Optional<login> lo = loginRepo.findByUsername(ajp.username);
		if (lo.isPresent()) {
			login log = lo.get();
			if (log.getPassword().equals(ajp.password)) {
				return new User(log.getUsername(), log.getPassword(), new ArrayList<>());
			}
			throw new UsernameNotFoundException("Password invalid");
		} else {
			throw new UsernameNotFoundException("No username found");
		}
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
