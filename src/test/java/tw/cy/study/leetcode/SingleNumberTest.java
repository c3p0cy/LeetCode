package tw.cy.study.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SingleNumberTest {

	Map<int[], Integer> data = new LinkedHashMap<int[], Integer>();
	int runs = 1000000;

	@Before
	public void before() {
		data.put(new int[] {}, 0);
		data.put(new int[] { 0 }, 0);
		data.put(new int[] { 0, 0 }, 0);
		data.put(new int[] { 0, 0, -1 }, -1);
		data.put(new int[] { 0, 0, -1, -1 }, 0);
		data.put(new int[] { 0, -1, 0 }, -1);
		data.put(new int[] { -1, 0, 0 }, -1);
		data.put(new int[] { 0, -1, 0 }, -1);
		data.put(new int[] { 0, -1, 0, -1, 2 }, 2);
		data.put(new int[] { 0, 2, 0, -1, -1 }, 2);
	}

	@Test
	public void test() {
	}

	@Test
	public void testFindSingleNumber() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
					.forEach(e -> {
//						System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
//								e.getValue()));
						int result = SingleNumber.findSingleNumber(e.getKey());
//						System.out.println(String.format("result = %s", result));
						assertEquals(e.getValue().intValue(), result);
//						System.out.println("========================");
					});
		});
	}
	
	@Test
	public void testFindSingleNumber2() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> {
//				System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
//						e.getValue()));
				int result = SingleNumber.findSingleNumber2(e.getKey());
//				System.out.println(String.format("result = %s", result));
				assertEquals(e.getValue().intValue(), result);
//				System.out.println("========================");
			});
		});
	}
	
	@Test
	public void testFindSingleNumber3() {
		IntStream.range(0, runs).forEach(i -> {
			data.entrySet()
			.forEach(e -> {
//				System.out.println(String.format("data = %s : except = %s", Arrays.toString(e.getKey()),
//						e.getValue()));
				int result = SingleNumber.findSingleNumber3(e.getKey());
//				System.out.println(String.format("result = %s", result));
				assertEquals(e.getValue().intValue(), result);
//				System.out.println("========================");
			});
		});
	}

}
