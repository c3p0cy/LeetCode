package tw.cy.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> twoIndexes2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1;
				int hi = nums.length - 1;
				int sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1]) {
							lo++;
						}
						while (lo < hi && nums[hi] == nums[hi - 1]) {
							hi--;
						}
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return result;
	}

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param input
	 * @return
	 */
	public static List<List<Integer>> twoIndexes(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(input); // sort
		int loopCounts = 0;
		for (int i = 0, len1 = input.length - 2, len2 = input.length - 1; i < len1; i++) {
			if (input[i] > 0) { // 合己大於0 >> 中止廻圈
				break;
			}
			if (i > 0 && (input[i] == input[i - 1])) { // 值和上一輪相同 >> 略過
				continue;
			}

			int left = i + 1;
			int right = len2;
			int sum;
			while (left < right) {
				if (input[i] + input[left] > 0) {
					break;
				}

				if ((left > i + 1) && (input[left] == input[left - 1])) {
					left++;
					continue;
				}

				if ((right < len2) && (input[right] == input[right + 1])) {
					right--;
					continue;
				}

				loopCounts++;
				sum = input[i] + input[left] + input[right];
				if (sum == 0) {
					result.add(IntStream.of(input[i], input[left], input[right]).boxed().sorted()
							.collect(Collectors.toList()));
					right--;
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		System.out.println("loops = " + loopCounts);
		return result;
	}

	/**
	 * Time Complexity: O(n^3)
	 * 
	 * @param input
	 * @return
	 */
	public static List<List<Integer>> bruteForce(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len1 = input.length - 2;
		int len2 = input.length - 1;
		List<Integer> sol;
		Arrays.sort(input); // sort
		long loopCount = 0L;
		for (int i = 0; i < len1; i++) {
			if (input[i] > 0) { // 合己大於0 >> 中止廻圈
				break;
			}
			if (i > 0 && (input[i] == input[i - 1])) { // 值和上一輪相同 >> 略過
				continue;
			}
			for (int j = i + 1; j < len2; j++) {
				if (input[i] + input[j] > 0) { // 合己大於0 >> 中止廻圈
					break;
				}
				if (j > i + 1 && (input[j] == input[j - 1])) { // 值和上一輪相同 >> 略過
					continue;
				}
				for (int k = j + 1; k < input.length; k++) {
					int sum = input[i] + input[j] + input[k];
					if (sum > 0) { // 合己大於0 >> 中止廻圈
						break;
					}
					if (k > j + 1 && (input[k] == input[k - 1])) { // 值和上一輪相同 >>
																	// 略過
						continue;
					}
					if (sum == 0) {
						sol = IntStream.of(input[i], input[j], input[k]).boxed().sorted().collect(Collectors.toList());
						if (!isDuplicate(result, sol)) {
							result.add(sol);
						}
					}
					loopCount++;
				}
			}
		}
		System.out.println("loops = " + loopCount);
		return result;
	}

	private static boolean isDuplicate(List<List<Integer>> base, List<Integer> target) {
		return base.stream().anyMatch(e -> Arrays.equals(e.toArray(), target.toArray()));
	}
}
