package com.gl.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.EmployeeManagement.entity.Employee;
import com.gl.EmployeeManagement.entity.Role;
import com.gl.EmployeeManagement.entity.Users;
import com.gl.EmployeeManagement.repository.EmployeeRepository;
import com.gl.EmployeeManagement.repository.RoleRepository;
import com.gl.EmployeeManagement.repository.UserRepository;
import com.gl.EmployeeManagement.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(theId).get();
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
		
	}	
	
	@Override
	public List<Employee> findAllCustomSorted(Direction direction) {
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

}
