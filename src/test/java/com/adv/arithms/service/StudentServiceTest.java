package com.adv.arithms.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.adv.arithms.dto.StudentDto;
import com.adv.arithms.service.impl.StudentServiceImpl;

public class StudentServiceTest {
	
	StudentService md=new StudentServiceImpl();
	StudentDto[] studentsDtos=md.getStudents();
	
	@Test
	public void StudentIdTest() {
		int[] actualValue= {studentsDtos[0].getId(),studentsDtos[1].getId()};
		int[] expectedValue= {1,2};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentNameTest() {
		String[] actualValue= {studentsDtos[0].getName(),studentsDtos[1].getName()};
		String[] expectedValue= {"anbu","guru"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSectionTest() {
		String[] actualValue= {studentsDtos[0].getSection(),studentsDtos[1].getSection()};
		String[] expectedValue= {"B","C"};
		assertArrayEquals(actualValue, expectedValue);
	}
	

	@Test
	public void StudentStandardTest() {
		String[] actualValue= {studentsDtos[0].getStandard(),studentsDtos[1].getStandard()};
		String[] expectedValue= {"12th","11th"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentmobileTest() {
		String[] actualValue= {studentsDtos[0].getMobile(),studentsDtos[1].getMobile()};
		String[] expectedValue= {"897535677","989898777"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSingleIdTest() {
		int actualValue= md.getParticularStudent(1).getId();
		int expectedValue= 1;
		assertEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSingleNameTest() {
		String actualValue= md.getParticularStudent(1).getName();
		String expectedValue= "anbu";
		assertEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSingleSectionTest() {
		String actualValue= md.getParticularStudent(1).getSection();
		String expectedValue= "B";
		assertEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSingleStandardTest() {
		String actualValue= md.getParticularStudent(1).getStandard();
		String expectedValue= "12th";
		assertEquals(actualValue, expectedValue);
	}
	
	@Test
	public void StudentSingleMobileTest() {
		String actualValue= md.getParticularStudent(1).getMobile();
		String expectedValue= "897535677";
		assertEquals(actualValue, expectedValue);
	}
	
}
