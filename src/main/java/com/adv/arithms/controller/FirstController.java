package com.adv.arithms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@GetMapping("/hello")
	public ResponseEntity<String> helloworld() {
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Welcome to micro services",HttpStatus.OK);
		return responseEntity;
	}
}
