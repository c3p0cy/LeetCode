package tw.cy.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

	// public static List<List<Integer>> twoIndexes(int[] input) {
	// int len1 = input.length - 2;
	// int left;
	// int right;
	// for (int i = 0; i < len1; i++) {
	//
	// }
	// }

	public static List<List<Integer>> bruteForce(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len1 = input.length - 2;
		int len2 = input.length - 1;
		List<Integer> sol = null;
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
					if (k > j + 1 && (input[k] == input[k - 1])) { // 值和上一輪相同 >> 略過
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
