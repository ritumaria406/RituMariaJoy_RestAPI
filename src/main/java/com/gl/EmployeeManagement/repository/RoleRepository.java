package com.gl.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.EmployeeManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
