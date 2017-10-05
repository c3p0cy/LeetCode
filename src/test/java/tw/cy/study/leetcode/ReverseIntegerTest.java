package tw.cy.study.leetcode;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class ReverseIntegerTest {

	Map<Integer, Integer> cases;

	@Before
	public void before() {
		cases = getCases();
	}
	
	@Test(timeout = 150)
	public void testReverseInteger() {
		cases.entrySet().stream().forEach(entry -> {
			int result = ReverseInteger.reverseInteger(entry.getKey());
			assertTrue(String.format("raw: %s, expect: %s, result: %s", entry.getKey(), entry.getValue(), result),
					entry.getValue().equals(result));
		});
	}

	@Test(timeout = 150)
	public void testReverseInteger2() {
		cases.entrySet().stream().forEach(entry -> {
			int result = ReverseInteger.reverseInteger2(entry.getKey());
			assertTrue(String.format("raw: %s, expect: %s, result: %s", entry.getKey(), entry.getValue(), result),
					entry.getValue().equals(result));
		});
	}
	
	@Test(timeout = 150)
	public void testReverseInteger3() {
		cases.entrySet().stream().forEach(entry -> {
			int result = ReverseInteger.reverseInteger3(entry.getKey());
			assertTrue(String.format("raw: %s, expect: %s, result: %s", entry.getKey(), entry.getValue(), result),
					entry.getValue().equals(result));
		});
	}

	private Map<Integer, Integer> getCases() {
		Map<Integer, Integer> map = Maps.newHashMap();
		map.put(2147483647, 0);
		map.put(-2147483648, 0);
		map.put(0, 0);
		map.put(9, 9);
		map.put(-9, -9);
		map.put(90, 9);
		map.put(-90, -9);
		map.put(909, 909);
		map.put(-909, -909);
		map.put(10, 1);
		map.put(100, 1);
		map.put(-100, -1);
		map.put(123, 321);
		map.put(-123, -321);
		map.put(255, 552);
		map.put(256, 652);
		map.put(1000000003, 0);
		map.put(2063847412, 2147483602);
		return map;
	}
}
