package com.gl.EmployeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
    @Column(name = "role_id")   
    private Integer id;

    @Column(name="name")
    private String name; 
     
    
}