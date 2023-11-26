package com.gl.gradedproject.bed.employeemgmt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.gradedproject.bed.employeemgmt.entity.Employee;
import com.gl.gradedproject.bed.employeemgmt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployeesSortedByFirstName(String sortBy, Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, sortBy));
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> searchEmployeeByFirstName(String firstName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> from = cq.from(Employee.class);
		cq.select(from).where(cb.equal(from.get("firstName"), firstName));
		TypedQuery<Employee> tq = entityManager.createQuery(cq);
		return tq.getResultList();
	}

}
