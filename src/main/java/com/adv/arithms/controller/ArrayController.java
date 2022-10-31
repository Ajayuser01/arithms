package com.adv.arithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.service.ArrayService;

@RestController
public class ArrayController {

	@Autowired

	@Qualifier(value = "arrayServiceImpl")
	ArrayService arrayService;

	@GetMapping(value = "array")
	public ResponseEntity<Integer[]> arOne(@RequestParam(value = "numin") int num) {
		Integer[] arrVal = arrayService.oneToHundred(num);
		return new ResponseEntity<>(arrVal, HttpStatus.OK);
	}

}
