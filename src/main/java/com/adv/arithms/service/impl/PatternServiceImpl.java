package com.adv.arithms.service.impl;

import org.springframework.stereotype.Service;

import com.adv.arithms.service.PatternService;

@Service(value = "patternServiceImpl")
public class PatternServiceImpl implements PatternService {

	@Override
	public String starOne(int patternCount, String printOn) {
		String pattern = " ";
		for (int i = 0; i <= patternCount; i++) {
			for (int j = 1; j <= i; j++) {
				pattern += " *";
			}
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		return pattern;
	}

	@Override
	public String starTwo(int patternCount, String printOn) {
		String pattern = "";
		for (int i = 0; i <= patternCount; i++) {
			for (int j = i; j <= patternCount; j++) {
				pattern += "* ";
			}
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		return pattern;
	}

	@Override
	public String starThree(int patternCount, String printOn) {
		String pattern = "";
		for (int i = 0; i < patternCount; i++) {
			for (int j = patternCount - i; j > 0; j--) {
				pattern += " ";
			}
			for (int j = 0; j <= i; j++) {
				pattern += " * ";
			}
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		return pattern;
	}

	@Override
	public String starFour(int patternCount, String printOn) {
		String pattern = "";
		for (int i = patternCount; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				pattern += " * ";
			}
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
			for (int k = patternCount; k >= i; k--) {
				pattern += " ";
			}
		}
		return pattern;
	}

	@Override
	public String starFive(int patternCount, String printOn) {
		String pattern = "";
		for (int i = 0; i <= patternCount; i++) {
			for (int j = 1; j <= i; j++) {
//				System.out.print("* ");
				pattern += "* ";
			}
//			System.out.println();
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		for (int i = patternCount - 1; i >= 0; i--) {
			for (int j = i; j >= 1; j--) {
//				System.out.print("* ");
				pattern += "* ";
			}
//			System.out.println();
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		return pattern;
	}
}
