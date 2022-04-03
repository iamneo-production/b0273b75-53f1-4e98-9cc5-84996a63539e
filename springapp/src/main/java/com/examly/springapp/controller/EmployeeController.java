package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.exception.RecordNotFoundException;
import com.examly.springapp.repository.EmployeeRepository;
import com.examly.springapp.model.EmployeeModel;

@RestController
@RequestMapping("/admin")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/")
	public ResponseEntity<List<EmployeeModel>> getEmployee() {
		try{
			return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") long employeeId) {
        try {
            //check if employee exist in database
            EmployeeModel empObj = getEmpRec(employeeId);

            if (empObj != null) {
                return new ResponseEntity<>(empObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/add")
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmployee = employeeRepository
                .save(EmployeeModel.builder()
                        .empId(employee.getEmpId())
                        .email(employee.getEmail())
						.mobileNumber(employee.getMobileNumber())
						.department(employee.getDepartment())
						.role(employee.getRole())
						.password(employee.getPassword())
                        .build());
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel> editEmployee(@PathVariable("id") long employeeId, @RequestBody EmployeeModel employee) {

        //check if employee exist in database
        EmployeeModel empObj = getEmpRec(employeeId);

        if (empObj != null) {
            empObj.setEmpId(employee.getEmpId());
			empObj.setEmail(employee.getEmail());
			empObj.setMobileNumber(employee.getMobileNumber());
			empObj.setDepartment(employee.getDepartment());
            empObj.setRole(employee.getRole());
			empObj.setPassword(employee.getPassword());
            return new ResponseEntity<>(employeeRepository.save(empObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long employeeId) {
        try {
            //check if employee exist in database
            EmployeeModel emp = getEmpRec(employeeId);

            if (emp != null) {
                employeeRepository.deleteById(employeeId);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private EmployeeModel getEmpRec(long employeeId) {
        Optional<EmployeeModel> empObj = employeeRepository.findById(employeeId);

        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }
}
