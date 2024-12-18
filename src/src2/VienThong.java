package src2;

import java.util.Scanner;

public class VienThong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N;
		char[][] matrix;
		boolean[][] checkHoDan;

		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			matrix = new char[M][N];
			checkHoDan = new boolean[M][N];

			int result = 0;
			String line;

			for (int i = 0; i < M; i++) {
				line = sc.next();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 'A') {
						handleCheckHoDan(checkHoDan, i, j, 1, M, N);
					} else if (matrix[i][j] == 'B') {
						handleCheckHoDan(checkHoDan, i, j, 2, M, N);
					} else if (matrix[i][j] == 'C') {
						handleCheckHoDan(checkHoDan, i, j, 3, M, N);
					}
				}
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 'H' && !checkHoDan[i][j]) {
						result++;						
					}
				}
			}

			System.out.println("#" + (tc + 1) + " " + result);
		}
	}

	private static boolean handleCheckHoDan(boolean[][] checkHoDan, int x, int y, int range, int M,
			int N) {
		for (int i = 1; i <= range; i++) {
//			Trên
			if (x - i >= 0) {
				checkHoDan[x - i][y] = true;
			}
//			Phải
			if (y + i < N) {
				checkHoDan[x][y + i] = true;
			}
//			Dưới
			if (x + i < M) {
				checkHoDan[x + i][y] = true;
			}
//			Trái
			if (y - i >= 0) {
				checkHoDan[x][y - i] = true;
			}
		}
		return checkHoDan[x][y] = true;
	}

}
