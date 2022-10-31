package com.adv.arithms.controller;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.dto.StudentDto;
import com.adv.arithms.service.StudentService;

@RestController
public class StudentsController {

	private Logger logger = LogManager.getLogger(StudentsController.class);
	@Autowired
	@Qualifier(value = "studentsServiceImpl")
	private StudentService studentService;

	@GetMapping(value = "/students")
	public ResponseEntity<StudentDto[]> getStudents() {
		logger.info("Show all Students :: "+studentService.getStudents());
		return new ResponseEntity<StudentDto[]>(studentService.getStudents(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/students/{studentid}")
	public ResponseEntity<StudentDto> getParticularStudent(@PathVariable(value = "studentid") int studentId) {
		logger.info("studentid="+studentId);
		StudentDto studentDto = studentService.getParticularStudent(studentId);
		return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/students")
	public ResponseEntity<Void> createStudent(@RequestBody StudentDto studentDto) {
		studentService.createStudent(studentDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@PutMapping(value = "/students/{studentid}")
	public ResponseEntity<Void> updateStudent(@PathVariable(value = "studentid") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.updateStudent(studentId, studentDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PatchMapping(value = "/students/{studentid}")
	public ResponseEntity<Void> selUpdStudent(@PathVariable(value = "studentid") int studentId,
			@RequestBody StudentDto studentDto) {
		studentService.selUpdStudent(studentId, studentDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/students/{studentid}")
	public ResponseEntity<Void> DeleteStudent(@PathVariable(value = "studentid") int studentId) {
		studentService.DeleteStudent(studentId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
