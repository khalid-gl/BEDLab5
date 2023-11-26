package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.Employee;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();

	List<Employee> getAllEmployeesSortedByFirstName(String sortBy, Direction direction);

	Employee getEmployeeById(Long id);

	List<Employee> searchEmployeeByFirstName(String firstName);

	Employee saveOrUpdate(Employee employee);

	void delete(Long id);

}
