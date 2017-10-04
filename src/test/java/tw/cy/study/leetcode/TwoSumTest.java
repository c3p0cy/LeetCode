package tw.cy.study.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TwoSumTest {
	
	@Test
	public void testOnePhaseHashMap() {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] expected = new int[] { 0, 1 };
		int[] result = twoSum.onePhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
		
		nums = new int[] { 0, 4, 3, 0 };
		target = 0;
		expected = new int[] { 0, 3 };
		result = twoSum.onePhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
		
		nums = new int[] { 1, 4, 4, 3 };
		target = 8;
		expected = new int[] { 1, 2 };
		result = twoSum.onePhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
	}

	@Test
	public void testTwoPhaseHashMap() {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] expected = new int[] { 0, 1 };
		int[] result = twoSum.twoPhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));

		nums = new int[] { 0, 4, 3, 0 };
		target = 0;
		expected = new int[] { 0, 3 };
		result = twoSum.twoPhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
		
		nums = new int[] { 1, 4, 4, 3 };
		target = 8;
		expected = new int[] { 1, 2 };
		result = twoSum.twoPhaseHashMap(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
	}
	
	@Test
	public void testBruteForce() {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] expected = new int[] { 0, 1 };
		int[] result = twoSum.bruteForce(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));

		nums = new int[] { 0, 4, 3, 0 };
		target = 0;
		expected = new int[] { 0, 3 };
		result = twoSum.bruteForce(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
		
		nums = new int[] { 1, 4, 4, 3 };
		target = 8;
		expected = new int[] { 1, 2 };
		result = twoSum.bruteForce(nums, target);
		assertTrue(Arrays.toString(result), Arrays.equals(result, expected));
	}

}
