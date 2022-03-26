package com.rodarte.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodarte.crm.model.Student;

@Repository	
public interface StudentRepository extends JpaRepository<Student, Long>
{
}