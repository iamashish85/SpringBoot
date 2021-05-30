package com.howtodoinjava.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.rest.entity.Employee;
import com.howtodoinjava.rest.repository.EmployeeRepository;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(path = "/addEmployee")
	public ResponseEntity<HttpStatus> addEmployee(@RequestBody Employee employee) throws Exception {
		// add resource
		employeeRepository.save(employee);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping(path = "/addAllEmployee")
	public ResponseEntity<HttpStatus> addAllEmployee(@RequestBody List<Employee> employee) throws Exception {
		// add resource
		employeeRepository.saveAll(employee);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(path = "/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Long id) throws Exception {
		// add resource
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();
	}

	@GetMapping(path = "/getAllEmployee")
	public List<Employee> getAllEmployee() throws Exception {
		// add resource
		return employeeRepository.findAll();
	}

	@PutMapping(path = "/updateEmployee")
	public ResponseEntity<HttpStatus> updateEmployee(@RequestBody Employee employee) throws Exception {
		// add resource
		employeeRepository.save(employee);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
