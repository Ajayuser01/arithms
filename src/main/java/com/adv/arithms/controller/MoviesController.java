package com.adv.arithms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.dto.MoviesDto;
import com.adv.arithms.service.MoviesService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MoviesController {
	
	private Logger log=LogManager.getLogger(MoviesController.class);

	@Autowired
	@Qualifier(value = "moviesServiceImpl")
	private MoviesService moviesService;

	@GetMapping(value = "/movies")
	public ResponseEntity<MoviesDto[]> getMovies() {
		MoviesDto[] mv=moviesService.getMovies();
		log.info(mv);
		return new ResponseEntity<MoviesDto[]>(mv, HttpStatus.OK);
	}
}
