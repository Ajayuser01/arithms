package com.adv.arithms.service.impl;

import org.springframework.stereotype.Service;

import com.adv.arithms.dto.StringCharDTO;
import com.adv.arithms.service.StringExerciseService;

@Service(value = "StringExerciseServiceImpl")
public class StringExerciseServiceImpl implements StringExerciseService {

	@Override
	public String reverseString(String str) {
		String revArr = "";
		char[] ch = str.toCharArray();
		for (int i = ch.length; i > 0; i--) {
			revArr += ch[i - 1];
		}
		System.out.println(revArr);
		return revArr;
	}

	@Override
	public String lengthString(String str) {
		String count = "The Length of the String  " + str + " is " + str.length();
		return count;
	}

	@Override
	public StringCharDTO[] countStr(String str) {
		int count = 0;
		char[] charArray = str.toCharArray();
		char[] array = new char[charArray.length];
		int[] arrayCount = new int[charArray.length];
		boolean flag = false;
		int arrayIndex = 0;
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i; j < charArray.length; j++) {
				if ((charArray[i] == charArray[j])) {
					count++;
					flag = false;
					for (int k = 0; k < array.length; k++) {
						if (charArray[i] == array[k])
							flag = true;
					}
				}
			}
			if (!flag) {
				array[arrayIndex] = charArray[i];
				arrayCount[arrayIndex] = count;
				arrayIndex++;
			}
			count = 0;
		}

		StringCharDTO charDto[] = new StringCharDTO[arrayCount.length];
		for (int i = 0; i < arrayCount.length; i++) {
			if (Character.isLetter(array[i])) {
				StringCharDTO noOfChar = new StringCharDTO();
				noOfChar.setCount(arrayCount[i]);
				noOfChar.setCharacter(array[i]);
				charDto[i]=noOfChar;
			}
		}
		return charDto;
	}


}
