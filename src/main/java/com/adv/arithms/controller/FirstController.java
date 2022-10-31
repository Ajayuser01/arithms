package com.adv.arithms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.dto.FirstDTO;

@RestController
public class FirstController {

	private Logger LOGGER = LogManager.getLogger(FirstController.class);

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(
					"Welcome to micro services . . .", HttpStatus.OK);
		LOGGER.info(responseEntity);
		return responseEntity;
	}

	@GetMapping("/welcome/param")
	public ResponseEntity<String> welParam(@RequestParam(value = "firstname") String firstName,
				@RequestParam(value = "lastname") String lastName) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(
					"Welcome " + firstName + " " + lastName + " to micro services ", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/welcome/path/{firstname}/{lastname}")
	public ResponseEntity<String> welParamVarPath(
				@PathVariable(value = "firstname") String firstName,
				@PathVariable(value = "lastname") String lastName) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(
					"Welcome " + firstName + " " + lastName + " to micro services ", HttpStatus.OK);
		LOGGER.info(responseEntity);
		return responseEntity;
	}

	@PostMapping("/postname")
	public ResponseEntity<Void> setNameWithPost(@RequestBody FirstDTO firstDto) {
		String message = "welcome " + firstDto.getFirstName() + " " + firstDto.getLastName()
					+ " to microservice";
		System.out.println(message);
		LOGGER.info(message);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
		return responseEntity;

	}
}
