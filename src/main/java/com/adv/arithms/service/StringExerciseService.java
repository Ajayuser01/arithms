package com.adv.arithms.service;

import com.adv.arithms.dto.StringCharDTO;

public interface StringExerciseService {
	
	public String reverseString(String str) ;
	
	public String lengthString(String str) ;
	
	public StringCharDTO[] countStr(String str);
	

}
