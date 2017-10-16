package tw.cy.study.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepeatedStringMatchTest {

	Map<String[], Integer> data = new LinkedHashMap<String[], Integer>();
	int runs = 50000;

	@Before
	public void before() {
		data.put(new String[]{"a", "abc"}, -1);
		data.put(new String[]{"abcd", "a"}, 1);
		data.put(new String[]{"abcd", "ab"}, 1);
		data.put(new String[]{"abcd", "abc"}, 1);
		data.put(new String[]{"abcd", "abcd"}, 1);
		data.put(new String[]{"abcd", "abcda"}, 2);
		data.put(new String[]{"abcd", "abcdab"}, 2);
		data.put(new String[]{"abcd", "abcdabc"}, 2);
		data.put(new String[]{"abcd", "abcdabcd"}, 2);
		data.put(new String[]{"abcd", "b"}, 1);
		data.put(new String[]{"abcd", "bc"}, 1);
		data.put(new String[]{"abcd", "bcd"}, 1);
		data.put(new String[]{"abcd", "bcda"}, 2);
		data.put(new String[]{"abcd", "bcdab"}, 2);
		data.put(new String[]{"abcd", "bcdabc"}, 2);
		data.put(new String[]{"abcd", "bcdabcd"}, 2);
		data.put(new String[]{"abcd", "bcdabcda"}, 3);
		data.put(new String[]{"abcd", "bcdabcdabcd"}, 3);
		data.put(new String[]{"abcd", "bcdabcdabcda"}, 4);
		data.put(new String[]{"abcd", "c"}, 1);
		data.put(new String[]{"abcd", "cd"}, 1);
		data.put(new String[]{"abcd", "cda"}, 2);
		data.put(new String[]{"abcd", "cdabcdab"}, 3);
		data.put(new String[]{"abcd", "cdabdcdab"}, -1);
		data.put(new String[]{"abcd", "cdabecdab"}, -1);
		data.put(new String[]{"abcd", "d"}, 1);
		data.put(new String[]{"abcd", "da"}, 2);
		data.put(new String[]{"abcd", "dab"}, 2);
		data.put(new String[]{"abcd", "dabc"}, 2);
		data.put(new String[]{"abcd", "e"}, -1);
		data.put(new String[]{"aabbaba", "aaab"}, 2);
		data.put(new String[]{"aabbaba", "aabba"}, 1);
		data.put(new String[]{"aabbaba", "aba"}, 1);
		data.put(new String[]{"aabbaba", "abaa"}, 2);
		data.put(new String[]{"aabbaba", "abaaa"}, 2);
		data.put(new String[]{"aabbaba", "baa"}, 2);
		data.put(new String[]{"aabbaba", "bab"}, 1);
		data.put(new String[]{"aabbaba", "babaa"}, 2);
		data.put(new String[]{"aabbaba", "bbabaa"}, 2);
		data.put(new String[]{"aabbaba", "bbabaaa"}, 2);
		data.put(new String[]{"aba", "aaba"}, 2);
		data.put(new String[]{"ababa", "aaba"}, 2);
		data.put(new String[]{"ababaa", "aaba"}, 2);
		data.put(new String[]{"ababaa", "aabab"}, 2);
		data.put(new String[]{"ababaa", "aabababaa"}, -1);
		data.put(new String[]{"ababaa", "aaabab"}, 2);
		data.put(new String[]{"abababaaba", "aabaaba"}, 2);
		data.put(new String[]{"aababa", "aaabab"}, 2);
		data.put(new String[]{"aababaa", "aaabab"}, 2);
		data.put(new String[]{"aababaa", "aaaabab"}, 2);
		data.put(new String[]{"aababaa", "aaaababa"}, 2);
		data.put(new String[]{"aababaa", "aababaa"}, 1);
		data.put(new String[]{"aababaa", "aababaab"}, -1);
	}

	@Test
	public void test() {
	}

	@Test
	public void testSolution1() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
					.forEach(e -> {
//						System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
//								e.getValue()));
						int result = RepeatedStringMatch.solution1(e.getKey()[0], e.getKey()[1]);
//						System.out.println(String.format("result = %s", result));
						assertEquals(e.getValue().intValue(), result);
//						System.out.println("========================");
					});
		});
	}
	
//	@Test
	public void testSolution2() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> {
						System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
								e.getValue()));
				int result = RepeatedStringMatch.solution2(e.getKey()[0], e.getKey()[1]);
						System.out.println(String.format("result = %s", result));
				assertEquals(e.getValue().intValue(), result);
						System.out.println("========================");
			});
		});
	}
	
	@Test
	public void testSolution3() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> {
//				System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
//						e.getValue()));
				int result = RepeatedStringMatch.solution3(e.getKey()[0], e.getKey()[1]);
//				System.out.println(String.format("result = %s", result));
				assertEquals(e.getValue().intValue(), result);
//				System.out.println("========================");
			});
		});
	}
	
}
