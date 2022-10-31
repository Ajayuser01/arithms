package com.adv.arithms.service.impl;

import org.springframework.stereotype.Service;

import com.adv.arithms.service.ArrayService;
@Service(value = "arrayServiceImpl")
public class ArrayServiceImpl implements ArrayService {
	
	 public Integer[] oneToHundred(int arrPr) {
		 Integer val[]=new Integer[arrPr];
			for (int i = 0; i < val.length; i++) {
			 val[i]=i+1;
			}
			return val;
		    }
	 
}
