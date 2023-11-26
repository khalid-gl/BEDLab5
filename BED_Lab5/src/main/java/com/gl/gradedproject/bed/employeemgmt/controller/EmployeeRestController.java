package com.gl.gradedproject.bed.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.gradedproject.bed.employeemgmt.entity.Employee;
import com.gl.gradedproject.bed.employeemgmt.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/sortedList")
	public List<Employee> getAllSortedEmployees(@RequestParam("sortDirection") String sortDirection) {
		if (sortDirection.equalsIgnoreCase("ASC")) {
			return employeeService.getAllEmployeesSortedByFirstName("firstName", Direction.ASC);
		} else {
			return employeeService.getAllEmployeesSortedByFirstName("firstName", Direction.DESC);
		}
	}

	@GetMapping("/search")
	public List<Employee> searchEmployeesByFirstName(@RequestParam("firstName") String firstName) {
		return employeeService.searchEmployeeByFirstName(firstName);
	}

	@GetMapping("/id/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveOrUpdate(employee);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.getEmployeeById(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		return employeeService.saveOrUpdate(emp);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<String> deleteEmployee(@RequestBody Long id) {
		employeeService.delete(id);
		return new ResponseEntity<String>("Deleted employee with id: " + id, HttpStatus.OK);
	}
}
