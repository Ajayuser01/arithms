package com.adv.arithms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.service.PatternService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PatternController {

	private  Logger LOGGER = LogManager.getLogger(FirstController.class);
	
	@Autowired

	@Qualifier(value = "patternServiceImpl")
	private PatternService patternService;

	@GetMapping(value = "/starone")
	public ResponseEntity<String> starOnes(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.upwardRightSlope(patternCount, printOn);
		LOGGER.info(strpattern);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}

	@GetMapping(value = "/startwo")
	public ResponseEntity<String> starTwo(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.upwardLeftSlope(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starthree")
	public ResponseEntity<String> starThree(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.upwardTriangle(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starfour")
	public ResponseEntity<String> starFour(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.downwardTriangle(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starfive")
	public ResponseEntity<String> starFive(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.rightPyramid(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starsix")
	public ResponseEntity<String> starSix(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.diamond(patternCount, printOn);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
	
	@GetMapping(value = "/starseven")
	public ResponseEntity<String> starSeven(@RequestParam(value = "patterncount") int patternCount,
				@RequestParam(value = "printon") String printOn) {
		String strpattern = patternService.hollowDiamond(patternCount, printOn);
		LOGGER.info(strpattern);
		return new ResponseEntity<>(strpattern, HttpStatus.OK);
	}
}
