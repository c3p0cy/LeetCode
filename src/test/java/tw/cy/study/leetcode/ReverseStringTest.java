package tw.cy.study.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseStringTest {

	final int runs = 10000000;
	
	@Test()
	public void test() {
		// to prevent first test always slower than the others
	}

	@Test()
	public void testReverseString() {
		IntStream.range(0, runs).forEach(e -> {
			assertEquals("olleH", ReverseString.reverseString("Hello"));
		});
	}

	@Test()
	public void testReverseString2() {
		IntStream.range(0, runs).forEach(e -> {
			assertEquals("olleH", ReverseString.reverseString2("Hello"));
		});
	}
	
	@Test()
	public void testReverseString3() {
		IntStream.range(0, runs).forEach(e -> {
			assertEquals("olleH", ReverseString.reverseString3("Hello"));
		});
	}
}
