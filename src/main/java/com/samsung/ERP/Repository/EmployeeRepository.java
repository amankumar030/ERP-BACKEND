package com.samsung.ERP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsung.ERP.Domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
           public List<Employee> findByEmpName(String empName);
}
