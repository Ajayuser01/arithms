package com.adv.arithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.service.PatternService;

@RestController
public class PatternController {

	@Autowired

	@Qualifier(value = "patternServiceImpl")
	private PatternService patternService;

	@GetMapping(value = "/starone")
	public ResponseEntity<String> starOnes(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.starOne(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}

	@GetMapping(value = "/startwo")
	public ResponseEntity<String> starTwo(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.starTwo(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starthree")
	public ResponseEntity<String> starThree(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.starThree(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starfour")
	public ResponseEntity<String> starFour(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.starFour(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starfive")
	public ResponseEntity<String> starFive(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.starFive(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
}
