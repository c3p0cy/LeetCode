package tw.cy.study.leetcode;

/**
 * 兩個等長度的二元碼，其位元值不相同之位置的數目，例如：〝101101〞和〝011100〞之漢明距離為三。
 * 
 * @author Plus
 *
 */
public class HammingDistance {

	/**
	 * the best performance of Java on LeetCode
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance5(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("input must >= 0");
		}
		int i = x ^ y;
		int result = 0;
		for (int j = 0; j < 32; j++) {
			// System.out.println("===============");
			// System.out.println("i = " + i + " >> " +
			// Integer.toBinaryString(i));
			// System.out.println("j = " + j);
			// System.out.println("(i >> j) = " + (i >> j) + " >> " +
			// Integer.toBinaryString((i >> j)));
			// System.out.println("(i >> j) & 1 = " + ((i >> j) & 1) + " >> " +
			// Integer.toBinaryString((i >> j) & 1));
			result += (i >> j) & 1;
		}
		// System.out.println("result = " + result);
		return result;
	}

	/**
	 * The other solution on LeetCode
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance4(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("input must >= 0");
		}
		int i = x ^ y;

		int result = 0;
		while (i != 0) {
			// System.out.println("i = " + i + " >> " +
			// Integer.toBinaryString(i));
			// System.out.println("i - 1 = " + (i - 1) + " >> " +
			// Integer.toBinaryString(i - 1));
			// System.out.println("i & (i - 1) = " + (i & (i - 1)) + " >> " +
			// Integer.toBinaryString(i & (i - 1)));
			i = i & (i - 1);
			result++;
		}
		// System.out.println("result = " + result);
		return result;
	}

	/**
	 * my 2nd ver
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance3(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("input must >= 0");
		}
		int i = x ^ y;
		int result = 0;
		while (i > 0) {
			result += i % 2;
			i = i >>> 1;
		}
		return result;
	}

	/**
	 * use java method: Integer.bitCount(x ^ y)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance2(int x, int y) {
		// Integer.bitCount(x ^ y);
		int i = x ^ y;
		i = i - ((i >>> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		i = i + (i >>> 8);
		i = i + (i >>> 16);
		return i & 0x3f;
	}

	/**
	 * my first ver
	 * 
	 * @param x
	 *            0 <= x < (2^31)
	 * @param y
	 *            0 <= y < (2^31)
	 * @return
	 */
	public static int hammingDistance(int x, int y) {
		String bx = Integer.toBinaryString(x);
		String by = Integer.toBinaryString(y);
		int lenX = bx.length();
		int lenY = by.length();
		// System.out.println(String.format("(%s,%s) >> (%s, %s) >> (%s:%s)", x,
		// y, bx, by, lenX, lenY));
		char[] cx;
		char[] cy;
		if (lenX > lenY) {
			cx = bx.toCharArray();
			cy = insertZero(by, lenY, lenX - lenY);
		} else if (lenX < lenY) {
			cx = insertZero(bx, lenX, lenY - lenX);
			cy = by.toCharArray();
		} else {
			cx = bx.toCharArray();
			cy = by.toCharArray();
		}
		// System.out.println(String.format("(%s,%s)", Arrays.toString(cx),
		// Arrays.toString(cy)));

		int left = 0;
		int result = 0;
		while (left < cx.length) {
			if (cx[left] != cy[left]) {
				result++;
			}
			left++;
		}
		return result;
	}

	private static char[] insertZero(String str, int strLen, int insertCount) {
		StringBuilder sb = new StringBuilder(strLen + insertCount);
		while (insertCount > 0) {
			sb.append('0');
			insertCount--;
		}
		sb.append(str);
		// System.out.println(sb);
		return sb.toString().toCharArray();
	}
}
