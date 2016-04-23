package hw3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstantRunoff {
	public static void c(final List<List<Integer>> pref) {
		Set<Integer> runoff = new HashSet<>();
		while (true) {
			int[] count = new int[12];
			for (List<Integer> list : pref) {
				int index = 1;
				while (index < list.size() && runoff.contains(list.get(index))) {
					index++;
				}
				if (index >= list.size()) {
					continue;
				}
				count[list.get(index)] += list.get(0);
			}
			int sum = 0;
			int max = 0;
			int winner = 0;
			int min = Integer.MAX_VALUE;
			int loser = 0;
			for (int i = 1; i <= 11; i++) {
				sum += count[i];
				if (count[i] > max) {
					max = count[i];
					winner = i;
				}
				if (!runoff.contains(i) && count[i] < min) {
					min = count[i];
					loser = i;
				}
			}
			if (max >= sum / 2) {
				System.out.println("Runoff " + winner);
				return;
			} else {
				runoff.add(loser);
			}
		}
	}
}
