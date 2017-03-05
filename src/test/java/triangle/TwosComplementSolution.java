package triangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hamming weight of a range
 * Created by anna.kulikova on 04/03/2017.
 */
public class TwosComplementSolution {

	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader
				("src/test/java/triangle/TwosComplementTest.txt"))) {
			Scanner sc = new Scanner(in);

			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				System.out.println(solve(a, b));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static long findNumberOfOnes(long n) {
		if (n == 0)
			return 0;
		else if (n % 2 == 0) {
			return findNumberOfOnes(n - 1) + Long.bitCount(n);
		} else {
			return findNumberOfOnes(n >>> 1) * 2 + (n + 1) / 2;
		}
	}

	private static long solve(int a, int b) {
		long ret;
		if (b >= 0 && a >= 0) {
			ret = findNumberOfOnes(b) - findNumberOfOnes(Math.max(0, a - 1));
		} else if (b >= 0 && a < 0) {
			ret = findNumberOfOnes(b);
			ret += (findNumberOfOnes((1L << 32) - 1) - findNumberOfOnes((1L << 32) + a - 1));
		} else {
			ret = findNumberOfOnes((1L << 32) + b) - findNumberOfOnes((1L << 32) + a - 1);
		}
		return ret;
	}
}
