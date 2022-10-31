package com.adv.arithms.service;



public interface PatternService {
	
			public String upwardRightSlope(int patternCount,String printOn);
			
			public String upwardLeftSlope(int patternCount, String printOn);
			
			public String upwardTriangle(int patternCount, String printOn);

			public String downwardTriangle(int patternCount, String printOn);
			
			public String rightPyramid(int patternCount, String printOn);
			
			public String diamond(int patternCount, String printOn);
			
			public String hollowDiamond(int patternCount, String printOn);
}
