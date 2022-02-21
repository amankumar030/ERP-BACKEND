package com.samsung.ERP.Service;

import java.util.List;

import com.samsung.ERP.Domain.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(int empId);
	public Employee addEmployee(Employee employee);
	public List<Employee> getEmployeeByName(String Name);

}
