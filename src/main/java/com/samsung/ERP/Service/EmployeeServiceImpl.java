package com.samsung.ERP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.ERP.Domain.Employee;
import com.samsung.ERP.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int id) {
			return this.employeeRepository.findById(id).get();
     }

	@Override
	public Employee updateEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(int empId) {
	 this.employeeRepository.deleteById(empId);
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return this.employeeRepository.findByEmpName(name);
	}

}
