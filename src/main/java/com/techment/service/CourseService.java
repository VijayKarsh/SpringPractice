package com.techment.service;

import java.util.List;

import com.techment.dao.CourseRepository;
import com.techment.modal.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repo;
	
	public List<Course> listAll(){
		return repo.findAll();
	}
	
	public void save(Course course) {
		repo.save(course);
	}
	public Course get(int id) {
		return repo.findById(id).get();
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
