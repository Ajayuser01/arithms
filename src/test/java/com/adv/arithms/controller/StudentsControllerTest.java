package com.adv.arithms.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.adv.arithms.dto.StudentDto;
import com.adv.arithms.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class StudentsControllerTest {

	private StudentDto dto = null;

	@Before
	public void init() {
		System.out.println("inside the init");
		dto = new StudentDto();
	}

	@After
	public void initDestroy() {
		System.out.println("init is destoryed");
		dto = null;
	}

	@InjectMocks
	private StudentsController studentController;

	@Mock
	private StudentService studentService;

	@Test
	public void testCreateStudent() {
		doNothing().when(studentService).createStudent(dto);
		ResponseEntity<Void> responseEntity = studentController.createStudent(dto);
		assertEquals(201, responseEntity.getStatusCode().value());
	}
}
