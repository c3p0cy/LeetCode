package tw.cy.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/single-number/description/ Given an array of
 * integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * Not found >> return 0
 * 
 * @author Plus
 *
 */
public class SingleNumber {

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int findSingleNumber3(int[] nums) {
		int x = 0;
		int i = 0;

		while (i < nums.length) {
			x ^= nums[i++];
		}

		return x;
	}

	/**
	 * Best of LeedCode
	 * 
	 * 因為輸入一定只有一個值是單一的，且沒找到也是回傳0，所以才可用XOR來解。
	 * 
	 * @param nums
	 * @return
	 */
	public static int findSingleNumber2(int[] nums) {
		int x = 0;

		for (int i = 0; i < nums.length; i++) {
			x ^= nums[i];
		}

		return x;
	}

	/**
	 * My answer
	 * 
	 * @param nums
	 * @return
	 */
	public static int findSingleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		int lastIndex = nums.length - 1;
		while (i < nums.length) {
			if (i == lastIndex) {
				// System.out.println("Result for single(lastIndex): " +
				// nums[i]);
				return nums[i];
			}
			if (nums[i] != nums[i + 1]) {
				// System.out.println("Result for single: " + nums[i]);
				return nums[i];
			}
			i += 2;
		}
		// System.out.println("Result for not found: " + 0);
		return 0;
	}
}
