package tw.cy.study.leetcode;

import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 
 * @author Plus
 *
 */
public class TwoSum {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] onePhaseHashMap(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, len = nums.length; i < len; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No twoSum solution");
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoPhaseHashMap(int[] nums, int target) {
		HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) IntStream.range(0, nums.length).boxed()
				.collect(Collectors.toMap(i -> nums[i], Function.identity(), (p1, p2) -> p2));
		for (int i = 0, len = nums.length; i < len; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && (map.get(complement) != i)) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No twoSum solution");
	}

	/**
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] bruteForce(int[] nums, int target) {
		for (int i = 0, len = nums.length - 1; i < len; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No twoSum solution");
	}
}
