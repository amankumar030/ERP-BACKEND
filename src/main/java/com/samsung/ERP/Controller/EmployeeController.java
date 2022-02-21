package com.samsung.ERP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.ERP.Domain.Employee;
import com.samsung.ERP.Service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	  @Autowired
	  EmployeeServiceImpl employeeService;
	  
	  @GetMapping("/employee")
      public  ResponseEntity<List<Employee>> getAllEmployee()
      {
    	 List<Employee> allEmployee=this.employeeService.getAllEmployee();
    	 return ResponseEntity.ok(allEmployee);
      }
	  
	  @GetMapping("/employee/{id}")
	  public ResponseEntity<Employee> getEmployee(@PathVariable String id)
	  { 
		  try {
			  Employee emp=this.employeeService.getEmployee(Integer.parseInt(id));
			  return ResponseEntity.ok(emp);
		  }
		  catch(Exception exception)
		  {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		  }
		  
	  }
	  
	  @GetMapping("/employee/name/{name}")
	  public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name)
	  { 

	     List<Employee> emp=this.employeeService.getEmployeeByName(name);
	     return ResponseEntity.ok(emp);
      }
	  @PostMapping("/employee")
	  public void addEmployee(@RequestBody Employee employee)
	  {
		 this.employeeService.addEmployee(employee);
	  }
	  
	  @PutMapping("/employee")
	  public void updateEmployee(@RequestBody Employee employee)
	  {
		 this.employeeService.updateEmployee(employee);
	  }
	  
	  @DeleteMapping("/employee/{empId}")
	  public  ResponseEntity<Employee> deleteEmployee(@PathVariable String empId)
	  {
		  Employee emp= this.employeeService.getEmployee(Integer.parseInt(empId));
		  if(emp==null)
		  {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		  }
		  else
		  {
			  this.employeeService.deleteEmployee(Integer.parseInt(empId));
			  return ResponseEntity.ok(emp);
		  }
			  
	  }
	  
	  
	 
}
