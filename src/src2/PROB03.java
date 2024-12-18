package src2;

import java.util.Scanner;

public class PROB03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N, H, W;
		int[][] matrix;
		
		for (int tc = 0; tc < T; tc++) {
			int sumMaximum = 0;
			H = sc.nextInt();
			W = sc.nextInt();
			M = sc.nextInt();
			N = sc.nextInt();
			
			matrix = new int[M][N];
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			for (int h = 0; h <= M - H; h++) {
				for (int k = 0; k <= N - W; k++) {
					int sumCurrent = sumCoverRectangle(matrix, h, k, H, W);
					if(sumMaximum < sumCurrent) {
						sumMaximum = sumCurrent;
					}
				}
			}
		
			System.out.println("#" + (tc + 1) + " " +sumMaximum);
		}

	}

	private static int sumCoverRectangle(int[][] matrix, int startRow, int startCol, int H, int W) {
		int sum = 0;
		
		for (int i = startRow; i < startRow + H; i++) {
			for (int j = startCol; j < startCol + W; j++) {
				
				if(matrix[i][j] % 2 == 0) {
					if ((i >= startRow + 1 && i < startRow + H - 1) && (j >= startCol + 1 && j < startCol + W - 1)) {
						continue;
					}
					
					sum += matrix[i][j];
				}
			}
		}
		return sum;
	}

}
