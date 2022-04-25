package com.gl.EmployeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.gl.EmployeeManagement.entity.Employee;
import com.gl.EmployeeManagement.entity.Users;
import com.gl.EmployeeManagement.entity.Role;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);	
	
	public List<Employee> searchByFirstName(String firstName);	

	List<Employee> findAllCustomSorted(Direction direction);
	
	public Users saveUser(Users user);
	public Role saveRole(Role role);
}
