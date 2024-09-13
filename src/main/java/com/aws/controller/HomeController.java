package com.aws.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.entity.Student;
import com.aws.repository.StudentRepository;

@RestController
public class HomeController {
	
	
	@Autowired
	private  StudentRepository repository;

	@GetMapping("/")
	public String getStudent()
	{
		
		return "s";
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Student s )
	{
		System.out.println(s.getId());
            Optional<Student> byId = repository.findById(s.getId());
            System.out.println(byId);
            
            if(!byId.isPresent())
            {
            	repository.save(s);
            	return new ResponseEntity<>(HttpStatus.CREATED);
            	
            }else
            {
            return new ResponseEntity<>(HttpStatus.CONFLICT);	
            }
		
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<?> get()
	{
		
		List<Student> list = repository.findAll();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	
	
}
