package com.gl.EmployeeManagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.EmployeeManagement.service.EmployeeService;
import com.gl.EmployeeManagement.entity.Employee;
import com.gl.EmployeeManagement.service.*;
import com.gl.EmployeeManagement.entity.Role;
import com.gl.EmployeeManagement.entity.Users;
import org.springframework.data.domain.Sort.Direction;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/user")
	public Users saveUser(@RequestBody Users user) {
		return employeeService.saveUser(user);
	}

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return employeeService.saveRole(role);
	}
	
	// expose "/employees" and return list of employees
		@GetMapping("/employees")
		public List<Employee> findAll() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
			System.out.println(currentPrincipalName);
			return employeeService.findAll();
		}

		// add mapping for GET /employees/{employeeId}

		@GetMapping("/employees/{employeeId}")
		public Employee getEmployee(@PathVariable int employeeId) {

			Employee theEmployee = employeeService.findById(employeeId);

			if (theEmployee == null) {
				throw new RuntimeException("Employee id not found - " + employeeId);
			}

			return theEmployee;
		}

	
	@PostMapping("/employees")
	public Employee saveBook(@RequestBody Employee theEmployee) {
	
				theEmployee.setId(0);
				employeeService.save(theEmployee);
				return theEmployee;	
	}
	

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		employeeService.save(theEmployee);

		return theEmployee;
	}
	
	
	@DeleteMapping("/employees/{employeeId}")

	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = employeeService.findById(employeeId);

		// throw exception if null

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}

	@GetMapping("/employees/sort")
	public List<Employee> sortByFirstName(@RequestParam Direction order) {
		return employeeService.findAllCustomSorted(order);
	}
	
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}
}
