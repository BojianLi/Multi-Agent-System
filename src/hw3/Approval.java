package hw3;

import java.util.List;

public class Approval {
	public static void c(final List<List<Integer>> pref) {
		int[] count = new int[12];
		for (List<Integer> list : pref) {
			int num = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				count[list.get(i)] += num;
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
		System.out.println("Approval " + winner);
	}
}
