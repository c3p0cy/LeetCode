package tw.cy.study.leetcode;

public class ReverseString {

	/**
	 * Use for-loop
	 * 
	 * @param str
	 * @return
	 */
	public static String reverseString(String str) {
		char[] carr = str.toCharArray();
		char[] result = new char[carr.length];
		for (int i = carr.length - 1; i > -1; i--) {
			result[i] = carr[carr.length - i - 1];
		}
		return String.valueOf(result);
	}

	/**
	 * Use while-loop
	 * 
	 * @param str
	 * @return
	 */
	public static String reverseString2(String str) {
		char[] carr = str.toCharArray();
		int len = carr.length;
		char[] result = new char[len];
		int i = 0;
		int r = len - 1;
		while (i < len) {
			result[i] = carr[r - i];
			i++;
		}
		return String.valueOf(result);
	}

	/**
	 * Use buffer and 2 indices to switch position
	 * 
	 * @param str
	 * @return
	 */
	public static String reverseString3(String str) {
		char[] carr = str.toCharArray();
		int left = 0;
		int right = carr.length - 1;
		char temp;
		while (left < right) {
			temp = carr[left];
			carr[left] = carr[right];
			carr[right] = temp;
			left++;
			right--;
		}
		return String.valueOf(carr);
	}
}
