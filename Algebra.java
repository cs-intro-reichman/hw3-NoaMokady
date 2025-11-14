// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(2, 3)); // 2 + 3
		System.out.println(minus(7, 2)); // 7 - 2
		System.out.println(minus(2, 7)); // 2 - 7
		System.out.println(times(3, 4)); // 3 * 4
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		System.out.println(pow(5, 3)); // 5^3
		System.out.println(pow(3, 5)); // 3^5
		System.out.println(div(12, 3)); // 12 / 3
		System.out.println(div(5, 5)); // 5 / 5
		System.out.println(div(25, 7)); // 25 / 7
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns the absolute value of x
	public static int abs(int x) {
		if (x < 0) {
			return -x;
		}
		return x;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			return minus(x1, abs(x2));
		}

		for (int i = 0; i < x2; i++) {
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			return plus(x1, abs(x2));
		}

		for (int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x2 < 0) {
			x1 = -x1;
		}

		int result = 0;
		for (int i = 0; i < abs(x2); i++) {
			result = plus(result, x1);
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int result = x;
		for (int i = 0; i < minus(n, 1); i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		// Handles negative numbers by finding the result's negative or positive sign.
		int sign = 1;
		if (times(x1, x2) < 0) {
			sign = -1;
		}

		x1 = abs(x1);
		x2 = abs(x2);

		int result = 0;
		while (x1 >= x2 && x2 != 0) {
			x1 = minus(x1, x2);
			result++;
		}
		return times(result, sign);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}
		return x1;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int i = 1;
		while (pow(i, 2) < x) {
			i++;
		}

		// Removes 1 from i when i^2 is bigger than x
		if (pow(i, 2) > x) {
			i--;
		}

		return i;
	}
}