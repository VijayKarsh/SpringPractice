package com.techment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.techment.modal.Course;
import com.techment.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	@GetMapping("/courses")
	public List<Course>list() {
		return service.listAll();
		
	}
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course>get(@PathVariable int id){
		try {
			Course c =service.get(id);
			return new ResponseEntity<Course>(c,HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("add")
	public void add(@RequestBody Course course) {
		service.save(course);
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Course course,@PathVariable int id) {
		try {
			//if the course already exists, update it
			Course c =service.get(id);
			service.save(course);
			return "course updated";
		}catch (NoSuchElementException e) {
			return "Not a valid course id";
		}
	}
	
}
