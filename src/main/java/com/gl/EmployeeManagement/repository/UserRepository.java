package com.gl.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.EmployeeManagement.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	// Spring data jpa query - jpql
    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    public Users getUserByUsername(String username);   
}
