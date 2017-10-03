package tw.cy.study.leetcode;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TwoSumTest {

	@Test
	public void test() {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[] {2, 7, 11, 15};
		int target = 9;
		int[] expected = new int[] {0, 1};
		int[] result = twoSum.twoSum(nums, target);
		assertTrue(Arrays.equals(result, expected));
		
		nums = new int[] {0,4,3,0};
		target = 0;
		expected = new int[] {0, 3};
		result = twoSum.twoSum(nums, target);
		assertTrue(Arrays.equals(result, expected));
	}

}
