package com.helloworld.Springbootcode.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.Springbootcode.entity.Department;
import com.helloworld.Springbootcode.error.DepartmentNotFoundException;
import com.helloworld.Springbootcode.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	//Logger used here
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class); 
	
	//POST API
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	//GET API
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	//GET API
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetchDepartmentById of DepartmentController");
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	//DELETE API
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		LOGGER.info("Inside deleteDepartmentById of DepartmentController");
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted Successfully!!";
	}
	
	//PUT API
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		LOGGER.info("Inside updateDepartment of DepartmentController");
		return departmentService.updateDepartment(departmentId,department);
	}
	
	//GET API
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
		return departmentService.fetchDepartmentByName(departmentName);
	}
	
	

}
