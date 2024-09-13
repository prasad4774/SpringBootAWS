package com.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aws.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
