package tw.cy.study.leetcode;

/**
 * https://leetcode.com/problems/two-sum/description/
 * 
 * @author Plus
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
        for(int i = 0, len = nums.length - 1; i < len; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No twoSum solution");
    }
}
