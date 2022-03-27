package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

	@GetMapping("/admin/")
	public List<EmployeeModel> getEmployee() {
		return employeeRepository.findAll();
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") String empId)
			throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this empid :: " + empId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/admin/add")
	public EmployeeModel saveEmployee(@Valid @RequestBody EmployeeModel employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/admin/update/{id}")
	public ResponseEntity<EmployeeModel> editEmployee(@PathVariable(value = "id") String empId,
			@Valid @RequestBody EmployeeModel employeeDetails) throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + empId));

		employee.setEmail(employeeDetails.getEmail());
		employee.setName(employeeDetails.getName());
        employee.setMobileNumber(employeeDetails.getMobileNumber());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRole(employeeDetails.getRole());
        employee.setDeartment(employeeDetails.getDepartment());
		final EmployeeModel editEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(editEmployee);
	}

	@DeleteMapping("/admin/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long empId)
			throws RecordNotFoundException {
		EmployeeModel employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + empId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}