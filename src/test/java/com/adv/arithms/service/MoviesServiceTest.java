package com.adv.arithms.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import com.adv.arithms.dto.MoviesDto;
import com.adv.arithms.service.impl.MoviesServiceImpl;

public class MoviesServiceTest {

	MoviesService md=new MoviesServiceImpl();
	MoviesDto[] moviesDtos=md.getMovies();
	
	@Test
	public void moviesIdTest() {
		int[] actualValue= {moviesDtos[0].getId(),moviesDtos[1].getId()};
		int[] expectedValue= {1,2};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void moviesTest() {
		String[] actualValue= {moviesDtos[0].getName(),moviesDtos[1].getName()};
		String[] expectedValue= {"Nane Varuven","Master"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void moviesDirectorTest() {
		String[] actualValue= {moviesDtos[0].getDirector(),moviesDtos[1].getDirector()};
		String[] expectedValue= {"Selva Raghavan","Lokesh Kanagaraj"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void moviesGenreTest() {
		String[] actualValue= {moviesDtos[0].getGenre(),moviesDtos[1].getGenre()};
		String[] expectedValue= {"Thriller","Action"};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void moviesReleasedYearTest() {
		int[] actualValue= {moviesDtos[0].getReleasedYear(),moviesDtos[1].getReleasedYear()};
		int[] expectedValue= {2022,2021};
		assertArrayEquals(actualValue, expectedValue);
	}
	
	@Test
	public void moviesIdExceptionTest() {
		int[] actualValue= {moviesDtos[0].getId(),moviesDtos[1].getId()};
		int[] expectedValue= {1,2};
		assertArrayEquals(actualValue, expectedValue);
	}
}
