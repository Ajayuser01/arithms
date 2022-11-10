package com.adv.arithms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adv.arithms.dto.StringCharDTO;
import com.adv.arithms.service.StringExerciseService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StringExerciseController {

@Autowired
@Qualifier("StringExerciseServiceImpl")

private StringExerciseService exerciseService;

@GetMapping(value = "/revString")
public ResponseEntity<String> revString(@RequestParam(value = "revstring") String revString) {
	String revStringVal = exerciseService.reverseString(revString);
	return new ResponseEntity<>(revStringVal, HttpStatus.OK);
}

@GetMapping(value = "/lenString")
public ResponseEntity<String> lengthString(@RequestParam(value = "intring") String inString) {
	String lenStringVal = exerciseService.lengthString(inString);
	return new ResponseEntity<>(lenStringVal, HttpStatus.OK);
}

@GetMapping(value = "/CountString")
public ResponseEntity<StringCharDTO[]> countString(@RequestParam(value = "intring") String inString) {
	StringCharDTO[] charDto = exerciseService.countStr(inString);
	return new ResponseEntity<StringCharDTO[]>(charDto, HttpStatus.OK);
}

}
