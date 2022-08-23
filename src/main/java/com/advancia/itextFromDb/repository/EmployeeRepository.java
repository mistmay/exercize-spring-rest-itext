package com.advancia.itextFromDb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advancia.itextFromDb.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByAge(Integer age);
}
