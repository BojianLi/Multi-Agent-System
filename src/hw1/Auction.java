package hw1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Auction {
	public static int assign(int[][] table) {
		int numa = table.length;
		int numo = table[0].length;
		double[] p = new double[numo];
		int[] oa = new int[numo];
		Arrays.fill(oa, -1);
		int[] ao = new int[numa];
		Arrays.fill(ao, -1);
		int num = 0;
		while (num < Math.min(numa, numo)) {
			for (int i = 0; i < numa; i++) {
				if (ao[i] != -1) {
					continue;
				}
				double max = -1;
				int mo = -1;
				Queue<Double> q = new PriorityQueue<>();
				for (int j = 0; j < numo; j++) {
					double sur = table[i][j] - p[j];
					if (sur > max) {
						max = sur;
						mo = j;
					}
					if (q.size() < 2) {
						q.add(sur);
					} else {
						if (sur > q.peek()) {
							q.poll();
							q.add(sur);
						}
					}
				}
				p[mo] += -(q.poll() - q.poll()) + 0.001;
				if (oa[mo] != -1) {
					ao[oa[mo]] = -1;
					oa[mo] = i;
					ao[i] = mo;
				} else {
					oa[mo] = i;
					ao[i] = mo;
					num++;
				}
			}
		}
//		for (int i : ao) {
//			System.out.println(i);
//		}
		int sum = 0;
		for (int i = 0; i < numa; i++) {
			sum += table[i][ao[i]];
		}
		//System.out.println(sum);
		return sum;
	}
	
	
	public static void main(String[] args) {
//		int[][] matrix = new int[][]{
//				{19,88,91,29,63,33,30,5, 6, 31}, {7,29,35,71,93,85,95, 76, 22, 2},{48, 64, 70, 50, 88, 22, 61 ,20, 34, 51},
//				{80, 70 ,48 ,34 ,16 ,88 ,47 ,45 ,82 ,82},{80, 97, 25, 17, 17, 49, 19, 56, 44, 95},
//				{1,46,19,24,35,62,80, 72, 0 ,35},{63 ,17 ,18 ,51 ,62 ,19 ,86, 50, 94, 92},
//				{23, 86, 20, 96, 17, 20, 30, 37, 55, 15},{39,91,12,24,15,19,91, 0, 29, 37},
//				{95, 87, 36, 25, 81, 19, 27, 16, 29, 97}
//		
//		};
//		assign(matrix);
		
//		Random r = new Random();
//		for (int n = 2; n <= 256; n *= 2) {
//			int sum = 0;
//			for (int iter = 0; iter < 1000; iter++) {
//				int[][] matrix = new int[n][n];
//				for (int i = 0; i < n; i++) {
//					for (int j = 0; j < n; j++) {
//						matrix[i][j] = r.nextInt(100);
//					}
//				}
//				sum += assign(matrix);
//			}
//			System.out.println(n + " : " + (double)sum / (1000 * n));
//		}
		
		
		Random r = new Random();
//		for (int m = 10; m <= 1E7; m *= 10) {
//			int n = 256;
//			long sum = 0;
//			for (int iter = 0; iter < 100; iter++) {
//				int[][] matrix = new int[n][n];
//				for (int i = 0; i < n; i++) {
//					for (int j = 0; j < n; j++) {
//						matrix[i][j] = r.nextInt(m);
//					}
//				}
//				long a = System.currentTimeMillis();
//				assign(matrix);
//				long b = System.currentTimeMillis();
//				sum = sum + b - a;
//			}
//			System.out.println((double)sum / 100);
//		}
		PrintWriter writer;
		try {
			writer = new PrintWriter("random.dat", "UTF-8");
			writer.println("param m := 256;");
			writer.println();
			writer.println("param n := 256;");
			writer.println();
			int n = 256;
			int m = 1000000;
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = r.nextInt(m);
				}
			}
			writer.print("param c : ");
			for (int i = 1; i < 256; i++) {
				writer.print(i + " ");
			}
			writer.println(256 + ":=");
			for (int i = 0; i < 255; i++) {
				writer.print((i + 1) + " ");
				for (int j = 0; j < 255; j++) {
					writer.print(matrix[i][j] + " ");
				}
				writer.println(matrix[i][255]);
			}
			writer.print(256 + " ");
			for (int j = 0; j < 255; j++) {
				writer.print(matrix[255][j] + " ");
			}
			writer.print(matrix[255][255] + ";");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
