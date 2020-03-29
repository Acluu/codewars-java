package hammingnumbers;

import java.util.Arrays;

/**
 * codewars Hamming number
 * 
 * @author Acluu
 *
 */
public class Hamming {

	public static long min(long a, long b, long c) {
		long result = -1;
		if ((a <= b) && (a <= c)) {
			result = a;
		}
		if ((b <= a) && (b <= c)) {
			result = b;
		}
		if ((c <= b) && (a >= c)) {
			result = c;
		}
		return result;
	}

	public static long hamming(int n) {
		long[] hamlist = new long[n];
		hamlist[0] = 1;
		int c2 = 0, c3 = 0, c5 = 0;
		long x2 = 2, x3 = 3, x5 = 5;
		for (int cnt = 1; cnt < n; cnt++) {
			hamlist[cnt] = min(x2, x3, x5);
			if (hamlist[cnt] == x2) {
				c2++;
				x2 = 2 * hamlist[c2];
			}
			if (hamlist[cnt] == x3) {
				c3++;
				x3 = 3 * hamlist[c3];
			}
			if (hamlist[cnt] == x5) {
				c5++;
				x5 = 5 * hamlist[c5];
			}
		}
		return hamlist[n - 1];
	}

	public static void main(String[] args) {
		//for(int i=1;i<4;i++) {
		System.out.println(hamming(10));
	}

}
