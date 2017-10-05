package tw.cy.study.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeSum {

	public static List<List<Integer>> bruteForce(int[] input) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len1 = input.length - 2;
		int len2 = input.length - 1;
		List<Integer> sol = null;
		for (int i = 0; i < len1; i++) {
			for (int j = i + 1; j < len2; j++) {
				for (int k = j + 1; k < input.length; k++) {
					if (input[i] + input[j] + input[k] == 0) {
						sol = IntStream.of(input[i], input[j], input[k]).boxed().sorted().collect(Collectors.toList());
						if (!isDuplicate(result, sol)) {
							result.add(sol);
						}
					}
				}
			}
		}
		return result;
	}

	private static boolean isDuplicate(List<List<Integer>> base, List<Integer> target) {
		return base.stream().anyMatch(e -> Arrays.equals(e.toArray(), target.toArray()));
	}
}
