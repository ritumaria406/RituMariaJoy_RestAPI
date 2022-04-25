package com.gl.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.EmployeeManagement.entity.Users;
import com.gl.EmployeeManagement.repository.UserRepository;
import com.gl.EmployeeManagement.security.MyUserDetails;

// This will be used by Spring Security to get details of a user who is trying to login to the app
// Therefore we need to write this method in a way that Spring Security expects
public class UserDetailsServiceImpl implements UserDetailsService{

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        Users user = userRepository.getUserByUsername(username);
	         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new MyUserDetails(user);
	    }

}