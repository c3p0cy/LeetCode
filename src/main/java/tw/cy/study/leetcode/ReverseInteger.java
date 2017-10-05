package tw.cy.study.leetcode;

/**
 * x = 123, return 321<br>
 * x = -123, return -321<br>
 * 需考慮在 32 位元 overflow 問題: overflow 皆回傳 0<br>
 * x = 1000000003, return 0
 * 
 * @author Plus
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println("2147483647: " + reverseInteger3(2147483647));
		System.out.println("-2147483648: " + reverseInteger3(-2147483648));
		System.out.println("0: " + reverseInteger3(0));
		System.out.println("9: " + reverseInteger3(9));
		System.out.println("-9: " + reverseInteger3(-9));
		System.out.println("10: " + reverseInteger3(10));
		System.out.println("100: " + reverseInteger3(100));
		System.out.println("123: " + reverseInteger3(123));
		System.out.println("-123: " + reverseInteger3(-123));
		System.out.println("255: " + reverseInteger3(255));
		System.out.println("256: " + reverseInteger3(256));
		System.out.println("1000000003: " + reverseInteger3(1000000003));
		System.out.println("2063847412: " + reverseInteger3(2063847412));
	}

	/**
	 * The best performance of Java on LeetCode
	 * 
	 * @param x
	 * @return
	 */
	public static int reverseInteger3(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if (result != (newResult - tail) / 10) {
				System.out.println(String.format("break: x=%s, tail=%s, newResult=%s, result=%s, sub=%s", x, tail,
						newResult, result, (newResult - tail) / 10));
				return 0;
			}
			System.out.println(String.format("x=%s, tail=%s, newResult=%s, result=%s, sub=%s", x, tail, newResult,
					result, (newResult - tail) / 10));
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	/**
	 * 2nd version
	 * 
	 * @param x
	 * @return
	 */
	public static int reverseInteger2(int x) {
		boolean nagetive = false;
		int abs = x;
		if (x < 0) {
			abs = 0 - x;
			nagetive = true;
		}

		int result = 0;
		int mod;
		while (abs > 0) {
			mod = abs % 10;
			abs = abs / 10;
			if (result > (Integer.MAX_VALUE - mod) / 10) {
				System.out.println(String.format("break: x=%s, abs=%s, mod=%s, result=%s, sub=%s", x, abs, mod, result,
						(Integer.MAX_VALUE - mod) / 10));
				result = 0;
				break;
			}
			result = result * 10 + mod;
			System.out.println(String.format("x=%s, abs=%s, mod=%s, result=%s", x, abs, mod, result));
		}

		return nagetive ? 0 - result : result;
	}

	/**
	 * 1st version
	 * 
	 * @param x
	 * @return
	 */
	public static int reverseInteger(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		if (x < 10 && x > -10) {
			return x;
		}
		boolean nagetive = x < 0;
		int abs = nagetive ? Math.abs(x) : x;
		int digits = (int) Math.log10(abs) + 1;
		int reversed = 0;
		for (int i = 1, len = digits + 1; i < len; i++) {
			int a = abs % (int) Math.pow(10, i);
			int b = a / (int) Math.pow(10, i - 1);
			int c = b * (int) Math.pow(10, digits - i);
			System.out.println(String.format("x=%s, abs=%s, i=%s, a=%s, b=%s, c=%s", x, abs, i, a, b, c));
			if (c < 0) {
				reversed = 0;
				break;
			}
			reversed += c;
		}
		if (reversed < 0) {
			return 0;
		}
		return nagetive ? -reversed : reversed;
	}

}
