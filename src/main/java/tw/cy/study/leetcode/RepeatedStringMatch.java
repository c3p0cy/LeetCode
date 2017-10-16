package tw.cy.study.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/repeated-string-match/description/<br/>
 * 
 * Given two strings A and B,<br/>
 * find the minimum number of times A has to be repeated<br/>
 * such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".<br/>
 * Return 3, because by repeating A three times (“abcdabcdabcd”),<br/>
 * B is a substring of it
 *
 * Note: The length of A and B will be between 1 and 10000.<br/>
 * 
 * @author Plus
 *
 */
public class RepeatedStringMatch {

	/**
	 * Discuss of LeedCode
	 * 
	 * It use string appending.<br/>
	 * But it's runtime better than mine.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int solution3(String a, String b) {
		String as = a;
		for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a) {
			if (as.indexOf(b) != -1) {
				return rep;
			}
		}
		return -1;
	}

	/**
	 * Best Runtime of LeedCode
	 * 
	 * But it has bug:<br/>
	 * a="aabbaba", b="bab" >> except = 1 >> result = -1<br/>
	 * a="aabbaba", b="babaa" >> except = 2 >> result = -1
	 * 
	 * @param nums
	 * @return
	 */
	public static int solution2(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		int ai = 0;
		int bi = 0;

		while (ai < lenA && bi < lenB) {
			if (charA[ai] == charB[bi]) {
				ai++;
				bi++;
			} else {
				ai++;
				bi = 0;
			}
		}

		if (bi == 0)
			return -1;

		int count = 1;
		ai = 0;

		while (bi < lenB) {
			if (ai == 0)
				count++;
			if (charA[ai] == charB[bi]) {
				ai++;
				bi++;
			} else {
				return -1;
			}
			if (ai == lenA)
				ai = 0;
		}
		return count;
	}

	/**
	 * My answer
	 * 
	 * @param nums
	 * @return
	 */
	public static int solution1(String a, String b) {
		if (a.indexOf(b) > -1) {
			return 1;
		}

		int repeated = 1;
		int lenA = a.length();
		int lenB = b.length();
		char[] charArrayA = a.toCharArray();
		char[] charArrayB = b.toCharArray();
		int indexA = 0;
		while (indexA < lenA) {
			int firstCharIndexInA = a.indexOf(charArrayB[0], indexA);
			// println("indexA=%s, lenA=%s, firstCharIndexInA=%s", indexA, lenA,
			// firstCharIndexInA);
			if (firstCharIndexInA == -1) {
				return -1;
			}

			boolean matched = true;
			int count = 0;
			for (int ib = 0, ia = firstCharIndexInA; ib < lenB; ib++, ia++) {
				// print("ib=%s, ia=%s", ib, ia);
				if (ia == lenA) {
					ia = 0;
					count++;
				}
				// println(", charArrayB[ib]=%s, charArrayA[ia]=%s",
				// charArrayB[ib], charArrayA[ia]);
				if (charArrayB[ib] != charArrayA[ia]) {
					matched = false;
					count = 0;
					break;
				}
			}

			// println("matched=%s", matched);
			if (matched) {
				return repeated += count;
			} else {
				indexA++;
			}
		}
		return -1;
	}

	private static void print(String format, Object... args) {
		System.out.print(String.format(format, args));
	}

	private static void println(String format, Object... args) {
		System.out.println(String.format(format, args));
	}

	public static void main(String[] args) {
		System.out.println(solution1("abcd", "da"));
		System.out.println(solution1("abcd", "dabc"));
		System.out.println(solution1("abcd", "cda"));
		System.out.println(solution1("abcd", "cdabc"));
		System.out.println(solution1("abcd", "cdabcdab"));
		System.out.println(solution1("abcd", "abc"));
		System.out.println(solution1("abcd", "bc"));
		System.out.println(solution1("abcd", "k"));
		System.out.println(solution1("abcd", "abcd"));
		System.out.println(solution1("abcd", "abcde"));
	}
}
