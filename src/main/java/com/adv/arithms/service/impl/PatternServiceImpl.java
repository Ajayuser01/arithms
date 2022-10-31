package com.adv.arithms.service.impl;

import org.springframework.stereotype.Service;

import com.adv.arithms.service.PatternService;

@Service(value = "patternServiceImpl")
public class PatternServiceImpl implements PatternService {

	@Override
	public String upwardRightSlope(int patternCount, String printOn) {
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
	public String upwardLeftSlope(int patternCount, String printOn) {
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
	public String upwardTriangle(int patternCount, String printOn) {
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
	public String downwardTriangle(int patternCount, String printOn) {
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
	public String rightPyramid(int patternCount, String printOn) {
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

	@Override
	public String diamond(int patternCount, String printOn) {
		String pattern = "";
		int n;
		n = patternCount / 2;
		for (int k = 1; k <= n; k++) {
			for (int c = 1; c <= n - k; c++)
//				System.out.print(" ");
				pattern += " ";
			for (int c = 1; c <= 2 * k - 1; c++)
//				System.out.print("*");
				pattern += "*";
//			System.out.print("\n");
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		for (int k = 1; k <= n - 1; k++) {
			for (int c = 1; c <= k; c++)
//				System.out.print(" ");
				pattern += " ";
			for (int c = 1; c <= 2 * (n - k) - 1; c++)
//				System.out.print("*");
				pattern += "*";
//			System.out.print("\n");
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		return pattern;
	}

	@Override
	public String hollowDiamond(int patternCount, String printOn) {
		String pattern = "";
		for (int i = 1; i <= patternCount; i++) {
			for (int j = 1; j <= patternCount - i + 1; j++) {
//				System.out.print("*");
				pattern += "*";
			}
			// loop calculates space
			for (int k = 1; k <= 2 * i - 2; k++) {
//				System.out.print(" ");
				pattern += " ";
			}
			for (int j = 1; j <= patternCount - i + 1; j++) {
//				System.out.print("*");
				pattern += "*";
			}
//			System.out.println();
			if (printOn.equals("web")) {
				pattern += "<br>";
			} else if (printOn.equals("post"))
				pattern += "\n";
		}
		// logic to print the second half pattern
		for (int i = patternCount - 1; i >= 1; i--) {
			for (int j = i; j <= patternCount; j++) {
//				System.out.print("*");
				pattern += "*";
			}
			// loop calculates space
			for (int k = 1; k <= (2 * i) - 2; k++) {
//				System.out.print(" ");
				pattern += " ";
			}
			for (int j = i; j <= patternCount; j++) {
//				System.out.print("*");
				pattern += "*";
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
