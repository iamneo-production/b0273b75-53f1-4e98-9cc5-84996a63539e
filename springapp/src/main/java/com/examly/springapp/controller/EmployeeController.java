package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.exception.RecordNotFoundException;
import com.examly.springapp.repository.EmployeeRepository;
import com.examly.springapp.model.EmployeeModel;

@RestController
@RequestMapping("/admin")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/")
	public List<EmployeeModel> getEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") String id)
			throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this empid :: " + id));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/add")
	public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeModel> editEmployee(@PathVariable(value = "id") String id,
			@RequestBody EmployeeModel employeeDetails) throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + id));

		employee.setEmpId(employeeDetails.getEmpId());
	    employee.setEmail(employeeDetails.getEmail());
        employee.setMobileNumber(employeeDetails.getMobileNumber());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());
        employee.setDepartment(employeeDetails.getDepartment());
		final EmployeeModel editEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(editEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String id)
			throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + id));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}