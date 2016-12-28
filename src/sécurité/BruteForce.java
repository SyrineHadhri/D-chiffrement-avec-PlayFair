package sécurité;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce {

	final int min;
	final int max;
	final int stringLength;

	/**
	 * One more element than <i>stringLength</i>, to efficiently check for
	 * overflow.
	 */
	public static int[] chars;

	public BruteForce(int min, int max, int len) {
		this.min = min;
		this.max = max;
		this.stringLength = len;

		chars = new int[stringLength + 1];
		Arrays.fill(chars, 1, chars.length, min);
	}

	public String run() {
			String ch = print();
			increment();
			return ch;
	}

	private void increment() {
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] < max) {
				chars[i]++;
				return;
			}
			chars[i] = min;
		}
	}

	private String print() {
		String ch = "";
		for (int i = 1; i < chars.length; i++)
			ch += (char) chars[i];
		return ch;
	}

}
