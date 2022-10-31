package com.adv.arithms.service;

import com.adv.arithms.dto.StudentDto;

public interface StudentService {

	public StudentDto[] getStudents();
	
	public StudentDto getParticularStudent(int studentId);
	
	public void createStudent(StudentDto studentDto);
	
	public void updateStudent(int studentId, StudentDto studentDto);
	
	public void selUpdStudent(int studentId, StudentDto studentDto);
	
	public void DeleteStudent(int studentId);
}
