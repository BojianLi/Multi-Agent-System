package hw3;

import java.util.List;

public class Borda {
	public static void c(final List<List<Integer>> pref) {
		int cans = 11;
		int[] count = new int[12];
		for (List<Integer> list : pref) {
			int num = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				count[list.get(i)] += num * (cans - i);
			}
		}
		int max = 0;
		int winner = 0;
		for (int i = 1; i <= 11; i++) {
			if (count[i] > max) {
				max = count[i];
				winner = i;
			}
		}
		System.out.println("Borda " + winner);
	}
}
