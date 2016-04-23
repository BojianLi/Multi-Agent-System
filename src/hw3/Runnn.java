package hw3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runnn {

	public static void main(String[] args) {
		Scanner sc = null;
		List<List<Integer>> pref = new ArrayList<List<Integer>>();
		try {
			sc = new Scanner(new FileReader("data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.indexOf("{") >= 0) {
				continue;
			}
			String[] ds = line.split(",");
			List<Integer> list = new ArrayList<Integer>();
			for (String s : ds) {
				list.add(Integer.valueOf(s));
			}
			pref.add(list);
		}
		sc.close();
		
		
		Plurality.c(pref);
		InstantRunoff.c(pref);
		Borda.c(pref);
		Approval.c(pref);
	}

}
