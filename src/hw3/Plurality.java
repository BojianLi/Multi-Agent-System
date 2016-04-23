package hw3;

import java.util.List;

public class Plurality {
	public static void c(final List<List<Integer>> pref) {
		int[] count = new int[12];
		for (List<Integer> list : pref) {
			count[list.get(1)] += list.get(0);
		}
		int max = 0;
		int winner = 0;
		for (int i = 1; i <= 11; i++) {
			if (count[i] > max) {
				max = count[i];
				winner = i;
			}
		}
		System.out.println("Plurality " + winner);
	}
}
