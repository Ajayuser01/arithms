package com.adv.arithms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.adv.arithms.service.impl.PatternServiceImpl;

public class PatternServiceTest {

	PatternService patternService = new PatternServiceImpl();

	@Test
	public void starOneTest() {
		String actualValue = patternService.upwardRightSlope(3, "post");
		System.out.println(actualValue);
		String expectedValue = " \n" + " *\n" + " * *\n" + " * * *" + "\n";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starOneWebTest() {
		String actualValue = patternService.upwardRightSlope(3, "web");
		System.out.println(actualValue);
		String expectedValue = " <br> *<br> * *<br> * * *<br>";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starTwoTest() {
		String actualValue = patternService.upwardLeftSlope(3, "post");
		System.out.println(actualValue);
		String expectedValue = "* * * * \n* * * \n* * \n* \n";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starTwoWebTest() {
		String actualValue = patternService.upwardLeftSlope(3, "web");
		System.out.println(actualValue);
		String expectedValue = "* * * * <br>* * * <br>* * <br>* <br>";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starThreeTest() {
		String actualValue = patternService.upwardTriangle(3, "post");
		System.out.println(actualValue);
		String expectedValue = "    * \n" + "   *  * \n" + "  *  *  * \n";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starThreeWebTest() {
		String actualValue = patternService.upwardTriangle(3, "web");
		System.out.println(actualValue);
		String expectedValue = "    * <br>" + "   *  * <br>" + "  *  *  * <br>";
		assertEquals(actualValue, expectedValue);

	}

	@Test
	public void starFourTest() {
		String actualValue = patternService.downwardTriangle(3, "post");
		System.out.println(actualValue);
		String expectedValue = " *  *  * \n" + "  *  * \n" + "   * \n   ";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starFourWebTest() {
		String actualValue = patternService.downwardTriangle(3, "web");
		System.out.println(actualValue);
		String expectedValue = " *  *  * <br>" + "  *  * <br>" + "   * <br>   ";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starFiveTest() {
		String actualValue = patternService.rightPyramid(3, "post");
		System.out.println(actualValue);
		String expectedValue = "\n* \n* * \n* * * \n* * \n* \n\n";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starFiveWebTest() {
		String actualValue = patternService.rightPyramid(3, "web");
		System.out.println(actualValue);
		String expectedValue = "<br>* <br>* * <br>* * * <br>* * <br>* <br><br>";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starSixTest() {
		String actualValue = patternService.diamond(6, "post");
		System.out.println(actualValue);
		String expectedValue = "  *\n" + " ***\n" + "*****\n" + " ***\n" + "  *\n";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starSixWebTest() {
		String actualValue = patternService.diamond(6, "web");
		System.out.println(actualValue);
		String expectedValue = "  *<br>" + " ***<br>" + "*****<br>" + " ***<br>" + "  *<br>";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starSevenTest() {
		String actualValue = patternService.hollowDiamond(6, "post");
		System.out.println(actualValue);
		String expectedValue = "************\n" + "*****  *****\n" + "****    ****\n"
					+ "***      ***\n" + "**        **\n" + "*          *\n" + "**        **\n"
					+ "***      ***\n" + "****    ****\n" + "*****  *****\n" + "************\n";
		assertEquals(actualValue, expectedValue);
	}

	@Test
	public void starSevenWebTest() {
		String actualValue = patternService.hollowDiamond(6, "web");
		System.out.println(actualValue);
		String expectedValue = "************<br>" + "*****  *****<br>" + "****    ****<br>"
					+ "***      ***<br>" + "**        **<br>" + "*          *<br>"
					+ "**        **<br>" + "***      ***<br>" + "****    ****<br>"
					+ "*****  *****<br>" + "************<br>";
		assertEquals(actualValue, expectedValue);
	}
}
